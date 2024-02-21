use harana_common::log::debug;
use tauri;
use tauri::{AppHandle, LogicalSize, Manager, Size, Wry};

use crate::{PREVIEW_WINDOW, SEARCH_WINDOW};

#[tauri::command]
pub fn get_app_icons_path(app_handle: AppHandle<Wry>) -> String {
    debug!("Command: system->get_app_icons_path");
    let app_data_dir = app_handle.path_resolver().app_data_dir().unwrap();
    app_data_dir.join("appicons").to_str().unwrap().to_string()
}

#[tauri::command]
pub fn get_app_assets_path(app_handle: AppHandle<Wry>) -> String {
    debug!("Command: system->get_app_assets_path");
    let assets_dir = app_handle.path_resolver().resolve_resource("assets").unwrap();
    assets_dir.to_str().unwrap().to_string()
}

#[tauri::command]
pub fn get_previews_path(app_handle: AppHandle<Wry>) -> String {
    debug!("Command: system->get_previews_path");
    let app_data_dir = app_handle.path_resolver().app_data_dir().unwrap();
    app_data_dir.join("previews").to_str().unwrap().to_string()
}

#[tauri::command]
pub fn get_thumbnails_path(app_handle: AppHandle<Wry>) -> String {
    debug!("Command: system->get_thumbnails_path");
    let app_data_dir = app_handle.path_resolver().app_data_dir().unwrap();
    app_data_dir.join("thumbnails").to_str().unwrap().to_string()
}

#[tauri::command]
pub fn update_metric() {
    debug!("Command: system->update_metric");
}

#[tauri::command]
pub fn update_window_size(width: f64, height: f64, app_handle: AppHandle) {
    debug!("Command: system->update_window_size: {} x {}", width, height);
    let window = app_handle.get_window("search").unwrap();
    window.set_size(Size::Logical(LogicalSize { width, height })).unwrap();
}

#[tauri::command]
pub fn emit_search_message(name: String, payload: String) {
    let window = SEARCH_WINDOW.get().unwrap();
    // window.state::<RpcEmit>().emit("search", name.as_str(), payload);
}

#[tauri::command]
pub fn emit_preview_message(name: String, payload: String) {
    let window = PREVIEW_WINDOW.get().unwrap();
    // window.state::<RpcEmit>().emit("preview", name.as_str(), payload);
}

#[tauri::command]
pub fn emit_thumbnail_message(name: String, payload: String) {
    // window.state::<RpcEmit>().emit("thumbnail", name.as_str(), payload);
}

#[tauri::command]
pub fn open_url(url: String) -> Result<(), String> {
    open::that(url).map_err(|e| e.to_string())
}

#[tauri::command]
pub fn quit_app(app_handle: AppHandle<Wry>) {
    app_handle.exit(0)
}