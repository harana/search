package com.harana.search.client.login.ui

import com.harana.search.client.Circuit
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html.div

import scala.scalajs.js

@react object LoginPanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.loginState, true)

    div()

  }
}