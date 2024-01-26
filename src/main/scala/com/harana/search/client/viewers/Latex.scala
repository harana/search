package com.harana.search.client.viewers

import com.harana.web.components.when
import com.harana.web.external.latex.{Latex => ReactLatex}
import slinky.core.FunctionalComponent
import slinky.core.annotations.react

@react object Latex {

  case class Props(documentContent: Option[String])

  val component = FunctionalComponent[Props] { props =>

    when(props.documentContent.nonEmpty)(
      ReactLatex(s"$$${props.documentContent.get}$$")
    )
  }
}