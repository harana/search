use harana_common::{serde_json, tauri};
use harana_common::anyhow::Result;
use harana_common::log::debug;
use harana_database::developer_sources_list::developer_sources_list;
use harana_database::developer_sources_update::developer_sources_update;

use crate::handlers::database_core;

#[tauri::command]
pub async fn list_developer_sources() -> Result<String, String> {
    debug!("Command: developer_sources->list_developer_sources");
    database_core(|c| {
        let rules = developer_sources_list(c)?;
        Ok(serde_json::to_string(&rules).unwrap().to_string())
    }).await
}

#[tauri::command]
pub async fn update_developer_source(name: String, enabled: bool) -> Result<(), String> {
    debug!("Command: developer_sources->update_developer_source");
    database_core(move |c| {
        developer_sources_update(c, name, enabled)
    }).await?;
    Ok(())
}