package com.harana.search.client.search.ui.rows

import com.harana.search.client.{Circuit, Icons}
import com.harana.search.client.models.Document
import com.harana.search.client.search.SearchStore.SelectDocument
import com.harana.web.components.when
import com.harana.web.external.tailwind.Badge
import com.harana.web.external.tailwind.SolidIcons.ChevronRightIcon
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.React
import slinky.web.html._

@react object DocumentRow {

  case class Props(document: Document,
                   active: Boolean,
                   tauriAssetsPrefix: String)

  val component: FunctionalComponent[Props] = React.memo(
    FunctionalComponent[Props] { props =>
      div(className := "px-3", key := s"${props.document.id}-${props.active}")(
        a(href := "#", onClick := (_ => Circuit.dispatch(SelectDocument(props.document.id, false))))(
          div(className := s"flex cursor-default select-none items-center rounded-md pl-2 pb-2 -pt-2 pr-1 py-2 ${if (props.active) "bg-gray-100 text-gray-900" else ""}")(
            div(className := "flex w-full")(
              div(className := "flex-none w-40")(
                Icons.integration(props.document.integrationId, Some(s"h-5 w-5 flex-none ${if (props.active) "text-gray-900" else "text-gray-500"}"))
              ),
              div(className := "grow grid grid-cols-1")(
                div(className := "col-span-2 truncate")(
                  span(className := s"w-full ${if (props.active) "font-semibold" else ""}")(props.document.title),
                ),
                div(className := "col-span-1 truncate")(
                  when(props.document.parentFolderName.isDefined)(
                    span(className := s"flex-auto text-xs font-medium leading-6 ${if (props.active) "text-gray-500" else "text-gray-400"}")(
                      props.document.parentFolderName.get.toLowerCase
                    )
                  )
                )
              ),
              div(className := "flex-none mxw-150 ml-2 text-right")(
                if (!props.active)
                  when(props.document.extension.isDefined)(
                    Badge.gray(props.document.extension.get.toLowerCase)
                  )
                else
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