package com.harana.search.client.viewers

import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

@react object Bim {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    div()

  }
}