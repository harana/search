use tauri;
use crate::globals::{SIGNUP_WINDOW};

#[tauri::command]
pub fn show_signup() -> anyhow::Result<(), String> {
    let window = SIGNUP_WINDOW.get().unwrap();
    window.set_focus().unwrap();
    window.center().unwrap();
    window.show().unwrap();
    Ok(())
}

#[tauri::command]
pub async fn hide_signup() -> anyhow::Result<(), String> {
    let window = SIGNUP_WINDOW.get().unwrap();
    window.hide().unwrap();
    Ok(())
}