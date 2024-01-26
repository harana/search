package com.harana.search.client.preview.ui

import com.harana.search.client.Circuit
import com.harana.search.client.preview.PreviewStore.{KeyDown, KeyUp}
import com.harana.search.client.viewers.Viewer
import org.scalajs.dom._
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.Hooks.useEffect
import slinky.web.html.{div, style}

import scala.scalajs.js

@react object PreviewPanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.previewState, true)
    val viewerType = state.viewer.getOrElse("Noop")

    useEffect(
      () => {
        val keyDownListener = (e: KeyboardEvent) => Circuit.dispatch(KeyDown(e.keyCode, e))
        val keyUpListener = (e: KeyboardEvent) => Circuit.dispatch(KeyUp(e.keyCode, e))
        window.addEventListener("keydown", keyDownListener, false)
        window.addEventListener("keyup", keyUpListener, false)
        () => {
          window.removeEventListener("keydown", keyDownListener, false)
          window.removeEventListener("keyup", keyUpListener, false)
        }
      },
      Seq.empty
    )

    div(style := js.Dynamic.literal(
      "backgroundColor" -> "white",
      "overflowX" -> "hidden",
      "overflowY" -> "hidden",
      "height" -> "100%",
      "padding" -> "20px",
      "width" -> "100%"
    ))(
      div(viewerType, Viewer(state.document, state.documentContent, state.viewer))
    )
  }
}