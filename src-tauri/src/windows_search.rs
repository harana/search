use std::env;
use harana_database::settings_get::settings_get;
use tauri::{AppHandle, Wry};
use crate::globals::DATABASE_MANAGER;
#[cfg(target_os = "macos")]
use crate::windows_mac;

pub async fn init_search_panel(app_handle: AppHandle<Wry>) {

    let debug = env::var("HARANA_DEBUG").is_ok();

    let always_center = DATABASE_MANAGER.get().unwrap().core(move |c|
        settings_get(c, "appearance_always_center_window".to_string())
    ).await.unwrap().map(|v| v == "1").unwrap_or(false);

    #[cfg(target_os = "macos")]
    windows_mac::init_search_panel(app_handle.clone(), always_center, debug);

    if debug {
        disable_auto_hide(app_handle.clone());
    }
}

#[tauri::command]
pub fn show_search(app_handle: AppHandle<Wry>) {
    #[cfg(target_os = "macos")]
    windows_mac::show_search(app_handle)
}

#[tauri::command]
pub fn hide_search(app_handle: AppHandle<Wry>) {
    #[cfg(target_os = "macos")]
    windows_mac::hide_search(app_handle)
}

pub fn enable_auto_hide(app_handle: AppHandle<Wry>) {
    #[cfg(target_os = "macos")]
    windows_mac::enable_auto_hide(app_handle)
}

pub fn disable_auto_hide(app_handle: AppHandle<Wry>) {
    #[cfg(target_os = "macos")]
    windows_mac::disable_auto_hide(app_handle)
}