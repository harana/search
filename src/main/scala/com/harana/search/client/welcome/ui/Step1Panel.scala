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
      p(className := titleCls)("Select the folders to search."),
      div(className := "grid grid-cols-2 gap-4 pt-14 pb-4 pl-4")(
        state.searchFolders.map(sf =>
          div(className := "flex items-center")(
            div(
              Switch(
                name = s"folder_${sf.nameOrPath}",
                label = None,
                className = "px-2 py-2",
                onChange = (_: js.Any) => Circuit.dispatch(UpdateSearchFolder(sf.copy(enabled = !sf.enabled))),
                enabled = sf.enabled
              )
            ),
            span(className := "pl-3 ml-3 text-sm font-medium text-gray-900")(sf.title)
          )
        )
      ),
      when(state.searchFolderStatus.nonEmpty,
        continueButton(UpdateSelectedStep(2))
      )
    )
  }
}