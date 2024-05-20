package com.harana.search.client.system

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.main.MainStore.UpdateActivePanel
import com.harana.search.client.main.ui.Panel
import com.harana.search.client.system.SystemStore._
import com.harana.web.actions.{Init, NoChange}
import com.harana.web.external.tauri.Tauri.convertFileSrc
import com.harana.web.external.tauri.Window
import diode.Effect.action
import diode._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits._

class SystemHandler extends ActionHandler(zoomTo(_.systemState)) {
  override def handle = {

    case Init(preferences) =>
      effectOnly(
        Effect(
          for {
            appAssetsPath     <- Tauri.invoke[String]("get_app_assets_path")
            appAssetsUrl      =  convertFileSrc(appAssetsPath)

            appIconsPath      <- Tauri.invoke[String]("get_app_icons_path")
            appIconsUrl       =  convertFileSrc(appIconsPath)

            isDebug           <- Tauri.invoke[String]("is_debug")

            previewsPath      <- Tauri.invoke[String]("get_previews_path")
            previewsUrl       =  convertFileSrc(previewsPath)

            thumbnailsPath    <- Tauri.invoke[String]("get_thumbnails_path")
            thumbnailsUrl     =  convertFileSrc(thumbnailsPath)

            action            =  ActionBatch(
                                    UpdateAppAssetsUrl(appAssetsUrl),
                                    UpdateAppIconsUrl(appIconsUrl),
                                    UpdateIsDebug(isDebug.toBoolean),
                                    UpdatePreviewsUrl(previewsUrl),
                                    UpdateThumbnailsUrl(thumbnailsUrl),
                                  )
          } yield action
        )
      )

    case WindowReady =>
      effectOnly(
        action(
          UpdateActivePanel(
            Window.getCurrent().label match {
              case "main"     => Panel.Search
              case "welcome"  => Panel.Welcome
            }
          )
        ) + Effect(Tauri.invoke[Unit]("window_ready", Map("label" -> Window.getCurrent().label)).map(_ => NoChange))
      )

    case UpdateAppIconsUrl(url) =>
      updated(value.copy(appIconsUrl = url))

    case UpdateAppAssetsUrl(url) =>
      updated(value.copy(appAssetsUrl = url))

    case UpdateIsDebug(debug) =>
      updated(value.copy(isDebug = debug))

    case UpdateIsDemo(demo) =>
      updated(value.copy(isDemo = demo))

    case UpdatePreviewsUrl(url) =>
      updated(value.copy(previewsUrl = url))

    case UpdateThumbnailsUrl(url) =>
      updated(value.copy(thumbnailsUrl = url))
  }
}