package com.harana.search.client.settings.rules.ui

import com.harana.search.client.Circuit
import com.harana.search.client.settings.rules.RulesStore.{AddRule, DeleteRule}
import com.harana.web.external.tailwind.OutlineIcons._
import com.harana.web.external.tailwind._
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => css}
import scala.scalajs.js.|

@react object RulesPanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.rulesState, true)

    div(className := "grid grid-cols-1 gap-x-10 gap-y-8 sm:grid-cols-6")(
      div(className := "sm:col-span-6")(
        div(style := css("paddingBottom" -> "40px"))(
          div(className := "left")(Heading("Rules")),
          Button(
            label = None,
            icon = Some(PlusOutlineIcon("h-4 w-4")),
            size = ButtonSize.ExtraSmall,
            className = Some("right text-gray-600"),
            onClick = () => Circuit.dispatch(AddRule)
          )
        ),
        state.rules.map(rule =>
          div(className := "-mx-4 -my-2 sm:-mx-6 lg:-mx-8")(
            div(className := "inline-block min-w-full py-2 align-middle sm:px-6 lg:px-8")(
              div(className := "shadow ring-1 ring-black ring-opacity-5 sm:rounded-lg")(
                table(className := "min-w-full divide-y divide-gray-300")(
                  tbody(className := "divide-y divide-gray-200 bg-white")(
                    tr(
                      td(className := "p-1 pt-2 sm:rounded-tl-lg")(
                        div(className := "right block text-sm font-medium leading-6 text-gray-900 pr-2")("when")
                      ),
                      td(className := "p-1 pt-2")(
                        Listbox(
                          "font-size",
                          selectedItem = "file name",
                          items = List("file name", "5:00pm", "5:00pm").map(_.asInstanceOf[js.Any]),
                          itemId = item => item.toString,
                          itemTitle = item => item.toString,
                          label = None,
                          onChange = item => ()
                        )
                      ),
                      td(className := "p-1 pt-2")(
                        Listbox(
                          "font-size",
                          selectedItem = "contains",
                          items = List("contains", "5:00pm", "5:00pm").map(_.asInstanceOf[js.Any]),
                          itemId = item => item.toString,
                          itemTitle = item => item.toString,
                          label = None,
                          onChange = item => ()
                        )
                      ),
                      td(className := "p-1 pt-2")(
                        Input("postal-code", placeholder = Some("ZIP / Postal Code"), roundTop = true, roundBottom = true)
                      ),
                      td(className := s"text-right pr-4 p-1 rounded-tr-lg rounded-br-lg", rowSpan := 2)(
                        Button(
                          label = None,
                          icon = Some(TrashOutlineIcon("h-4 w-4")),
                          size = ButtonSize.ExtraSmall,
                          className = Some("right text-gray-600"),
                          onClick = () => Circuit.dispatch(DeleteRule(rule))
                        )
                      )
                    ),
                    tr(className := "rounded-bl-lg")(
                      td(className := "p-1 pb-2")(
                        div(className := "right block text-sm font-medium leading-6 text-gray-900 pr-2")("then")
                      ),
                      td(className := "p-1 pb-2")(
                        Listbox(
                          "font-size",
                          selectedItem = "add tag",
                          items = List("add tag", "5:00pm", "5:00pm").map(_.asInstanceOf[js.Any]),
                          itemId = item => item.toString,
                          itemTitle = item => item.toString,
                          label = None,
                          onChange = item => ()
                        )
                      ),
                      td(),
                      td()
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  }
}
