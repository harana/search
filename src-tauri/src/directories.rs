use std::fs;
use tauri::{AppHandle, Wry};
use crate::globals::*;

pub fn setup_directories(app: AppHandle<Wry>) {
    let tauri_data_path = app.path_resolver().app_data_dir().unwrap();
    let application_icons_path = tauri_data_path.join("application_icons");
    let database_path = tauri_data_path.join("database");
    let index_path = tauri_data_path.join("index");
    let index_declarations_path = tauri_data_path.join("index_declarations");
    let models_path = tauri_data_path.join("models");
    let previews_path = tauri_data_path.join("previews");
    let thumbnails_path = tauri_data_path.join("thumbnails");

    APPLICATION_ICONS_PATH.set(application_icons_path.clone()).unwrap();
    DATABASE_PATH.set(database_path.clone()).unwrap();
    INDEX_PATH.set(index_path.clone()).unwrap();
    INDEX_DECLARATIONS_PATH.set(index_declarations_path.clone()).unwrap();
    MODELS_PATH.set(models_path.clone()).unwrap();
    PREVIEWS_PATH.set(previews_path.clone()).unwrap();
    TAURI_DATA_PATH.set(tauri_data_path.clone()).unwrap();
    THUMBNAILS_PATH.set(thumbnails_path.clone()).unwrap();

    vec!(
        application_icons_path.clone(),
        database_path.clone(),
        index_path.clone(),
        index_declarations_path.clone(),
        models_path.clone(),
        previews_path.clone(),
        tauri_data_path.clone(),
        thumbnails_path.clone()
    ).iter().for_each(|path| fs::create_dir_all(path).unwrap());

}