use std::env;
use harana_common::anyhow::Result;
use harana_common::dashmap::DashMap;
use harana_common::serde_json;
use harana_database::settings_get::settings_get;
use harana_database::state_get::state_get;
use harana_database::state_upsert::state_upsert;
use tauri::{App, AppHandle, Manager, Wry};

use crate::globals::*;
use crate::handler_windows::show_window;
use crate::system_tray::{disable_system_tray, enable_system_tray};

use crate::windows_main;

pub async fn create_windows(app: &mut App) -> Result<()> {
    let debug = env::var("HARANA_DEBUG").is_ok();

    // Load previous search positions
    let positions = DATABASE_MANAGER.get().unwrap().core(|c| Ok({
        if let Some(json) = state_get(c, "window_positions".to_string())? {
            serde_json::from_str(json.as_str()).unwrap()
        }else{
            DashMap::new()
        }
    })).await;
    MAIN_WINDOW_POSITIONS.get_or_init(|| positions.unwrap());

    #[cfg(target_os = "macos")]
    app.set_activation_policy(tauri::ActivationPolicy::Prohibited);

    let billing_window = app.get_window("billing").unwrap();
    let _ = BILLING_WINDOW.set(billing_window);

    let integrations_window = app.get_window("integrations").unwrap();
    let _ = INTEGRATIONS_WINDOW.set(integrations_window);

    let main_window = app.get_window("main").unwrap();
    let _ = MAIN_WINDOW.set(main_window.clone());

    let always_center = DATABASE_MANAGER.get().unwrap().core(move |c|
        settings_get(c, "appearance_always_center_window".to_string())
    ).await.unwrap().map(|v| v == "1").unwrap_or(false);

    windows_main::init_main_panel(app.handle().clone(), always_center, debug);

    if debug {
        windows_main::disable_auto_hide(app.handle().clone());
    }

    let preview_window = app.get_window("preview").unwrap();
    let _ = PREVIEW_WINDOW.set(preview_window);

    let settings_window = app.get_window("settings").unwrap();
    let _ = SETTINGS_WINDOW.set(settings_window.clone());

    let signup_window = app.get_window("signup").unwrap();
    let _ = SIGNUP_WINDOW.set(signup_window);

    let welcome_window = app.get_window("welcome").unwrap();
    let _ = WELCOME_WINDOW.set(welcome_window);

    show_initial_window(app.handle()).await.unwrap();

    Ok(())
}

pub async fn show_initial_window(app_handle: AppHandle) -> Result<()> {
    // Has Onboarded
    let has_onboarded = DATABASE_MANAGER.get().unwrap().core(move |c|
        state_get(c, "has_onboarded".to_string())
    ).await.unwrap().is_some();

    if has_onboarded {
        let shortcut_key = DATABASE_MANAGER.get().unwrap().core(move |c|
            settings_get(c, "appearance_shortcut_key".to_string())
        ).await?.unwrap();

        windows_main::register_shortcut(app_handle.clone(), shortcut_key.to_string());
        enable_system_tray(app_handle.clone()).unwrap();
        show_window("main".to_string(), app_handle.clone()).await;
    }else{
        disable_system_tray(app_handle.clone()).unwrap();
        show_window("welcome".to_string(), app_handle.clone()).await;
    }
    Ok(())
}

pub async fn save_window_positions() {
    let positions = MAIN_WINDOW_POSITIONS.get().unwrap();
    let window_positions = serde_json::to_string(positions).unwrap();
    let _ = DATABASE_MANAGER.get().unwrap().core(move |c| {
        state_upsert(c, "window_positions".to_string(), window_positions)
    }).await;
}