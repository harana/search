use std::path::Path;

use harana_common::anyhow::Result;
use harana_common::file_format::FileFormat;
use harana_common::log::debug;
use harana_search_extensions::extensions::Extensions;
use tauri;
use tauri::{AppHandle, Wry};

use crate::{PREVIEW_WINDOW, SEARCH_WINDOW};
use crate::windows_main;

#[tauri::command]
pub fn show_preview(app_handle: AppHandle<Wry>, document: String) -> Result<(), String> {
    debug!("Command: search->show_preview");
    windows_main::disable_auto_hide(app_handle);
    let window = PREVIEW_WINDOW.get().unwrap();
    window.set_focus().unwrap();
    window.center().unwrap();
    Ok(())
}

#[tauri::command]
pub fn hide_preview(app_handle: AppHandle<Wry>) -> Result<(), String> {
    debug!("Command: search->hide_preview");
    windows_main::enable_auto_hide(app_handle);
    let search_window = SEARCH_WINDOW.get().unwrap();
    let preview_window = PREVIEW_WINDOW.get().unwrap();
    search_window.set_focus().unwrap();
    preview_window.hide().unwrap();
    Ok(())
}

#[tauri::command]
pub fn get_viewer(path: String) -> String {
    let path = Path::new(path.as_str());
    let format = FileFormat::from_file(path.clone()).ok();
    let extension = path.extension().and_then(|e| e.to_str()).unwrap_or_default();
    let viewer = Extensions::viewer(format, extension);
    viewer.to_string()
}