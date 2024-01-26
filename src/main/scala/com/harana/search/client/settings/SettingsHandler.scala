package com.harana.search.client.settings

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.settings.SettingsStore._
import com.harana.web.actions.{Init, NoChange}
import diode._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

import scala.scalajs.js

class SettingsHandler extends ActionHandler(zoomTo(_.settingsState)) {
  override def handle = {

    case Init(_) =>
      noChange

    case HideSettings =>
      effectOnly(
        Effect(
          Tauri.invoke("hide_settings").map((_: js.Any) => NoChange)
        )
      )

    case UpdateSelectedSection(section) =>
      updated(value.copy(selectedSection = section))
  }
}