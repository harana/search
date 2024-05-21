use std::path::Path;

use harana_common::anyhow::Result;
use harana_common::file_format::FileFormat;
use harana_common::log::debug;
use harana_search_extensions::extensions::Extensions;
use tauri;
use tauri::{AppHandle, Wry};

use crate::{MAIN_WINDOW, PREVIEW_WINDOW, windows_main};

#[tauri::command]
pub fn get_viewer(path: String) -> String {
    let path = Path::new(path.as_str());
    let format = FileFormat::from_file(path).ok();
    let extension = path.extension().and_then(|e| e.to_str()).unwrap_or_default();
    let viewer = Extensions::viewer(format, extension);
    viewer.to_string()
}