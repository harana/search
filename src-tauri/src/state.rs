use std::sync::Mutex;

#[cfg(target_os = "macos")]
use objc_id::ShareId;

#[cfg(target_os = "macos")]
use crate::windows_main_mac::RawNSPanel;

#[derive(Default)]
pub struct Store {
    pub always_center_window: bool,
    #[cfg(target_os = "macos")]
    pub panel: Option<ShareId<RawNSPanel>>
}

#[derive(Default)]
pub struct State(pub Mutex<Store>);

#[macro_export]
macro_rules! set_state {
    ($app_handle:expr, $field:ident, $value:expr) => {{
        let handle = $app_handle.app_handle();
        handle
            .state::<$crate::windows_main_mac::State>()
            .0
            .lock()
            .unwrap()
            .$field = $value;
    }};
}

#[macro_export]
macro_rules! get_state {
    ($app_handle:expr, $field:ident) => {{
        let handle = $app_handle.app_handle();
        let value = handle
            .state::<$crate::windows_main_mac::State>()
            .0
            .lock()
            .unwrap()
            .$field;

        value
    }};
    ($app_handle:expr, $field:ident, $action:ident) => {{
        let handle = $app_handle.app_handle();
        let value = handle
            .state::<$crate::windows_main_mac::State>()
            .0
            .lock()
            .unwrap()
            .$field
            .$action();

        value
    }};
}