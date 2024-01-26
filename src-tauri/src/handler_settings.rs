use harana_common::anyhow::Result;
use harana_common::log::debug;
use harana_common::tauri;
use harana_database::settings_get::settings_get;
use harana_database::settings_upsert::settings_upsert;
use tauri::AppHandle;
use crate::globals::{SEARCH_WINDOW, SETTINGS_WINDOW};
use crate::handlers::database_core;
use crate::windows_mac::{hide_search, show_search};

#[tauri::command]
pub async fn get_setting(key: String) -> Result<String, String> {
    debug!("Command: settings->get_setting");
    database_core(move |c| {
        match settings_get(c, key)? {
            None => Ok(String::new()),
            Some(s) => Ok(s)
        }
    }).await
}

#[tauri::command]
pub async fn update_setting(key: String, value: String) -> Result<(), String> {
    debug!("Command: settings->update_setting");

    database_core(move |c| {
        settings_upsert(c, key, value)
    }).await
}

#[tauri::command]
pub fn show_settings(app_handle: AppHandle) {
    hide_search(app_handle);
    let _ = SETTINGS_WINDOW.get().unwrap().show();
}

#[tauri::command]
pub fn hide_settings(app_handle: AppHandle) {
    let _ = SETTINGS_WINDOW.get().unwrap().hide();
    show_search(app_handle);
}