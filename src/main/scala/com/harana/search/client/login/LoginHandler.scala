package com.harana.search.client.login

import com.harana.search.client.Circuit.zoomTo
import com.harana.web.actions.Init
import diode._

class LoginHandler extends ActionHandler(zoomTo(_.loginState)) {
  override def handle = {

    case Init(preferences) =>
      noChange
  }
}