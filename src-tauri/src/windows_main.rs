use tauri::{AppHandle, Wry};
use crate::windows_main_mac;


pub fn init_main_panel(app_handle: AppHandle<Wry>, always_center: bool, show_devtools: bool) {
    #[cfg(target_os = "macos")]
    windows_main_mac::init_main_panel(app_handle, always_center, show_devtools)
}

pub fn show_main(app_handle: AppHandle<Wry>) {
    #[cfg(target_os = "macos")]
    windows_main_mac::show_main(app_handle)
}

pub fn hide_main(app_handle: AppHandle<Wry>) {
    #[cfg(target_os = "macos")]
    windows_main_mac::hide_main(app_handle)
}

pub fn enable_auto_hide(app_handle: AppHandle<Wry>) {
    #[cfg(target_os = "macos")]
    windows_main_mac::enable_auto_hide(app_handle)
}

pub fn disable_auto_hide(app_handle: AppHandle<Wry>) {
    #[cfg(target_os = "macos")]
    windows_main_mac::disable_auto_hide(app_handle)
}

pub fn register_shortcut(app_handle: AppHandle<Wry>, shortcut: String) {
    #[cfg(target_os = "macos")]
    windows_main_mac::register_shortcut(app_handle, shortcut)
}
