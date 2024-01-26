package com.harana.search.client.welcome.ui

import com.harana.search.client.Circuit
import com.harana.search.client.welcome.WelcomeStore.{HideWindow, UpdateSearchFolder}
import com.harana.web.external.tailwind.{Button, ButtonSize, Switch}
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

import scala.scalajs.js

@react object Step2Panel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.welcomeState, true)

    val cls = "inline-flex justify-center items-center py-2 bg-white border border-gray-200 font-mono text-gray-800 rounded-md shadow-[0px_2px_0px_0px_rgba(0,0,0,0.08)] dark:bg-slate-900 dark:border-gray-700 dark:text-gray-200 dark:shadow-[0px_2px_0px_0px_rgba(255,255,255,0.1)]"

    div(
      h2(className := "text-base font-semibold leading-7 text-green-600")("harana"),
      p(className := "mt-2 text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl")("Ready"),
      p(className := "mt-6 text-lg leading-8 text-gray-600")(
        "Press the following to continue."
      ),
      kbd(className := s"$cls text-lg px-6")("⌘"),
      kbd(className := s"$cls text-m px-8")("Space"),
    )
  }
}