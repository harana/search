#![cfg(target_os = "macos")]

use std::sync::Once;

use cocoa::{
    appkit::{CGFloat, NSWindowCollectionBehavior},
    base::{BOOL, id, nil, NO, YES},
    foundation::{NSPoint, NSRect},
};
use harana_common::log::info;
use objc::{
    class,
    declare::ClassDecl,
    Message,
    msg_send,
    runtime::{self, Class, Object, Protocol, Sel}, sel, sel_impl,
};
use objc_foundation::INSObject;
use objc_id::{Id, ShareId};
use tauri;
use tauri::{AppHandle, GlobalShortcutManager, LogicalPosition, Manager, PhysicalPosition, PhysicalSize, Position, Window, Wry};
use crate::State;
use crate::{get_state, set_state};
use crate::globals::{ONBOARDED, SEARCH_WINDOW, SEARCH_WINDOW_POSITIONS, WELCOME_WINDOW};

#[link(name = "Foundation", kind = "framework")]
extern "C" {
    pub fn NSMouseInRect(aPoint: NSPoint, aRect: NSRect, flipped: BOOL) -> BOOL;
}

#[macro_export]

macro_rules! panel {
    ($app_handle:expr) => {{
        let handle = $app_handle.app_handle();
        let panel = handle
            .state::<$crate::windows_mac::State>()
            .0
            .lock()
            .unwrap()
            .panel
            .clone();

        panel.unwrap()
    }};
}

#[macro_export]
macro_rules! nsstring_to_string {
    ($ns_string:expr) => {{
        use objc::{sel, sel_impl};
        let utf8: id = unsafe { objc::msg_send![$ns_string, UTF8String] };
        let string = if !utf8.is_null() {
            Some(unsafe {
                {
                    std::ffi::CStr::from_ptr(utf8 as *const std::ffi::c_char)
                        .to_string_lossy()
                        .into_owned()
                }
            })
        } else {
            None
        };

        string
    }};
}

static INIT: Once = Once::new();
static PANEL_LABEL: &str = "search";

pub fn init_main_panel(app_handle: AppHandle<Wry>, shortcut: String, always_center: bool) {
    INIT.call_once(|| {
        info!("Initialising NS Panel ..");
        let search_window = app_handle.get_window(PANEL_LABEL).unwrap();
        let _ = SEARCH_WINDOW.set(search_window.clone());

        set_state!(app_handle, always_center_window, always_center);
        set_state!(app_handle, panel, Some(create_main_panel(&search_window)));
        search_window.open_devtools();

        info!("Registering shortcut ..");
        register_shortcut(app_handle, shortcut);
    });
}

fn register_shortcut(app_handle: AppHandle<Wry>, shortcut: String) {
    let mut shortcut_manager = app_handle.global_shortcut_manager();
    let window = app_handle.get_window(PANEL_LABEL).unwrap();

    let panel = panel!(app_handle);
    shortcut_manager
        .register(shortcut.as_str(), move || {
            if panel.is_visible() {
                hide_search(window.app_handle());
            } else {
                // let start = Instant::now();
                //
                // let screens = Screen::all().unwrap();
                // for screen in screens {
                //     if screen.display_info.is_primary {
                //         let position = window.outer_position().unwrap();
                //         let size = window.outer_size().unwrap();
                //         let image = screen.capture_area(position.x, position.y, size.width, size.height).unwrap();
                //         let rgbs = image.rgba().as_rgb();
                //
                //         let buffer = image.to_png(Compression::Fast).unwrap();
                //         fs::write("/tmp/screenshot.png", buffer).unwrap();
                //         info!("Screenshot: {} -> {}, {} -> {}", position.x, position.x + size.width as i32, position.y, position.y + size.height as i32);
                //     }
                // }
                // let end = Instant::now();
                //
                // //info!("Time taken to screenshot = {:?}", end - start);
                show_search(window.app_handle());
            };
        })
        .unwrap();
}

pub fn show_search(app_handle: AppHandle<Wry>) {
    unsafe {
        let welcome_window = WELCOME_WINDOW.get().unwrap();
        if ONBOARDED && welcome_window.is_visible().unwrap() {
            info!("Hiding welcome window ..");
            welcome_window.hide().unwrap();
        }
    }

    let window = SEARCH_WINDOW.get().unwrap();

    if let Some(monitor) = get_monitor_with_cursor() {
        let monitor_name = &monitor.name.unwrap();
        let has_existing_position = SEARCH_WINDOW_POSITIONS.get().unwrap().contains_key(monitor_name);

        if !has_existing_position || get_state!(app_handle, always_center_window) {
            let screen_width = monitor.size.width as f64 / monitor.scale_factor;
            let screen_height = monitor.size.height as f64 / monitor.scale_factor;

            let window_width = window.inner_size().unwrap().width as f64 / window.scale_factor().unwrap();
            let window_height = window.inner_size().unwrap().height as f64 / window.scale_factor().unwrap();

            let _ = window.set_position(Position::Logical(LogicalPosition {
                x: (screen_width - window_width)/2.0,
                y: (screen_height - window_height)/2.0
            }));
        }else{
            let existing_position = SEARCH_WINDOW_POSITIONS.get().unwrap().get(monitor_name).unwrap();
            let _ = window.set_position(Position::Logical(LogicalPosition {
                x: existing_position.value().0,
                y: existing_position.value().1
            }));
        }
    }

    panel!(app_handle).show();
}

