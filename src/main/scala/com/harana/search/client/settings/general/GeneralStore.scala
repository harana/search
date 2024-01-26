package com.harana.search.client.settings.general

import com.harana.search.client.models._
import diode.{Action => DiodeAction}

object GeneralStore {

  case class State(appearanceAlwaysCenterWindow: Boolean,
                   appearanceFontSize: Int,
                   appearanceLanguage: String,
                   appearanceShortcutKeyFirst: String,
                   appearanceShortcutKeySecond: String,
                   appearanceShortcutKeyThird: String,
                   appearanceShowPreview: Boolean,
                   appearanceTheme: Theme,
                   privacyShareErrorReports: Boolean,
                   privacyShareUsageData: Boolean,
                   startupShowInDock: Boolean,
                   startupStartAtLogin: Boolean)

  val initialState = State(true, 14, "English", "Command", "Shift", "Space", true, Theme.System, true, true, true, true)

  case class UpdateAppearanceAlwaysCenterWindow(alwaysCenterWindow: Boolean) extends DiodeAction
  case class UpdateAppearanceFontSize(fontSize: Int) extends DiodeAction
  case class UpdateAppearanceLanguage(language: String) extends DiodeAction
  case class UpdateAppearanceShortcutKeyFirst(key: String) extends DiodeAction
  case class UpdateAppearanceShortcutKeySecond(key: String) extends DiodeAction
  case class UpdateAppearanceShortcutKeyThird(key: String) extends DiodeAction
  case class UpdateAppearanceTheme(theme: Theme) extends DiodeAction
  case class UpdatePrivacyShareErrorReports(shareErrorReports: Boolean) extends DiodeAction
  case class UpdatePrivacyShareUsageData(shareUsageData: Boolean) extends DiodeAction
  case class UpdateStartupShowInDock(showInDock: Boolean) extends DiodeAction
  case class UpdateStartupStartAtLogin(startAtLogin: Boolean) extends DiodeAction
}