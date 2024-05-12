package com.harana.search.client.welcome.ui

import com.harana.search.client.Circuit
import com.harana.search.client.welcome.WelcomeStore.ShowWindow
import com.harana.web.components.literal
import com.harana.web.external.tailwind.OutlineIcons.XMarkOutlineIcon
import com.harana.web.external.tauri.Tauri.convertFileSrc
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.Hooks.useEffect
import slinky.web.html._

import scala.scalajs.js.Dynamic.{literal => css}

@react object WelcomePanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.welcomeState, true)

    println("SHOWING WELCOME PANEL")

    useEffect(() => {
      if (!state.windowShown)
        Circuit.dispatch(ShowWindow)
    })

    div(className := "bg-white")(
      div(className := "grid grid-cols-3")(
        div(className := "pl-10 col-span-2 pr-4")(
          div(
            img(className := "pt-8", style := literal("maxWidth" -> "84px"), src := convertFileSrc(s"assets/logo.png")),
            state.selectedStep match {
              case 1 => Step1Panel()
              case 2 => Step2Panel()
              case 3 => Step3Panel()
              case 4 => Step4Panel()
            }
          )
        ),
        div(className := "fixed right-0", style := literal("width" -> "280px"))(
          img(src := convertFileSrc(s"assets/onboarding_hero.jpg")),
        )
      )
    )
  }
}