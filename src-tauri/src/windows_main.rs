use objc_id::ShareId;
use tauri::{AppHandle, Wry};
use crate::windows_mac;
use crate::windows_mac::RawNSPanel;

pub fn init_main_panel(app_handle: AppHandle<Wry>, shortcut: String, always_center: bool) {
    #[cfg(target_os = "macos")]
    windows_mac::init_main_panel(app_handle, shortcut, always_center)
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

pub fn toggle_delegate(panel: ShareId<RawNSPanel>, on: bool) {
    #[cfg(target_os = "macos")]
    windows_mac::toggle_delegate(panel, on)
}