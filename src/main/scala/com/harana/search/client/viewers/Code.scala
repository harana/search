package com.harana.search.client.viewers

import com.harana.js.highlightJs.mod.{HighlightOptions, default => HighlightJs}
import com.harana.search.client.models.Document
import com.harana.web.components.when
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

import scala.scalajs.js

@react object Code {

  case class Props(document: Option[Document],
                   documentContent: Option[String])

  val component = FunctionalComponent[Props] { props =>

    when(props.documentContent.nonEmpty) {
      val extension = props.document.get.extension.getOrElse("txt")

      pre(
        code(dangerouslySetInnerHTML := js.Dynamic.literal(
            "__html" -> HighlightJs.highlight(props.documentContent.get, HighlightOptions(extension)).value
          )
        )
      )
    }
  }
}