package com.harana.search.client.viewers

import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

@react object SeqViz {

  type Props = Unit

  val component = FunctionalComponent[Props] { props =>

    div()

  }
}