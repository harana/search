package com.harana.search.client.welcome.ui

import com.harana.search.client.Circuit
import com.harana.search.client.welcome.WelcomeStore.{CompleteOnboarding, UpdateSearchFolder, UpdateSelectedStep}
import com.harana.web.components.when
import com.harana.web.external.tailwind.OutlineIcons.CheckCircleOutlineIcon
import com.harana.web.external.tailwind.{Button, ButtonSize, Switch}
import diode.ActionBatch
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

import scala.scalajs.js

@react object Step1Panel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.welcomeState, true)

    span(
      h2(className := "text-base font-semibold leading-7 text-green-600 logo")("harana"),
      p(className := "mt-2 text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl headlinee")("Welcome"),
      p(className := "mt-6 text-lg leading-8 text-gray-600")(
        "Select the folders you want to search."
      ),
      div(className := "grid grid-cols-3 gap-4 pt-14")(
        state.searchFolders.map(sf =>
          div(className := "flex items-center")(
            div(
              state.searchFolderStatus.get(sf.nameOrPath) match {
                case None =>
                  Switch(
                    name = s"folder_${sf.nameOrPath}",
                    label = None,
                    className = "px-4 py-2",
//                    enabledColor = "bg-emerald-600",
                    onChange = (_: js.Any) => Circuit.dispatch(UpdateSearchFolder(sf.copy(enabled = !sf.enabled))),
                    enabled = sf.enabled
                  )

                case Some(status) =>
                  if (status)
                    div(className := "pl-4 pr-8")(CheckCircleOutlineIcon("h-7 w-7"))
                  else
                    div(className := "pl-4 pr-10")(div(className := "loader"))
              },
            ),
            span(className := "pl-3 ml-3 text-sm font-medium text-gray-900")(sf.title)
          )
        )
      ),
      when(state.searchFolderStatus.nonEmpty,
        div(className := "pt-20 center")(
          Button(
            label = Some("Continue"),
            size = ButtonSize.Large,
            textColor = "white",
            backgroundColor = "bg-emerald-600",
            hoverColor = "bg-emerald-500",
            rounded = true,
            onClick = () => Circuit.dispatch(
              ActionBatch(
                CompleteOnboarding,
                UpdateSelectedStep(2)
              )
            )
          )
        )
      )
    )
  }
}