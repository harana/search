package com.harana.search.client.viewers

import com.harana.web.components.when
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

@react object Text {

  case class Props(documentContent: Option[String])

  val component = FunctionalComponent[Props] { props =>

    when(props.documentContent.nonEmpty)(
      div(props.documentContent.get)
    )
  }
}