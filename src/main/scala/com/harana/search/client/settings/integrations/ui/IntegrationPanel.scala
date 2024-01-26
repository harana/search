package com.harana.search.client.settings.integrations.ui

import com.harana.search.client.Circuit
import com.harana.web.external.tailwind._
import com.harana.web.external.tauri.Tauri.convertFileSrc
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

@react object IntegrationPanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.integrationsState, true)

    div(className := "grid grid-cols-5 gap-8 ml--4")(
      div(className := "mt--4")(
        div(className := "flex items-center justify-center")(
          div(img(className := "w-125", src := convertFileSrc(s"assets/icons/connectors/remote-airtable.svg"))),
        ),
        div(className := "flex items-center justify-center")(
          div(Heading("Airtable"))
        ),
        div(className := "flex items-center justify-center pt-6")(
          Button(label = Some("Uninstall"), size = ButtonSize.Medium, onClick = () => ())
        )
      ),
      div(className := "col-start-2 col-span-4")(
        Table(
          name = "integrations",
          headers = List("Key", "Value"),
          rows = List(
            List(
              div(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-4")("Name"),
              div(className := "whitespace-nowrap py-2 text-sm text-gray-900")("Value"),
            ),
            List(
              div(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-4")("Name 2"),
              div(className := "whitespace-nowrap py-2 text-sm text-gray-900")("Value"),
            )
          ),
          className = ""
        )
      )
    )
  }
}
