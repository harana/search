package com.harana.search.client.main

import com.harana.search.client.Circuit
import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.main.MainStore._
import com.harana.search.client.main.ui.Panel
import com.harana.search.client.search.SearchStore.{KeyDown => SearchKeyDown, KeyUp => SearchKeyUp}
import com.harana.search.client.share.ShareStore.{KeyDown => ShareKeyDown, KeyUp => ShareKeyUp}
import com.harana.search.client.system.SystemStore.WindowReady
import com.harana.web.actions._
import com.harana.web.external.tauri.Window
import diode.Effect.action
import diode._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

class MainHandler extends ActionHandler(zoomTo(_.mainState)) {

  override def handle = {

    case NoChange =>
      noChange

    case Init(preferences) =>
      noChange

    case KeyDown(key, event) =>
      val state = Circuit.state(_.mainState, false)
      effectOnly(
        action(
          state.activePanel match {
            case Panel.Search => SearchKeyDown(key, event)
            case Panel.Share => ShareKeyDown(key, event)
          }
        )
      )

    case KeyUp(key, event) =>
      val state = Circuit.state(_.mainState, false)
      effectOnly(
        action(
          state.activePanel match {
            case Panel.Search => SearchKeyUp(key, event)
            case Panel.Share => ShareKeyUp(key, event)
          }
        )
      )

    case UpdateActivePanel(panel) =>
      updated(value.copy(activePanel = panel))

  }
}