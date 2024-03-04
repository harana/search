package com.harana.search.client.settings.general

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.models.Theme
import com.harana.search.client.settings.general.GeneralStore._
import com.harana.web.actions.Init
import diode._

class GeneralHandler extends ActionHandler(zoomTo(_.generalState)) {
  override def handle = {

    case Init(_) =>
      effectOnly(
        Tauri.setting("appearance_always_center_window", value => UpdateAppearanceAlwaysCenterWindow(value.toBoolean)) +
        Tauri.setting("appearance_font_size", value => UpdateAppearanceFontSize(value.toInt)) +
        Tauri.setting("appearance_language", value => UpdateAppearanceLanguage(value)) +
        Tauri.setting("appearance_shortcut_key", value =>
          ActionBatch(
            UpdateAppearanceShortcutKeyFirst(value.split('+')(0)),
            UpdateAppearanceShortcutKeySecond(value.split('+')(1)),
            UpdateAppearanceShortcutKeyThird(value.split('+')(2))
          )) +
        Tauri.setting("appearance_theme", value => UpdateAppearanceTheme(Theme.withName(value))) +
        Tauri.setting("privacy_share_error_reports", value => UpdatePrivacyShareErrorReports(value.toBoolean)) +
        Tauri.setting("privacy_share_usage_data", value => UpdatePrivacyShareUsageData(value.toBoolean)) +
        Tauri.setting("startup_show_in_dock", value => UpdateStartupShowInDock(value.toBoolean)) +
        Tauri.setting("startup_start_at_login", value => UpdateStartupStartAtLogin(value.toBoolean))
      )

    case UpdateAppearanceAlwaysCenterWindow(alwaysCenterWindow) =>
      Tauri.update_setting("appearance_always_center_window", alwaysCenterWindow.toString,
        effect => updated(value.copy(appearanceAlwaysCenterWindow = alwaysCenterWindow), effect)
      )

    case UpdateAppearanceFontSize(fontSize) =>
      Tauri.update_setting("appearance_font_size", fontSize.toString,
        effect => updated(value.copy(appearanceFontSize = fontSize), effect)
      )

    case UpdateAppearanceLanguage(language) =>
      Tauri.update_setting("appearance_language", language,
        effect => updated(value.copy(appearanceLanguage = language), effect)
      )

    case UpdateAppearanceShortcutKeyFirst(shortcut) =>
      Tauri.update_setting("appearance_shortcut_key",
        s"$shortcut+${value.appearanceShortcutKeySecond}+${value.appearanceShortcutKeyThird}",
        effect => updated(value.copy(appearanceShortcutKeyFirst = shortcut), effect)
      )

    case UpdateAppearanceShortcutKeySecond(shortcut) =>
      Tauri.update_setting("appearance_shortcut_key",
        s"${value.appearanceShortcutKeyFirst}+$shortcut+${value.appearanceShortcutKeyThird}",
        effect => updated(value.copy(appearanceShortcutKeySecond = shortcut), effect)
      )

    case UpdateAppearanceShortcutKeyThird(shortcut) =>
      Tauri.update_setting("appearance_shortcut_key",
        s"${value.appearanceShortcutKeyFirst}+${value.appearanceShortcutKeySecond}+$shortcut",
        effect => updated(value.copy(appearanceShortcutKeyThird = shortcut), effect)
      )

    case UpdateAppearanceTheme(theme) =>
      Tauri.update_setting("appearance_theme", theme.toString,
        effect => updated(value.copy(appearanceTheme = theme), effect)
      )

    case UpdatePrivacyShareErrorReports(shareErrorReports) =>
      Tauri.update_setting("privacy_share_error_reports", shareErrorReports.toString,
        effect => updated(value.copy(privacyShareErrorReports = shareErrorReports), effect)
      )

    case UpdatePrivacyShareUsageData(shareUsageData) =>
      Tauri.update_setting("privacy_share_usage_data", shareUsageData.toString,
        effect => updated(value.copy(privacyShareUsageData = shareUsageData), effect)
      )

    case UpdateStartupShowInDock(showInDock) =>
      Tauri.update_setting("startup_show_in_dock", showInDock.toString,
        effect => updated(value.copy(startupShowInDock = showInDock), effect)
      )

    case UpdateStartupStartAtLogin(startAtLogin) =>
      Tauri.update_setting("startup_start_at_login", startAtLogin.toString,
        effect => updated(value.copy(startupStartAtLogin = startAtLogin), effect)
      )
  }
}