use harana_common::anyhow::Result;
use harana_common::log::debug;
use tauri;

#[tauri::command]
pub fn list_integrations() {
    debug!("Command: indexer->integrations");

}

#[tauri::command]
pub fn add_integration() {
    debug!("Command: indexer->add_integration");

}

#[tauri::command]
pub fn remove_integration() {
    debug!("Command: indexer->remove_integration");

}