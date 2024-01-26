use harana_common::anyhow::Result;
use harana_common::{serde_json, tauri};
use harana_common::hashbrown::HashMap;
use harana_common::log::debug;
use harana_database::private_folders_add::private_folders_add;
use harana_database::private_folders_delete::private_folders_delete;
use harana_database::private_folders_list::private_folders_list;
use harana_database::search_folders_list::search_folders_list;
use harana_database::search_folders_update_enabled::search_folders_update_enabled;

use crate::globals::{DATABASE_MANAGER, FILE_MANAGER};
use crate::handlers::database_core;

#[tauri::command]
pub async fn list_private_folders() -> Result<String, String> {
    debug!("Command: folders->list-private_folders");
    database_core(|c| {
        let rules = private_folders_list(c)?;
        Ok(serde_json::to_string(&rules).unwrap().to_string())
    }).await
}

#[tauri::command]
pub async fn add_private_folder(path: String) -> Result<i64, String> {
    debug!("Command: folders->add_private_folder");
    database_core(move |c| {
        private_folders_add(c, path)
    }).await
}

#[tauri::command]
pub async fn delete_private_folder(path: String) -> Result<(), String> {
    debug!("Command: folders->update_search_folder");
    database_core(move |c| {
        private_folders_delete(c, path)
    }).await
}

#[tauri::command]
pub async fn list_search_folders() -> Result<String, String> {
    debug!("Command: folders->list_search_folders");
    database_core(|c| {
        let search_folders = search_folders_list(c)?;
        Ok(serde_json::to_string(&search_folders).unwrap().to_string())
    }).await
}

#[tauri::command]
pub async fn update_search_folder(name_or_path: String, is_path: bool, enabled: bool) -> Result<(), String> {
    debug!("Command: folders->update_search_folder");
    let name = name_or_path.clone();
    if enabled {
        if !is_path {
            database_core(move |c| {
                search_folders_update_enabled(c, name_or_path, is_path, enabled)
            }).await?;

            FILE_MANAGER.get().unwrap().crawl(name).await.map_err(|e| e.to_string())?;
        }
    }
    Ok(())
}

#[tauri::command]
pub async fn search_folders_status() -> Result<HashMap<String, bool>, String> {
    database_core(move |c| {
        let map: HashMap<_, _> = search_folders_list(c)?.iter()
            .filter(|f| f.enabled)
            .map(|f| (f.name_or_path.clone(), f.crawled))
            .collect();
        Ok(map)
    }).await
}