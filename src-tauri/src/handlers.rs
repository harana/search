use harana_common::log::error;
use harana_database::rusqlite::Connection;
use tauri::Wry;
use crate::globals::DATABASE_MANAGER;

pub fn invoke_handler(invoke: tauri::Invoke<Wry>) {
    invoke_tauri_handlers(
        tauri::generate_handler![
            crate::handler_account::login,
            crate::handler_account::logout,
            crate::handler_ai_models::list_ai_models,
            crate::handler_ai_models::update_ai_model,
            crate::handler_application::search_application,
            crate::handler_auth::show_signup,
            crate::handler_auth::hide_signup,
            crate::handler_billing::list_invoices,
            crate::handler_billing::download_invoice,
            crate::handler_billing::payment_method,
            crate::handler_billing::update_payment_method,
            crate::handler_billing::plan,
            crate::handler_billing::cancel_plan,
            crate::handler_billing::upgrade_plan,
            crate::handler_developer::list_developer_sources,
            crate::handler_developer::update_developer_source,
            crate::handler_folders::list_private_folders,
            crate::handler_folders::add_private_folder,
            crate::handler_folders::delete_private_folder,
            crate::handler_folders::list_search_folders,
            crate::handler_folders::update_search_folder,
            crate::handler_folders::search_folders_status,
            crate::handler_indexer::pause_indexing,
            crate::handler_indexer::resume_indexing,
            crate::handler_indexer::indexer_statistics,
            crate::handler_integrations::list_integrations,
            crate::handler_integrations::add_integration,
            crate::handler_integrations::remove_integration,
            crate::handler_open::open_application,
            crate::handler_open::open_path,
            crate::handler_preview::show_preview,
            crate::handler_preview::hide_preview,
            crate::handler_preview::get_viewer,
            crate::handler_rules::list_rules,
            crate::handler_search::search,
            crate::handler_search::list_search_categories,
            crate::handler_search::update_search_category,
            crate::handler_settings::get_setting,
            crate::handler_settings::update_setting,
            crate::handler_settings::show_settings,
            crate::handler_settings::hide_settings,
            crate::handler_state::get_state,
            crate::handler_state::update_state,
            crate::handler_system::emit_preview_message,
            crate::handler_system::emit_search_message,
            crate::handler_system::get_app_icons_path,
            crate::handler_system::get_app_assets_path,
            crate::handler_system::get_previews_path,
            crate::handler_system::get_thumbnails_path,
            crate::handler_system::is_debug,
            crate::handler_system::is_demo,
            crate::handler_system::open_url,
            crate::handler_system::quit_app,
            crate::handler_system::update_metric,
            crate::handler_system::update_window_size,
            crate::handler_system::window_ready,
            crate::handler_thumbnail::get_document,
            crate::handler_thumbnail::has_thumbnail,
            crate::handler_thumbnail::save_thumbnail,
            crate::handler_user::get_device_id,
            crate::handler_user::get_user_id,
            crate::handler_welcome::get_onboarded,
            crate::handler_welcome::complete_onboarding,
            crate::handler_welcome::show_welcome,
            crate::handler_welcome::hide_welcome,
            crate::windows_main::show_search,
            crate::windows_main::hide_search
        ],
        invoke
    )
}

#[inline]
fn invoke_tauri_handlers<F, R: tauri::Runtime>(handler: F, invoke: tauri::Invoke<R>)
    where
        F: Fn(tauri::Invoke<R>) + Send + Sync + 'static,
{
    handler(invoke);
}

pub async fn database_core<F, R>(handler: F) -> Result<R, String> where
    F: FnOnce(&Connection) -> anyhow::Result<R> + Send + 'static,
    R: Send + 'static
{
    DATABASE_MANAGER.get().unwrap().core(move |connection| handler(connection))
        .await.map_err(|e| {
        error!("Database error due to: {}", e.to_string());
        e.to_string()
    })
}

pub async fn database_files<F, R>(handler: F) -> Result<R, String> where
    F: FnOnce(&Connection) -> anyhow::Result<R> + Send + 'static,
    R: Send + 'static
{
    DATABASE_MANAGER.get().unwrap().files(move |connection| handler(connection))
        .await.map_err(|e| {
        error!("Database error due to: {}", e.to_string());
        e.to_string()
    })
}