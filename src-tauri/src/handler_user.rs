use harana_common::anyhow::{Result};
use mid::get;

use crate::handler_state::get_state;

#[tauri::command]
pub fn get_device_id() -> Result<String, String> {
    get("293273abaf6fcb31d4a9b47b70a20b21133ff08852834c52c5f42ed8153b274a").map_err(|e| e.to_string())
}

#[tauri::command]
pub async fn get_user_id() -> Result<String, String> {
    get_state("user_id".to_string()).await
}