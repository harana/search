package com.harana.search.client.welcome.ui

import com.harana.search.client.Circuit
import com.harana.search.client.icons.keyboard._
import com.harana.web.components.literal
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

@react object Step4Panel {

  type Props = Unit


  val component = FunctionalComponent[Unit] { _ =>
    val state = Circuit.state(_.welcomeState, true)

    div(
      p(className := titleCls)("Press the following to open Harana."),
        div(style := literal("paddingTop" -> "120px"))(
          if (state.overrideSpotlight)
            span(className := "inline-flex pl-14")(
              CommandIcon("pr-2", "43px"),
              SpaceIcon("", "43px")
            )
          else
            span(className := "inline-flex")(
              CommandIcon("mr-2 drop-shadow-md", "43px"),
              ShiftIcon("mr-2 drop-shadow-md", "43px"),
              SpaceIcon("drop-shadow-md", "43px")
            )
        )
    )
  }
}