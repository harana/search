package com.harana.search.client.welcome.ui

import com.harana.search.client.Circuit
import com.harana.search.client.welcome.WelcomeStore.ShowWindow
import com.harana.web.external.tailwind.OutlineIcons.XMarkOutlineIcon
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.Hooks.useEffect
import slinky.web.html._

import scala.scalajs.js.Dynamic.{literal => css}

@react object WelcomePanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.welcomeState, true)

    useEffect(() => {
      if (!state.windowShown)
        Circuit.dispatch(ShowWindow)
    })

    div(className := "bg-white")(
      div(className := "relative isolate px-8 pt-12")(
        div(className := "absolute inset-x-0 -top-40 -z-10 transform-gpu overflow-hidden blur-3xl sm:-top-80")(
          div(className := "relative left-[calc(50%-11rem)] aspect-[1155/678] w-[36.125rem] -translate-x-1/2 rotate-[30deg] bg-gradient-to-tr from-[#ff80b5] to-[#9089fc] opacity-30 sm:left-[calc(50%-30rem)] sm:w-[72.1875rem]",
            style := css("clipPath" -> "polygon(74.1% 44.1%, 100% 61.6%, 97.5% 26.9%, 85.5% 0.1%, 80.7% 2%, 72.5% 32.5%, 60.2% 62.4%, 52.4% 68.1%, 47.5% 58.3%, 45.2% 34.5%, 27.5% 76.7%, 0.1% 64.9%, 17.9% 100%, 27.6% 76.8%, 76.1% 97.7%, 74.1% 44.1%)")
          )
        )
      ),
      div(className := "mx-auto max-w-7xl px-6 lg:px-8")(
        div(className := "mx-auto grid max-w-2xl grid-cols-1 gap-x-8 gap-y-16 sm:gap-y-20 lg:mx-0 lg:max-w-none lg:grid-cols-2")(
          div(className := "lg:pr-8 lg:pt-4")(
            div(className := "lg:max-w-lg")(
              state.selectedStep match {
                case 1 => Step1Panel()
                case 2 => Step2Panel()
              }
            )
          )
        )
      )
    )
  }
}