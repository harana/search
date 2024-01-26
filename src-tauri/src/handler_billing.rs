use harana_common::anyhow::Result;
use harana_common::log::debug;
use tauri;

#[tauri::command]
pub async fn list_invoices() -> Result<String, String> {
    debug!("Command: billing->list_invoices");
    Ok("{}".to_string())
}

#[tauri::command]
pub fn download_invoice() {
    debug!("Command: billing->download_invoice");
}

#[tauri::command]
pub fn payment_method() {
    debug!("Command: billing->payment_method");
}

#[tauri::command]
pub fn update_payment_method() {
    debug!("Command: billing->update_payment_method");
}

#[tauri::command]
pub fn plan() {
    debug!("Command: billing->plan");
}

#[tauri::command]
pub fn cancel_plan() {
    debug!("Command: billing->cancel_plan");
}

#[tauri::command]
pub fn upgrade_plan() {
    debug!("Command: billing->upgrade_plan");
}