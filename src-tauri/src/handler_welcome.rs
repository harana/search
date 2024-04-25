use std::process::Command;
use harana_common::anyhow::Result;
use harana_database::settings_upsert::settings_upsert;
use harana_database::state_upsert::state_upsert;
use tauri;
use tauri::{AppHandle, Wry};

use crate::globals::{ONBOARDED, WELCOME_WINDOW};
use crate::handlers::database_core;
use crate::windows::init_main_window;
use crate::windows_mac;

#[tauri::command]
pub async fn get_onboarded() -> Result<bool, String> {
    unsafe {
        Ok(ONBOARDED)
    }
}

#[tauri::command]
pub async fn complete_onboarding(app_handle: AppHandle<Wry>, allow_telemetry: bool, anonymous_mode: bool, override_spotlight: bool) -> Result<(), String> {
    let shortcut_key = if override_spotlight { "CommandOrControl+Space" } else { "CommandOrControl+Shift+Space" };

    database_core(move |c| {
        state_upsert(c, "has_onboarded".to_string(), "true".to_string()).unwrap();
        settings_upsert(c, "privacy_allow_telemetry".to_string(), allow_telemetry.to_string()).unwrap();
        settings_upsert(c, "privacy_anonymous_mode".to_string(), anonymous_mode.to_string()).unwrap();

        settings_upsert(c, "appearance_shortcut_key".to_string(), shortcut_key.to_string()).unwrap();
        Ok(())
    }).await?;

    if override_spotlight {
        Command::new("defaults")
            .args([
                "write",
                "com.apple.symbolichotkeys.plist",
                "AppleSymbolicHotKeys",
                "-dict-add",
                "64",
                "
      <dict>
        <key>enabled</key><false/>
        <key>value</key><dict>
          <key>type</key><string>standard</string>
          <key>parameters</key>
          <array>
            <integer>32</integer>
            <integer>49</integer>
            <integer>1048576</integer>
          </array>
        </dict>
      </dict>
    "
            ])
            .output()
            .expect("Failed to apply Spotlight preferences");


        // Apply Spotlight change settings
        Command::new("/System/Library/PrivateFrameworks/SystemAdministration.framework/Resources/activateSettings")
            .args(["-u"])
            .output()
            .expect("Failed to apply Spotlight preferences");
    }

    // Init main window
    unsafe { ONBOARDED = true; }
    init_main_window(app_handle.clone()).await.unwrap();
    windows_mac::register_shortcut(app_handle.clone(), shortcut_key.to_string());
    Ok(())
}

#[tauri::command]
pub fn show_welcome() -> Result<(), String> {
    let window = WELCOME_WINDOW.get().unwrap();
    window.set_focus().unwrap();
    window.center().unwrap();
    window.show().unwrap();
    Ok(())
}

#[tauri::command]
pub async fn hide_welcome() -> Result<(), String> {
    let window = WELCOME_WINDOW.get().unwrap();
    window.hide().unwrap();
    Ok(())
}