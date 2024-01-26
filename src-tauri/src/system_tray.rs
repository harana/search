use harana_common::anyhow::Result;
use tauri::{AppHandle, CustomMenuItem, Manager, SystemTray, SystemTrayEvent, SystemTrayHandle, SystemTrayMenu, SystemTrayMenuItem};
use tauri::api::shell;

use crate::globals::*;

pub fn create_system_tray() -> Result<SystemTray> {
    let search = CustomMenuItem::new("Search".to_string(), "Search");
    let settings = CustomMenuItem::new("Settings".to_string(), "Settings");
    let feedback = CustomMenuItem::new("Feedback".to_string(), "Feedback");
    let support = CustomMenuItem::new("Support".to_string(), "Support");
    let quit = CustomMenuItem::new("Quit".to_string(), "Quit");

    let tray_menu = SystemTrayMenu::new()
        .add_item(search.clone())
        .add_native_item(SystemTrayMenuItem::Separator)
        .add_item(settings.clone())
        .add_native_item(SystemTrayMenuItem::Separator)
        .add_item(feedback.clone())
        .add_item(support.clone())
        .add_native_item(SystemTrayMenuItem::Separator)
        .add_item(quit.clone());

    Ok(SystemTray::new().with_menu(tray_menu))
}

pub fn enable_system_tray(app_handle: AppHandle) -> Result<()> {
    app_handle.tray_handle().get_item("Search").set_enabled(true)?;
    app_handle.tray_handle().get_item("Settings").set_enabled(true)?;
    Ok(())
}

pub fn disable_system_tray(app_handle: AppHandle) -> Result<()> {
    app_handle.tray_handle().get_item("Search").set_enabled(false)?;
    app_handle.tray_handle().get_item("Settings").set_enabled(false)?;
    Ok(())
}

pub fn on_system_tray_event(app: &AppHandle, event: SystemTrayEvent) -> () {
    match event {
        SystemTrayEvent::MenuItemClick { id, .. } => {
            match id.as_str() {
                "Search" => {
                    let window = SEARCH_WINDOW.get().unwrap();
                    window.show().unwrap();
                    window.center().unwrap();
                }
                "Settings" => {
                    let window = SETTINGS_WINDOW.get().unwrap();
                    window.show().unwrap();
                    window.center().unwrap();
                }
                "Integrations" => {
                    let window = INTEGRATIONS_WINDOW.get().unwrap();
                    window.show().unwrap();
                    window.center().unwrap();
                }
                "Feedback" => {
                    shell::open(&app.shell_scope(), "https://github.com/harana/feedback", None).unwrap();
                }
                "Support" => {
                    shell::open(&app.shell_scope(), "https://github.com/harana/feedback", None).unwrap();
                }
                "Quit" => {
                    std::process::exit(0);
                }
                _ => {}
            }
        }
        _ => {}
    }
}