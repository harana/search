use std::path::PathBuf;

use harana_application::manager::ApplicationManager;
use harana_common::dashmap::DashMap;
use harana_common::once_cell::sync::OnceCell;
use harana_database::manager::DatabaseManager;
use harana_job::manager::JobManager;
use harana_search_file::manager::FileManager;
use harana_search_index::manager::IndexManager;
use harana_search_index::searcher::IndexSearcher;
use harana_search_index::thumbnailer::IndexThumbnailer;
use tauri::{AppHandle, Window, Wry};
use crate::handler_settings::get_setting;

pub static mut ONBOARDED: bool = true;

pub static APP_HANDLE: OnceCell<AppHandle<Wry>> = OnceCell::new();

pub static APPLICATION_ICONS_PATH: OnceCell<PathBuf> = OnceCell::new();
pub static DATABASE_PATH: OnceCell<PathBuf> = OnceCell::new();
pub static INDEX_DECLARATIONS_PATH: OnceCell<PathBuf> = OnceCell::new();
pub static INDEX_PATH: OnceCell<PathBuf> = OnceCell::new();
pub static MODELS_PATH: OnceCell<PathBuf> = OnceCell::new();
pub static PREVIEWS_PATH: OnceCell<PathBuf> = OnceCell::new();
pub static TAURI_DATA_PATH: OnceCell<PathBuf> = OnceCell::new();
pub static THUMBNAILS_PATH: OnceCell<PathBuf> = OnceCell::new();

pub static APPLICATION_MANAGER: OnceCell<ApplicationManager> = OnceCell::new();
pub static DATABASE_MANAGER: OnceCell<DatabaseManager> = OnceCell::new();
pub static FILE_MANAGER: OnceCell<FileManager> = OnceCell::new();
pub static INDEX_MANAGER: OnceCell<IndexManager> = OnceCell::new();
pub static INDEX_SEARCHER: OnceCell<IndexSearcher> = OnceCell::new();
pub static INDEX_THUMBNAILER: OnceCell<IndexThumbnailer> = OnceCell::new();
pub static JOB_MANAGER: OnceCell<JobManager> = OnceCell::new();

pub static BACKGROUND_WINDOW: OnceCell<Window<Wry>> = OnceCell::new();
pub static BILLING_WINDOW: OnceCell<Window<Wry>> = OnceCell::new();
pub static INTEGRATIONS_WINDOW: OnceCell<Window<Wry>> = OnceCell::new();
pub static SEARCH_WINDOW: OnceCell<Window<Wry>> = OnceCell::new();
pub static SETTINGS_WINDOW: OnceCell<Window<Wry>> = OnceCell::new();
pub static SIGNUP_WINDOW: OnceCell<Window<Wry>> = OnceCell::new();
pub static PREVIEW_WINDOW: OnceCell<Window<Wry>> = OnceCell::new();
pub static WELCOME_WINDOW: OnceCell<Window<Wry>> = OnceCell::new();

pub static SEARCH_WINDOW_POSITIONS: OnceCell<DashMap<String, (f64, f64)>> = OnceCell::new();

pub async fn bool_setting(key: &str) -> bool {
    get_setting(key.to_string()).await.unwrap() == "true"
}

pub async fn int_setting(key: &str) -> u8 {
    get_setting(key.to_string()).await.unwrap().parse::<u8>().unwrap()
}