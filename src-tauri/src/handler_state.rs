use harana_common::anyhow::Result;
use harana_common::log::debug;
use harana_common::tauri;
use harana_database::state_get::state_get;
use harana_database::state_upsert::state_upsert;
use crate::handlers::database_core;

#[tauri::command]
pub async fn get_state(key: String) -> Result<String, String> {
    debug!("Command: state->get_state");
    database_core(move |c| {
        match state_get(c, key)? {
            None => Ok(String::new()),
            Some(str) => Ok(str)
        }
    }).await
}

#[tauri::command]
pub async fn update_state(key: String, value: String) -> Result<(), String> {
    debug!("Command: state->update_state");
    database_core(move |c| {
        state_upsert(c, key, value)
    }).await
}