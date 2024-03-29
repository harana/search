use harana_application::manager::Application;
use tauri;

use crate::globals::APPLICATION_MANAGER;

#[tauri::command]
pub async fn search_application(query: String) -> Option<Application> {
    if query.len() >= 3 {
        APPLICATION_MANAGER.get().unwrap().search(query.as_str()).await
    } else {
        None
    }
}