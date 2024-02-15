package com.harana.search.client.search.ui

import com.harana.search.client.Circuit
import com.harana.search.client.preview.PreviewStore.{KeyDown, KeyUp}
import com.harana.search.client.viewers.Viewer
import com.harana.web.components.when
import com.harana.web.external.tauri.Tauri.convertFileSrc
import org.scalajs.dom._
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.Hooks.useEffect
import slinky.web.html.{className, div, img, s, span, src, style}

import scala.scalajs.js

@react object ApplicationHint {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.searchState, true)

    when(state.searchApplication,
      div(className := "application-hint pr-10")(
        img(src := convertFileSrc(state.searchApplication.get.targetIconPath)),
        span(state.searchApplication.get.name)
      )
    )
  }
}