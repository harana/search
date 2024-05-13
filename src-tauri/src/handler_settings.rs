use harana_common::anyhow::Result;
use harana_common::log::debug;
use harana_common::tauri;
use harana_database::settings_get::settings_get;
use harana_database::settings_upsert::settings_upsert;
use crate::handlers::database_core;

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