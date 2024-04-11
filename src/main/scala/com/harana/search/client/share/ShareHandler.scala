package com.harana.search.client.share

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.main.MainStore.UpdateActivePanel
import com.harana.search.client.main.ui.Panel
import com.harana.search.client.share.ShareStore.{Cancel, Share}
import com.harana.web.actions._
import diode.Effect.action
import diode._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

class ShareHandler extends ActionHandler(zoomTo(_.shareState)) {

  override def handle = {

    case NoChange =>
      noChange

    case Init(preferences) =>
      noChange

    case Share =>
      effectOnly(action(UpdateActivePanel(Panel.Search)))

    case Cancel =>
      effectOnly(action(UpdateActivePanel(Panel.Search)))

  }
}