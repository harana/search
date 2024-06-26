#![cfg_attr(not(debug_assertions), windows_subsystem = "windows")]

use std::time::Duration;
use color_eyre::owo_colors::OwoColorize;

use harana_application::manager::ApplicationManager;
use harana_common::{rand, serde_json, tauri};
use harana_common::hashbrown::HashMap;
use harana_common::log::info;
use harana_common::num_cpus;
use harana_common::thread_pools::build_default_pools;
use harana_common::uuid::Uuid;
use harana_database::manager::DatabaseManager;
use harana_database::state_get::state_get;
use harana_job::handler::JobHandler;
use harana_job::manager::JobManager;
use harana_search_file::manager::FileManager;
use harana_search_index::manager::IndexManager;
use harana_search_index::searcher::IndexSearcher;
use harana_search_index::thumbnailer::IndexThumbnailer;
use harana_search_jobs::job_hash::JobHandlerHash;
use harana_search_jobs::job_index::JobHandlerIndex;
use harana_search_jobs::job_thumbnail::JobHandlerThumbnail;
use keyring::Entry;
use rand::distributions::Alphanumeric;
use rand::Rng;
use tauri::{async_runtime, Manager};
use crate::directories::setup_directories;

use crate::globals::*;
use crate::handler_state::{get_state, update_state};
use crate::handlers::{invoke_handler};
use crate::logging::logging;
use crate::state::State;
use crate::system_tray::{create_system_tray, on_system_tray_event};
use crate::windows::{create_windows, save_window_positions};

mod directories;
mod globals;
mod handler_account;
mod handler_application;
mod handler_ai_models;
mod handler_auth;
mod handler_billing;
mod handler_developer;
mod handler_folders;
mod handler_indexer;
mod handler_integrations;
mod handler_open;
mod handler_preview;
mod handler_rules;
mod handler_search;
mod handler_settings;
mod handler_state;
mod handler_system;
mod handler_thumbnail;
mod handler_user;
mod handler_welcome;
mod handler_windows;
mod handlers;
mod logging;
mod screen;
mod state;
mod system_tray;
mod windows;
mod windows_main;

#[cfg(target_os = "macos")]
mod windows_main_mac;