pub fn hide_search(app_handle: AppHandle<Wry>) {
    panel!(app_handle).order_out(None);
}

pub fn enable_auto_hide(app_handle: AppHandle<Wry>) {
    toggle_delegate(panel!(app_handle), true)
}

pub fn disable_auto_hide(app_handle: AppHandle<Wry>) {
    toggle_delegate(panel!(app_handle), false)
}

pub struct Monitor {
    #[allow(dead_code)]
    pub name: Option<String>,
    pub size: PhysicalSize<u32>,
    pub position: PhysicalPosition<i32>,
    pub scale_factor: f64,
}

/// Gets the Monitor with cursor
pub fn get_monitor_with_cursor() -> Option<Monitor> {
    objc::rc::autoreleasepool(|| {
        let mouse_location: NSPoint = unsafe {   msg_send![class!(NSEvent), mouseLocation] };
        let screens: id = unsafe { msg_send![class!(NSScreen), screens] };
        let screens_iter: id = unsafe { msg_send![screens, objectEnumerator] };
        let mut next_screen: id;

        let frame_with_cursor: Option<NSRect> = loop {
            next_screen = unsafe { msg_send![screens_iter, nextObject] };
            if next_screen == nil {
                break None;
            }

            let frame: NSRect = unsafe { msg_send![next_screen, frame] };
            let is_mouse_in_screen_frame: BOOL = unsafe { NSMouseInRect(mouse_location, frame, NO) };
            if is_mouse_in_screen_frame == YES {
                break Some(frame);
            }
        };

        if let Some(frame) = frame_with_cursor {
            let name: id = unsafe { msg_send![next_screen, localizedName] };
            let screen_name = nsstring_to_string!(name);
            let scale_factor: CGFloat = unsafe { msg_send![next_screen, backingScaleFactor] };
            let scale_factor: f64 = scale_factor;

            return Some(Monitor {
                name: screen_name,
                position: PhysicalPosition {
                    x: (frame.origin.x * scale_factor) as i32,
                    y: (frame.origin.y * scale_factor) as i32,
                },
                size: PhysicalSize {
                    width: (frame.size.width * scale_factor) as u32,
                    height: (frame.size.height * scale_factor) as u32,
                },
                scale_factor,
            });
        }

        None
    })
}

extern "C" {
    pub fn object_setClass(obj: id, cls: id) -> id;
}

#[allow(non_upper_case_globals)]
const NSWindowStyleMaskNonActivatingPanel: i32 = 1 << 7;

const CLS_NAME: &str = "RawNSPanel";

pub struct RawNSPanel;

impl RawNSPanel {
    fn get_class() -> &'static Class {
        Class::get(CLS_NAME).unwrap_or_else(Self::define_class)
    }

    fn define_class() -> &'static Class {
        let mut cls = ClassDecl::new(CLS_NAME, class!(NSPanel))
            .unwrap_or_else(|| panic!("Unable to register {} class", CLS_NAME));

        unsafe {
            cls.add_method(
                sel!(canBecomeKeyWindow),
                Self::can_become_key_window as extern "C" fn(&Object, Sel) -> BOOL,
            );
        }

        cls.register()
    }

    /// Returns YES to ensure that RawNSPanel can become a key window
    extern "C" fn can_become_key_window(_: &Object, _: Sel) -> BOOL {
        YES
    }
}
unsafe impl Message for RawNSPanel {}

impl RawNSPanel {
    fn show(&self) {
        self.make_first_responder(Some(self.content_view()));
        self.order_front_regardless();
        self.make_key_window();
    }

    fn is_visible(&self) -> bool {
        let flag: BOOL = unsafe { msg_send![self, isVisible] };
        flag == YES
    }

    fn make_key_window(&self) {
        let _: () = unsafe { msg_send![self, makeKeyWindow] };
    }

    fn order_front_regardless(&self) {
        let _: () = unsafe { msg_send![self, orderFrontRegardless] };
    }

    fn order_out(&self, sender: Option<id>) {
        let _: () = unsafe { msg_send![self, orderOut: sender.unwrap_or(nil)] };
    }

    fn content_view(&self) -> id {
        unsafe { msg_send![self, contentView] }
    }

    fn make_first_responder(&self, sender: Option<id>) {
        if let Some(responder) = sender {
            let _: () = unsafe { msg_send![self, makeFirstResponder: responder] };
        } else {
            let _: () = unsafe { msg_send![self, makeFirstResponder: self] };
        }
    }

    fn set_level(&self, level: i32) {
        let _: () = unsafe { msg_send![self, setLevel: level] };
    }

    fn set_style_mask(&self, style_mask: i32) {
        let _: () = unsafe { msg_send![self, setStyleMask: style_mask] };
    }

