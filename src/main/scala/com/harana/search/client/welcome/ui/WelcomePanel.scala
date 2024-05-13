package com.harana.search.client.welcome.ui

import com.harana.search.client.Circuit
import com.harana.web.components.literal
import com.harana.web.external.tauri.Tauri.convertFileSrc
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

@react object WelcomePanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.welcomeState, true)

    div(className := "bg-white")(
      div(className := "grid grid-cols-3")(
        div(className := "pl-10 col-span-2 pr-4")(
          div(drag := true)(
            img(drag := true, className := "pt-8", style := literal("maxWidth" -> "84px"), src := convertFileSrc(s"assets/logo.png")),
            state.selectedStep match {
              case 1 => Step1Panel()
              case 2 => Step2Panel()
              case 3 => Step3Panel()
              case 4 => Step4Panel()
            }
          )
        ),
        div(className := "fixed right-0", style := literal("width" -> "280px"))(
          img(drag := true, src := convertFileSrc(s"assets/onboarding_hero.jpg")),
        )
      )
    )
  }
}