fn main() {
    color_eyre::install().expect("Failed to install color eyre");
    log_panics::init();

    info!("Initialising Tauri ..");

    #[cfg(target_os = "macos")]
    macos_app_nap::prevent();

    // Log errors to Sentry
    // let sentry_client = sentry_tauri::sentry::init((
    //     "https://2c4b44988d0234317f4b8706666f97bf@o200099.ingest.sentry.io/4506227393298432",
    //     sentry_tauri::sentry::ClientOptions { release: sentry_tauri::sentry::release_name!(), ..Default::default() }
    // ));
    // let _guard = sentry_tauri::minidump::init(&sentry_client);

    tauri::Builder::default()
        // .invoke_system(rpc_server.initialization_script(), RpcServer::responder())
        .invoke_handler(invoke_handler)
        .manage(State::default())
        .on_system_tray_event(|app_handle, event| on_system_tray_event(app_handle, event))
        .system_tray(create_system_tray().expect("Failed to build system tray"))
        // .plugin(sentry_tauri::plugin())
        .plugin(logging())
        .setup(move |app| {
            // rpc_server.start(app.handle());
            // Setup thread pools
            build_default_pools().expect("Failed to setup thread pools");

            // Create directories
            setup_directories(app.handle());

            // Start core managers
            async_runtime::block_on(async {
                info!("Starting core managers ..");
                let application_icons_path = APPLICATION_ICONS_PATH.get().unwrap();
                let database_path = DATABASE_PATH.get().unwrap();

                let index_path = INDEX_PATH.get().unwrap();
                let index_declarations_path = INDEX_DECLARATIONS_PATH.get().unwrap();
                let tauri_data_path = TAURI_DATA_PATH.get().unwrap();
                let thumbnails_path = THUMBNAILS_PATH.get().unwrap();

                let _ = APP_HANDLE.set(app.handle());
                let _ = APPLICATION_MANAGER.set(ApplicationManager::new(application_icons_path).await);
                let _ = DATABASE_MANAGER.set(DatabaseManager::new(database_path).await);
                let _ = INDEX_MANAGER.set(IndexManager::new(index_path, index_declarations_path).await);
                let _ = INDEX_SEARCHER.set(IndexSearcher::new(INDEX_MANAGER.get().unwrap()).await);
                let _ = INDEX_THUMBNAILER.set(IndexThumbnailer::new(thumbnails_path, 400, 400).await);


                // let entry = Entry::new("Harana", "index").unwrap();
                // let entry_password = entry.get_password();
                // if entry_password.is_err() {
                //     let mut rng = rand::thread_rng();
                //     let password: String = rng.sample_iter(&Alphanumeric).take(30).map(char::from).collect();
                //     entry.set_password(password.as_str()).unwrap();
                // }
                INDEX_MANAGER.get().unwrap().create_indexes("temp".to_string()).await;
            });

            // Generate user id if needed
            async_runtime::block_on(async {
                if get_state("user_id".to_string()).await.unwrap().is_empty() {
                    let _ = update_state("user_id".to_string(), Uuid::new_v4().to_string()).await;
                }
            });

            // // Start user interface
            info!("Creating windows ..");
            async_runtime::block_on(async {
                let _ = create_windows(app).await;
            });

            // Start job manager
            async_runtime::block_on(async {
                info!("Starting job manager ..");
                let tauri_data_path = TAURI_DATA_PATH.get().unwrap();
                let thumbnails_path = THUMBNAILS_PATH.get().unwrap();

                let _ = INDEX_THUMBNAILER.set(IndexThumbnailer::new(thumbnails_path, 400, 400).await);

                let hash_handler: Box<dyn JobHandler> = Box::new(JobHandlerHash::new(DATABASE_MANAGER.get().unwrap(), INDEX_MANAGER.get().unwrap()));
                let index_handler: Box<dyn JobHandler> = Box::new(JobHandlerIndex::new(DATABASE_MANAGER.get().unwrap(), INDEX_MANAGER.get().unwrap()));
                let thumbnail_handler: Box<dyn JobHandler> = Box::new(JobHandlerThumbnail::new(APP_HANDLE.get().unwrap(), DATABASE_MANAGER.get().unwrap(), INDEX_THUMBNAILER.get().unwrap()));

                let job_handlers: HashMap<String, Box<dyn JobHandler>> = HashMap::from([
                    ("hash".to_string(), hash_handler),
                    ("index".to_string(), index_handler),
                    ("thumbnail".to_string(), thumbnail_handler)
                ]);

                let _ = JOB_MANAGER.set(JobManager::new(
                    DATABASE_PATH.get().unwrap(),
                    1,
                    // num_cpus::get() / 4,
                    1,
                    DATABASE_MANAGER.get().unwrap(),
                    job_handlers,
                    bool_setting("indexer_pause_ac_power_required").await,
                    bool_setting("indexer_pause_battery_life_remaining_enabled").await,
                    int_setting("indexer_pause_battery_life_remaining_value").await,
                    bool_setting("indexer_pause_cpu_maximum_temperature_enabled").await,
                    int_setting("indexer_pause_cpu_maximum_temperature_value").await,
                    bool_setting("indexer_pause_cpu_maximum_usage_enabled").await,
                    int_setting("indexer_pause_cpu_maximum_usage_value").await,
                    bool_setting("indexer_pause_hours_between_enabled").await,
                    int_setting("indexer_pause_hours_between_start").await,
                    int_setting("indexer_pause_hours_between_end").await
                ).await);
                let _ = FILE_MANAGER.set(FileManager::new(DATABASE_MANAGER.get().unwrap(), INDEX_MANAGER.get().unwrap(), JOB_MANAGER.get().unwrap()).await);
            });

            // Update onboarding state
            async_runtime::block_on(async {
                unsafe {
                    ONBOARDED = DATABASE_MANAGER.get().unwrap().core(move |c| state_get(c, "has_onboarded".to_string()))
                        .await.unwrap().unwrap_or("false".to_string()) == "true";

                    if !ONBOARDED {
                        JOB_MANAGER.get().unwrap().pause();
                    }
                }
            });

            // Start saving window positions
            info!("Saving window positions ..");
            async_runtime::spawn(async {
                let mut previous_pos = "".to_string();
                loop {
                    let current_positions = MAIN_WINDOW_POSITIONS.get().unwrap();
                    let new_pos = serde_json::to_string(current_positions).unwrap();

                    if previous_pos != new_pos {
                        let _ = save_window_positions().await;
                        previous_pos = new_pos;
                    }
                    tokio::time::sleep(Duration::from_secs(1)).await;
                }
            });

            Ok(())

        })
        .build(tauri::generate_context!()).expect("Invalid Tauri configuration")
        .run(|app, event| match event {
            tauri::RunEvent::WindowEvent {
                label,
                event: win_event,
                ..
            } => match win_event {
                tauri::WindowEvent::CloseRequested { api, .. } => {
                    let win = app.get_window(label.as_str()).unwrap();
                    win.hide().unwrap();
                    api.prevent_close();
                }
                _ => {}
            },
            tauri::RunEvent::ExitRequested { api, .. } => {},
            _ => {}
        })
}