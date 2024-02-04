#[cfg(target_os = "macos")]
extern crate objc;
#[cfg(target_os = "macos")]
extern crate objc_foundation;
#[cfg(target_os = "macos")]
extern crate objc_id;

use harana_common::anyhow::Result;
use harana_common::log::debug;
use harana_common::thread_pools::{execute_operation, SEARCH_POOL};
use tauri;

#[cfg(target_os = "linux")]
use std::{fs::metadata, path::PathBuf};
use std::process::{Command, Stdio};

#[cfg(target_os = "macos")]
use objc::msg_send;
#[cfg(target_os = "macos")]
use objc::runtime::Class;
#[cfg(target_os = "macos")]
use objc::runtime::Object;
#[cfg(target_os = "macos")]
use objc::sel;
#[cfg(target_os = "macos")]
use objc::sel_impl;

#[cfg(target_os = "linux")]
use fork::{daemon, Fork};

use crate::globals::SEARCH_WINDOW;

#[tauri::command]
pub async fn open_application(path: String) -> Result<(), String> {
    let _ = SEARCH_WINDOW.get().unwrap().hide();


    #[cfg(target_os = "windows")]
    {
        Command::new("explorer")
            .args(["/select,", &path]) // The comma after select is not a typo
            .spawn()
            .unwrap();
    }

    #[cfg(target_os = "linux")]
    {
        if path.contains(",") {
            // see https://gitlab.freedesktop.org/dbus/dbus/-/issues/76
            let new_path = match metadata(&path).unwrap().is_dir() {
                true => path,
                false => {
                    let mut path2 = PathBuf::from(path);
                    path2.pop();
                    path2.into_os_string().into_string().unwrap()
                }
            };
            Command::new("xdg-open")
                .arg(&new_path)
                .spawn()
                .unwrap();
        } else {
            if let Ok(Fork::Child) = daemon(false, false) {
                Command::new("dbus-send")
                    .args(["--session", "--dest=org.freedesktop.FileManager1", "--type=method_call",
                        "/org/freedesktop/FileManager1", "org.freedesktop.FileManager1.ShowItems",
                        format!("array:string:\"file://{path}\"").as_str(), "string:\"\""])
                    .spawn()
                    .unwrap();
            }
        }
    }

    #[cfg(target_os = "macos")]
    {
        execute_operation(&SEARCH_POOL, move |_| {
            unsafe {
                let cls = Class::get("NSWorkspace").unwrap();
                let wspace: *mut Object = msg_send![cls, sharedWorkspace];
                let cls = Class::get("NSString").unwrap();
                let s: *mut Object = msg_send![cls, alloc];
                let s: *mut Object = msg_send![s,
                                                   initWithBytes:path.as_ptr()
                                                   length:path.len()
                                                   encoding: 4]; // UTF8_ENCODING
                let _: () = msg_send![wspace, launchApplication: s];
            }
            Ok(())
        }).await.map_err(|e| e.to_string())
    }
}


#[tauri::command]
pub async fn open_path(path: String) -> Result<(), String> {
    debug!("Command: search->open_path");
    let _ = SEARCH_WINDOW.get().unwrap().hide();


    #[cfg(target_os = "windows")]
    {
        Command::new("explorer")
            .args(["/select,", &path]) // The comma after select is not a typo
            .spawn()
            .unwrap();
    }

    #[cfg(target_os = "linux")]
    {
        if path.contains(",") {
            // see https://gitlab.freedesktop.org/dbus/dbus/-/issues/76
            let new_path = match metadata(&path).unwrap().is_dir() {
                true => path,
                false => {
                    let mut path2 = PathBuf::from(path);
                    path2.pop();
                    path2.into_os_string().into_string().unwrap()
                }
            };
            Command::new("xdg-open")
                .arg(&new_path)
                .spawn()
                .unwrap();
        } else {
            if let Ok(Fork::Child) = daemon(false, false) {
                Command::new("dbus-send")
                    .args(["--session", "--dest=org.freedesktop.FileManager1", "--type=method_call",
                        "/org/freedesktop/FileManager1", "org.freedesktop.FileManager1.ShowItems",
                        format!("array:string:\"file://{path}\"").as_str(), "string:\"\""])
                    .spawn()
                    .unwrap();
            }
        }
    }

    #[cfg(target_os = "macos")]
    {
        match Command::new("open")
            .args([&path])
            .stdout(Stdio::piped())
            .output() {
            Ok(output) => {
                let stderr = String::from_utf8(output.stderr).unwrap();
                if stderr.starts_with("No application knows how to open URL") {
                    Err("no_application".to_string())
                }else{
                    Ok(())
                }
            }
            Err(e) => {
                Err("unknown_error".to_string())
            }
        }
    }
}