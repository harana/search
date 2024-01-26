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
      effectOnly(
        Tauri.list("list_search_folders", (list: List[SearchFolder]) => UpdateSearchFolders(list))
      )

    case RefreshStatus =>
      effectOnly(
        Effect(
          Tauri.invoke("search_folders_status").map((status: js.Dictionary[Boolean]) =>
            UpdateSearchFolderStatus(status.toMap)
          )
        )
      )

    case ShowWindow =>
      effectOnly(
          Effect(
            for {
              onboarded   <- Tauri.invoke[Boolean]("get_onboarded")
              _           <- if (!onboarded) Tauri.invoke[Unit]("show_welcome") else Future()
              timer       =  {
                                val timer = new Timer()
                                timer.scheduleAtFixedRate(new java.util.TimerTask { def run(): Unit = { Circuit.dispatch(RefreshStatus) }}, 0L, 1000L)
                                timer
                              }
            } yield ActionBatch(
              UpdateStatusTimer(Some(timer)),
              UpdateWindowShown(true)
            )
          )
      )

    case HideWindow =>
      effectOnly(
        Effect(Tauri.invoke[Unit]("hide_welcome").map(_ => NoChange))
      )

    case CompleteOnboarding =>
      value.statusTimer.get.cancel()
      effectOnly(
        Effect(Tauri.invoke[Unit]("complete_onboarding", Map()).map(_ => NoChange))
      )

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

    case UpdateStatusTimer(timer) =>
      updated(value.copy(statusTimer = timer))

    case UpdateWindowShown(shown) =>
      updated(value.copy(windowShown = shown))

  }
}