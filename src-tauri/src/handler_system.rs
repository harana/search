use harana_common::log::debug;
use std::env;
use tauri;
use tauri::{AppHandle, Wry};

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
pub fn get_app_demos_path(app_handle: AppHandle<Wry>) -> String {
    debug!("Command: system->get_app_demo_path");
    let demo_dir = app_handle.path_resolver().resolve_resource("assets").unwrap().join("demos");
    demo_dir.to_str().unwrap().to_string()
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
pub fn is_debug() -> String {
    env::var("HARANA_DEBUG").is_ok().to_string()
}

#[tauri::command]
pub fn is_demo() -> String {
    env::var("HARANA_DEMO").is_ok().to_string()
}

#[tauri::command]
pub fn open_url(url: String) -> Result<(), String> {
    open::that(url).map_err(|e| e.to_string())
}

#[tauri::command]
pub fn quit_app(app_handle: AppHandle<Wry>) {
    app_handle.exit(0)
}

#[tauri::command]
pub fn update_metric() {
    debug!("Command: system->update_metric");
}