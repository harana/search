use std::{env};
use std::fs::File;
use std::path::PathBuf;

use harana_common::anyhow::Result;
use harana_common::hashbrown::HashMap;
use harana_common::log::{debug};
use harana_common::serde_json;
use harana_database::search_categories_list::search_categories_list;
use harana_database::search_categories_update::search_categories_update;
use harana_document::document::Document;
use tauri;
use tauri::{AppHandle, Wry};

use crate::handler_system::{get_app_demos_path};
use crate::handlers::database_core;
use crate::INDEX_SEARCHER;

#[tauri::command]
pub async fn search(app_handle: AppHandle<Wry>, query: String) -> HashMap<String, Vec<Document>> {
    debug!("Command: indexer->search: {}", query);

    if env::var("HARANA_DEMO").is_ok() {
        let demo_path = get_app_demos_path(app_handle);
        let demo_file_path = PathBuf::from(demo_path.clone()).join(format!("{}.json", query));
        if demo_file_path.exists() {
            let demo_file = File::open(demo_file_path).unwrap();
            serde_json::from_reader(demo_file).unwrap()
        } else {
            HashMap::new()
        }
    } else {
        if query.len() >= 3 {
            INDEX_SEARCHER.get().unwrap().search(vec!(
                "local-application".to_string(),
                "local-archive".to_string(),
                "local-audio".to_string(),
                "local-book".to_string(),
                "local-calendar".to_string(),
                "local-certificate".to_string(),
                "local-code".to_string(),
                "local-codeartifact".to_string(),
                "local-data".to_string(),
                "local-diskimage".to_string(),
                "local-document".to_string(),
                "local-email".to_string(),
                "local-folder".to_string(),
                "local-font".to_string(),
                "local-game".to_string(),
                "local-graphics".to_string(),
                "local-hardware".to_string(),
                "local-image".to_string(),
                "local-map".to_string(),
                "local-other".to_string(),
                "local-science".to_string(),
                "local-screenshot".to_string(),
                "local-video".to_string()
            ), query)
                .await
                .into_iter()
                .filter(|(_id, documents)| { !documents.is_empty() })
                .collect()
        } else {
            HashMap::new()
        }
    }
}

#[tauri::command]
pub async fn list_search_categories() -> Result<String, String> {
    debug!("Command: search->search_categories");
    database_core(|c| {
        let search_categories = search_categories_list(c)?;
        Ok(serde_json::to_string(&search_categories).unwrap().to_string())
    }).await.map_err(|e| e.to_string())
}

#[tauri::command]
pub async fn update_search_category(name: String, enabled: bool, position: u32) -> Result<(), String> {
    debug!("Command: settings->update_search_category");
    database_core(move |c| {
        search_categories_update(c, name, enabled, position)
    }).await.map_err(|e| e.to_string())
}