    fn set_collection_behaviour(&self, behaviour: NSWindowCollectionBehavior) {
        let _: () = unsafe { msg_send![self, setCollectionBehavior: behaviour] };
    }

    fn set_delegate(&self, delegate: Option<Id<RawNSPanelDelegate>>) {
        if let Some(del) = delegate {
            let _: () = unsafe { msg_send![self, setDelegate: del] };
        } else {
            let _: () = unsafe { msg_send![self, setDelegate: self] };
        }
    }

    /// Create an NSPanel from Tauri's NSWindow
    fn from(ns_window: id) -> Id<Self> {
        let main_panel: id = unsafe { msg_send![Self::class(), class] };
        unsafe {
            object_setClass(ns_window, main_panel);
            Id::from_retained_ptr(ns_window as *mut Self)
        }
    }
}

impl INSObject for RawNSPanel {
    fn class() -> &'static Class {
        RawNSPanel::get_class()
    }
}

#[allow(dead_code)]
const DELEGATE_CLS_NAME: &str = "RawNSPanelDelegate";

#[allow(dead_code)]
struct RawNSPanelDelegate {}

impl RawNSPanelDelegate {
    #[allow(dead_code)]
    fn get_class() -> &'static Class {
        Class::get(DELEGATE_CLS_NAME).unwrap_or_else(Self::define_class)
    }

    #[allow(dead_code)]
    fn define_class() -> &'static Class {
        let mut cls = ClassDecl::new(DELEGATE_CLS_NAME, class!(NSObject))
            .unwrap_or_else(|| panic!("Unable to register {} class", DELEGATE_CLS_NAME));

        cls.add_protocol(
            Protocol::get("NSWindowDelegate").expect("Failed to get NSWindowDelegate protocol"),
        );

        unsafe {
            cls.add_ivar::<id>("panel");
            cls.add_method(sel!(setPanel:), Self::set_panel as extern "C" fn(&mut Object, Sel, id));
            cls.add_method(sel!(windowDidMove:), Self::window_did_move as extern "C" fn(&Object, Sel, id));
            cls.add_method(sel!(windowDidBecomeKey:), Self::window_did_become_key as extern "C" fn(&Object, Sel, id));
            cls.add_method(sel!(windowDidResignKey:), Self::window_did_resign_key as extern "C" fn(&Object, Sel, id));
        }

        cls.register()
    }

    extern "C" fn set_panel(this: &mut Object, _: Sel, panel: id) {
        unsafe { this.set_ivar("panel", panel) };
    }

    extern "C" fn window_did_move(_: &Object, _: Sel, _: id) {
        if let Some(name) = get_monitor_with_cursor().and_then(|m| m.name) {
            let positions = SEARCH_WINDOW_POSITIONS.get().unwrap();
            let window = SEARCH_WINDOW.get().unwrap();
            let window_width = window.inner_position().unwrap().x as f64 / window.scale_factor().unwrap();
            let window_height = window.inner_position().unwrap().y as f64 / window.scale_factor().unwrap();
            positions.insert(name, (window_width, window_height));
        }
    }

    extern "C" fn window_did_become_key(_: &Object, _: Sel, _: id) {}

    /// Hide panel when it's no longer the key window
    extern "C" fn window_did_resign_key(this: &Object, _: Sel, _: id) {
        //println!("WINDOW DID RESIGN KEY")
        let panel: id = unsafe { *this.get_ivar("panel") };
        let _: () = unsafe { msg_send![panel, orderOut: nil] };
    }
}

unsafe impl Message for RawNSPanelDelegate {}

impl INSObject for RawNSPanelDelegate {
    fn class() -> &'static runtime::Class {
        Self::get_class()
    }
}

impl RawNSPanelDelegate {
    pub fn set_panel_(&self, panel: ShareId<RawNSPanel>) {
        let _: () = unsafe { msg_send![self, setPanel: panel] };
    }
}

fn create_main_panel(window: &Window<Wry>) -> ShareId<RawNSPanel> {
    // Convert NSWindow Object to NSPanel
    let handle: id = window.ns_window().unwrap() as _;
    let panel = RawNSPanel::from(handle);
    let panel = panel.share();

    // Set panel above the main menu window level
    // panel.set_level(NSMainMenuWindowLevel + 1);

    // Ensure that the panel can display over the top of fullscreen apps
    panel.set_collection_behaviour(
        NSWindowCollectionBehavior::NSWindowCollectionBehaviorTransient
            | NSWindowCollectionBehavior::NSWindowCollectionBehaviorCanJoinAllSpaces
            | NSWindowCollectionBehavior::NSWindowCollectionBehaviorFullScreenAuxiliary,
    );

    // Ensures panel does not activate
    panel.set_style_mask(NSWindowStyleMaskNonActivatingPanel);

    // Setup delegate for an NSPanel to listen for window resign key and hide the panel
    toggle_delegate(panel.clone(), true);

    panel
}

pub fn toggle_delegate(panel: ShareId<RawNSPanel>, on: bool) {
    let delegate = RawNSPanelDelegate::new();
    delegate.set_panel_(panel.clone());

    if on {
        panel.set_delegate(Some(delegate));
    }else{
        panel.set_delegate(None);
    }
}