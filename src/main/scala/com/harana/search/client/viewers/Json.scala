package com.harana.search.client.viewers

import com.harana.web.components.when
import com.harana.web.external.json_lens.JsonLens
import slinky.core.FunctionalComponent
import slinky.core.annotations.react

import scala.scalajs.js.JSON

@react object Json {

  case class Props(documentContent: Option[String])

  val component = FunctionalComponent[Props] { props =>

    when(props.documentContent.nonEmpty)(
      JsonLens(JSON.parse(props.documentContent.get))
    )
  }
}