package com.harana.search.client.search.ui.rows

import com.harana.search.client.models.Integration
import com.harana.search.client.search.SearchStore.SelectIntegration
import com.harana.search.client.{Circuit, Icons}
import com.harana.web.external.tailwind.SolidIcons.ChevronRightIcon
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.React
import slinky.web.html._

@react object IntegrationRow {

  case class Props(integration: Integration,
                   active: Boolean,
                   tauriAssetsPrefix: String)

  val component: FunctionalComponent[Props] = React.memo(
    FunctionalComponent[Props] { props =>
      div(className := "px-3", key := s"${props.integration.id}-${props.active}")(
        a(href := "#", onClick := (_ => Circuit.dispatch(SelectIntegration(props.integration.id))))(
          div(className := s"flex cursor-default select-none items-center rounded-md px-2 py-2 ${if (props.active) "bg-gray-100 text-gray-900" else ""}")(
            div(className := "flex w-full")(
              div(className := "flex-none w-40")(
                Icons.integration(props.integration.id, Some(s"h-5 w-5 flex-none ${if (props.active) "text-gray-900" else "text-gray-500"}"))
              ),
              div(className := "grow grid grid-cols-1")(
                div(className := "col-span-2 truncate")(
                  span(className := s"w-full ${if (props.active) "font-semibold" else ""}")(props.integration.title),
                )
              ),
              div(className := "flex-none w-25")(
                ChevronRightIcon(s"right h-5 w-5 flex-none text-gray-400 ${if (props.active) "opacity-100" else "opacity-0"}")
              )
            )
          )
        )
      )
    },
    (oldProps: Props, newProps: Props) => oldProps == newProps
  )
}