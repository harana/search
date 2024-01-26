package com.harana.search.client.thumbnail.ui

import com.harana.js.reactRouterDom.mod._
import com.harana.search.client.Circuit
import com.harana.search.client.thumbnail.ThumbnailStore.LoadDocument
import com.harana.search.client.viewers.Viewer
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.Hooks.useEffect
import slinky.web.html.{div, style}

import scala.scalajs.js

@react object ThumbnailPanel {

  val component = FunctionalComponent[Unit] { _ =>

    val params = useParams().asInstanceOf[js.Dictionary[String]]

    useEffect(() => {
      Circuit.dispatch(LoadDocument(params.get("id").get))
    }, List())

    val state = Circuit.state(_.thumbnailState, true)
    div(style := js.Dynamic.literal(
      "backgroundColor" -> "white",
      "overflowX" -> "hidden",
      "overflowY" -> "hidden",
      "height" -> "100%",
      "padding" -> "20px",
      "width" -> "100%"
    ))(
      Viewer(state.document, state.documentContent, state.viewer)
    )
  }
}