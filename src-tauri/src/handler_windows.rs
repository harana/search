use harana_common::log::debug;
use tauri;
use tauri::{AppHandle, LogicalSize, Manager, Size};

use crate::windows_main;
use crate::windows::show_initial_window;

#[tauri::command]
pub fn update_window_size(label: String, width: f64, height: f64, app_handle: AppHandle) {
    debug!("Command: windows->update_window_size: {} x {}", width, height);
    let window = app_handle.get_window(label.as_str()).unwrap();
    window.set_size(Size::Logical(LogicalSize { width, height })).unwrap();
}

#[tauri::command]
pub async fn window_ready(label: String, _app_handle: AppHandle) {
    debug!("Command: windows->window_ready: {}", label);
}

#[tauri::command]
pub async fn show_window(label: String, app_handle: AppHandle) {
    debug!("Command: windows->show_window: {}", label);

    if label == "main" {
        windows_main::show_main(app_handle)
    } else {
        let window = app_handle.get_window(label.as_str()).unwrap();
        window.set_focus().unwrap();
        window.center().unwrap();
        window.show().unwrap();
    }
}

#[tauri::command]
pub async fn hide_window(label: String, app_handle: AppHandle) {
    debug!("Command: windows->hide_window: {}", label);
    let window = app_handle.get_window(label.as_str()).unwrap();
    window.hide().unwrap();
}