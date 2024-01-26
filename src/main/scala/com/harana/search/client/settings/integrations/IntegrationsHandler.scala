package com.harana.search.client.settings.integrations

import com.harana.search.client.Circuit.zoomTo
import com.harana.web.actions.Init
import diode._

class IntegrationsHandler extends ActionHandler(zoomTo(_.integrationsState)) {
  override def handle = {

    case Init(preferences) =>
      noChange

  }
}