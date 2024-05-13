package com.harana.search.client.welcome

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.models.{RawDocument, SearchFolder}
import com.harana.search.client.{Circuit, Tauri}
import com.harana.search.client.welcome.WelcomeStore._
import com.harana.web.actions.{Init, NoChange}
import com.harana.web.handlers.files.FilesStore.Refresh
import diode._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global
import typings.std.global.console

import java.util.Timer
import scala.concurrent.Future
import scala.scalajs.js

class WelcomeHandler extends ActionHandler(zoomTo(_.welcomeState)) {
  override def handle = {

    case Init(preferences) =>
      effectOnly(Tauri.list("list_search_folders", (list: List[SearchFolder]) => UpdateSearchFolders(list)))

    case HideWindow =>
      effectOnly(
        Effect(Tauri.invoke[Unit]("hide_window", Map("label" -> "welcome")).map(_ => NoChange))
      )

    case CompleteOnboarding =>
      effectOnly(
        Effect(Tauri.invoke[Unit]("complete_onboarding", Map(
          "allowTelemetry" -> value.allowTelemetry,
          "anonymousMode" -> value.anonymousMode,
          "overrideSpotlight" -> value.overrideSpotlight,
        )).map(_ => NoChange))
      )

    case UpdateAllowTelemetry(allow) =>
      updated(value.copy(allowTelemetry = allow))

    case UpdateAnonymousMode(anonymous) =>
      updated(value.copy(anonymousMode = anonymous))

    case UpdateOverrideSpotlight(os) =>
      updated(value.copy(overrideSpotlight = os))

    case UpdateSearchFolderStatus(status) =>
      updated(value.copy(searchFolderStatus = status))

    case UpdateSearchFolder(folder) =>
      Tauri.update("update_search_folder", Map("nameOrPath" -> folder.nameOrPath, "isPath" -> folder.isPath, "enabled" -> folder.enabled),
        effect => updated(value.copy(searchFolders = value.searchFolders.map(f => if (f.nameOrPath == folder.nameOrPath) folder else f)), effect)
      )

    case UpdateSearchFolders(folders) =>
      updated(value.copy(searchFolders = folders))

    case UpdateSelectedStep(step) =>
      updated(value.copy(selectedStep = step))
  }
}