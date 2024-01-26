package com.harana.search.client.support

import com.harana.search.client.Circuit.zoomTo
import com.harana.web.actions.Init
import diode._

class SupportHandler extends ActionHandler(zoomTo(_.supportState)) {
  override def handle = {

    case Init(preferences) =>
      noChange
  }
}