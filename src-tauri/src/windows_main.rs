use tauri::{AppHandle, Wry};
#[cfg(target_os = "macos")]
use crate::windows_mac;

pub fn init_main_panel(app_handle: AppHandle<Wry>, always_center: bool, show_devtools: bool) {
    #[cfg(target_os = "macos")]
    windows_mac::init_main_panel(app_handle, always_center, show_devtools)
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