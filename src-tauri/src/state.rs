use std::sync::Mutex;

use objc_id::ShareId;

use crate::windows_mac::RawNSPanel;

#[derive(Default)]
pub struct Store {
    pub always_center_window: bool,
    pub panel: Option<ShareId<RawNSPanel>>
}

#[derive(Default)]
pub struct State(pub Mutex<Store>);

#[macro_export]
macro_rules! set_state {
    ($app_handle:expr, $field:ident, $value:expr) => {{
        let handle = $app_handle.app_handle();
        handle
            .state::<$crate::windows_mac::State>()
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
            .state::<$crate::windows_mac::State>()
            .0
            .lock()
            .unwrap()
            .$field;

        value
    }};
    ($app_handle:expr, $field:ident, $action:ident) => {{
        let handle = $app_handle.app_handle();
        let value = handle
            .state::<$crate::windows_mac::State>()
            .0
            .lock()
            .unwrap()
            .$field
            .$action();

        value
    }};
}