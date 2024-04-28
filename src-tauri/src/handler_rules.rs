#[cfg(target_os = "linux")]
use std::{fs::metadata, path::PathBuf};

use harana_common::anyhow::Result;
use harana_common::{serde_json, tauri};
use harana_common::log::debug;
use harana_database::rules_list::rules_list;

#[cfg(target_os = "linux")]
use fork::{daemon, Fork};
use crate::handlers::database_core;

#[tauri::command]
pub async fn list_rules() -> Result<String, String> {
    debug!("Command: indexer->rules_list");
    database_core(|c| {
        let rules = rules_list(c)?;
        Ok(serde_json::to_string(&rules).unwrap().to_string())
    }).await
}

// #[tauri::command]
// pub async fn update_rules(rules_json: String) -> Result<(), String> {
//     debug!("Command: indexer->update_rules");
//     let rules_map: HashMap<String, Value> = serde_json::from_str(rules_json.as_str()).unwrap();
//     let mut results = Vec::new();
//
//     rules_map.into_iter().for_each(|(k, v)| {
//         results.push(
//             DATABASE_MANAGER.get().unwrap().core(move |c| {
//                 rules_update(c, k, v.to_string(), HaranaValueType::String)
//             })
//         );
//     });
//
//     try_join_all(results).await.map(|_| ())
// }