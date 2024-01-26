package com.harana.search.client.checkout

import com.harana.search.client.Circuit.zoomTo
import com.harana.web.actions.Init
import diode._

class CheckoutHandler extends ActionHandler(zoomTo(_.checkoutState)) {
  override def handle = {

    case Init(preferences) =>
      noChange
  }
}