package com.harana.search.client.viewers

import com.harana.web.components.when
import com.harana.web.external.markdown.{Markdown => ReactMarkdown}
import slinky.core.FunctionalComponent
import slinky.core.annotations.react

@react object Markdown {

  case class Props(documentContent: Option[String])

  val component = FunctionalComponent[Props] { props =>

    when(props.documentContent.nonEmpty)(
      ReactMarkdown(props.documentContent.get)
    )
  }
}