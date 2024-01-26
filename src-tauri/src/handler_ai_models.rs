use harana_common::anyhow::Result;
use harana_common::log::debug;
use harana_common::serde_json;
use harana_database::ai_models_list::ai_models_list;
use harana_database::ai_models_update::ai_models_update;
use tauri;

use crate::handlers::database_core;

#[tauri::command]
pub async fn list_ai_models() -> Result<String, String> {
    debug!("Command: ai_models->list_ai_models");
    database_core(move |c| {
        let rules = ai_models_list(c)?;
        Ok(serde_json::to_string(&rules).unwrap().to_string())
    }).await
}

#[tauri::command]
pub async fn update_ai_model(id: String, enabled: bool) -> Result<(), String> {
    debug!("Command: ai_models->update_ai_model");
    database_core(move |c| {
        ai_models_update(c, id, enabled)
    }).await
}