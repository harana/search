use harana_common::log::debug;
use tauri;

#[tauri::command]
pub fn login() {
    debug!("Command: account->login");

}

#[tauri::command]
pub fn logout() {
    debug!("Command: account->logout");

}

#[tauri::command]
pub fn has_valid_jwt() {
    debug!("Command: account->update_account");
}