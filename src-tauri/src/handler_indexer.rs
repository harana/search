use harana_common::anyhow::Result;
use harana_common::{serde_json, tauri};
use harana_common::hashbrown::HashMap;
use harana_common::log::debug;
use harana_database::files_count_all::files_count_all;
use harana_database::files_count_index::files_count_index;
use crate::handlers::database_core;

#[tauri::command]
pub async fn pause_indexing() {
    debug!("Command: indexer->pause_indexing");
}

#[tauri::command]
pub async fn resume_indexing() {
    debug!("Command: indexer->resume_indexing");
}

#[tauri::command]
pub async fn rebuild_index() {
    debug!("Command: indexer->rebuild");
}

#[tauri::command]
pub async fn indexer_statistics() -> Result<String, String> {
    debug!("Command: indexer->indexer_statistics");

    let total = database_core(move |c| { files_count_all(c) }).await?;
    let indexed = database_core(move |c| { files_count_index(c) }).await?;

    let stats_map: HashMap<String, usize> = HashMap::from([
        ("total".to_string(), total),
        ("index".to_string(), indexed),
    ]);

    Ok(serde_json::to_string(&stats_map).unwrap().to_string())
}