use harana_common::log::LevelFilter;
use tauri::plugin::TauriPlugin;
use tauri::Runtime;
use tauri_plugin_log::{Builder, LogTarget};
use tauri_plugin_log::fern::colors::ColoredLevelConfig;

pub fn logging<R: Runtime>() -> TauriPlugin<R> {
    Builder::default().targets([
        LogTarget::Stdout,
        LogTarget::Webview,
        LogTarget::LogDir
    ])
        .level(LevelFilter::Info)
        .with_colors(ColoredLevelConfig::default())
        .level_for("archive_reader", LevelFilter::Warn)
        .level_for("docx_rust", LevelFilter::Warn)
        .level_for("jpeg2k", LevelFilter::Warn)
        .level_for("msoffice_pptx", LevelFilter::Warn)
        .level_for("pdf", LevelFilter::Warn)
        .level_for("r2d2", LevelFilter::Info)
        .level_for("rusqlite", LevelFilter::Info)
        .level_for("tantivy", LevelFilter::Warn)
        .build()
}