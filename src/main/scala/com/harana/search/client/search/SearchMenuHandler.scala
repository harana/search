package com.harana.search.client.search

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.search.SearchStore._
import com.harana.search.client.search.ui.SearchPanel
import com.harana.web.actions._
import com.harana.web.external.virtuoso.ScrollIntoViewLocation
import diode._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

import scala.concurrent.Promise
import scala.scalajs.js
import scala.util.Try

class SearchMenuHandler extends ActionHandler(zoomTo(_.searchState)) {
  override def handle = {

    case ShowBilling =>
      effectOnly(
        Effect(
          Tauri.invoke[Unit]("show_billing").map(_ => NoChange)
        )
      )

    case ShowFeedback =>
      effectOnly(
        Effect(
          Tauri.invoke[Unit]("open_url").map(_ => NoChange)
        )
      )

    case ShowHaranaPlus =>
      effectOnly(
        Effect(
          Tauri.invoke[Unit]("show_signup").map(_ => NoChange)
        )
      )

    case ShowLogin =>
      effectOnly(
        Effect(
          Tauri.invoke[Unit]("show_login").map(_ => NoChange)
        )
      )

    case ShowSettings =>
      effectOnly(
        Effect(
          Tauri.invoke[Unit]("show_window", Map("label" -> "settings")).map(_ => NoChange)
        )
      )

    case ShowSupport =>
      effectOnly(
        Effect(
          Tauri.invoke[Unit]("open_url", Map("url" -> "https://github.com/harana/search/issues")).map(_ => NoChange)
        )
      )
  }
}