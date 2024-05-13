package com.harana.search.client.welcome.ui

import com.harana.search.client.Circuit
import com.harana.search.client.welcome.WelcomeStore._
import com.harana.web.external.tailwind.Switch
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

import scala.scalajs.js

@react object Step2Panel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.welcomeState, true)

    val items = List(
      ("Replace Spotlight Shortcut", "Make Harana the primary search tool on your Mac", "by adopting the Command-Space shortcut.", state.overrideSpotlight, (_: js.Any) => Circuit.dispatch(UpdateOverrideSpotlight(!state.overrideSpotlight))),
      ("Share Analytics with Harana", "Help Harana improve its products by automatically", "sending anonymous diagnostics and usage data.", state.allowTelemetry, (_: js.Any) => Circuit.dispatch(UpdateAllowTelemetry(!state.allowTelemetry))),
      ("Anonymous Mode", "Disables search history, Airdrop style sharing and", "other related features for the ultimate in privacy.", state.anonymousMode, (_: js.Any) => Circuit.dispatch(UpdateAnonymousMode(!state.anonymousMode))),
    )

    div(drag := true)(
      p(drag := true, className := titleCls)("Customise your search experience."),
      items.map { item =>
        div(drag := true, className := "flex items-center justify-between pb-6 ml-6 mt-2")(
          Switch("always_center_window", None, item._4, item._5, ""),
          span(drag := true, className := "flex flex-grow flex-col pl-6 pt-4 ml-4")(
            span(drag := true, className := "pb-1 text-sm font-small leading-6 text-gray-900")(item._1),
            span(drag := true, className := "text-xs font-medium text-gray-500")(item._2),
            span(drag := true, className := "text-xs font-medium text-gray-500")(item._3)
          )
        )
      },
      continueButton(UpdateSelectedStep(3))
    )
  }
}