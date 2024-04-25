package com.harana.search.client.share

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.main.MainStore.UpdateActivePanel
import com.harana.search.client.main.ui.Panel
import com.harana.search.client.share.ShareStore._
import com.harana.search.client.search.ui.Keys
import com.harana.web.actions.NoChange
import diode.Effect.action
import diode._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

class ShareKeyHandler extends ActionHandler(zoomTo(_.shareState)) {

  override def handle = {

    case KeyDown(key, event) =>
      println("KEY DOWN IN SHARE")
      effectOnly {
        if (key == Keys.Enter)
          action(UpdateActivePanel(Panel.Search))
        else
          action(NoChange)
      }

    case KeyUp(key, event) =>
      println("KEY UP IN SHARE")
      effectOnly {
        if (key == Keys.Escape)
          action(UpdateActivePanel(Panel.Search))
        else
          action(NoChange)
      }
  }
}