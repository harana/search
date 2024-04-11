package com.harana.search.client.integrations.ui

import com.harana.search.client.Circuit
import com.harana.search.client.integrations.IntegrationsStore._
import com.harana.web.external.tailwind.SolidIcons._
import com.harana.web.components.when
import com.harana.web.external.tailwind.OutlineIcons._
import com.harana.web.external.tailwind._
import com.harana.web.external.tauri.Tauri
import slinky.core.{CustomAttribute, FunctionalComponent}
import slinky.core.annotations.react
import slinky.core.facade.Fragment
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.JSConverters.JSRichMap

@react object IntegrationsPanel {

  val component = FunctionalComponent[Unit] { _ =>

    val navigationItems = List(
      ("Customer", "Description about billing", ChatBubbleLeftEllipsisOutlineIcon("text-gray-400")),
      ("Engineering", "Description about indexing", CircleStackIcon("text-gray-400")),
      ("Finance", "Description about billing", CreditCardOutlineIcon("text-gray-400")),
      ("Human Resources", "Description about billing", CreditCardOutlineIcon("text-gray-400")),
      ("Marketing", "Description about billing", CreditCardOutlineIcon("text-gray-400")),
      ("News", "Description about billing", NewspaperOutlineIcon("text-gray-400")),
      ("Other", "Description about billing", RectangleGroupOutlineIcon("text-gray-400")),
      ("Product", "Description about billing", SwatchOutlineIcon("text-gray-400")),
      ("Productivity", "Description about billing", DocumentTextOutlineIcon("text-gray-400")),
      ("Sales", "Description about billing", FunnelOutlineIcon("text-gray-400")),
      ("Shopping", "Description about billing", ShoppingBagOutlineIcon("text-gray-400")),
    )

    val state = Circuit.state(_.integrationsState, true)
    val searchState = Circuit.state(_.searchState, true)
    val systemState = Circuit.state(_.systemState, true)

    val drag = new CustomAttribute[Boolean]("data-tauri-drag-region")
    Tauri.invoke("update_window_size", Map("width" -> 950.0, "height" -> 465.0).toJSDictionary)

    div(className := "flex min-h-[720px] bg-white rounded-xl")(
      div(className := "flex w-60 flex-col")(
        div(drag := true, className := "flex grow flex-col gap-y-5 overflow-y-auto border-r border-gray-200 bg-white px-6")(
          div(drag := true, className := "flex h-16 shrink-0 items-center")(
            a(href := "/search")(XMarkOutlineIcon(className = "h-6 w-6 text-gray-400 right"))
          ),
          nav(className := "flex flex-1 flex-col")(
            ul(drag := true, role := "list", className := "flex flex-1 flex-col gap-y-7")(
              li(
                ul(drag := true, role := "list", className := "-mx-2 space-y-1")(
                  li(key := "popular")(
                    a(href := "#", onClick := (_ => Circuit.dispatch(SelectPopular)), className := "text-gray-700 hover:text-indigo-600 hover:bg-gray-50 group flex gap-x-3 rounded-md p-2 cursor-default select-none text-sm leading-6 font-semibold")(
                      span(className := "mt-2 flex h-5 w-5 shrink-0", style := js.Dynamic.literal("marginTop" -> "1.5px"))(
                        FireOutlineIcon("text-gray-400")
                      ),
                      span(className := "truncate")("Popular")
                    )
                  )
                )
              ),
              li(
                ul(drag := true, role := "list", className := "-mx-2 space-y-1")(
                  navigationItems.map { item =>
                    li(key := item._1)(
                      a(href := "#", onClick := (_ => Circuit.dispatch(SelectCategory(item._1))), className := "text-gray-700 hover:text-indigo-600 hover:bg-gray-50 group flex gap-x-3 rounded-md p-2 cursor-default select-none text-sm leading-6 font-semibold")(
                        span(className := "mt-2 flex h-5 w-5 shrink-0", style := js.Dynamic.literal("marginTop" -> "1.5px"))(
                          item._3
                        ),
                        span(className := "truncate")(item._1)
                      )
                    )
                  }
                )
              ),
              li(
                ul(role := "list", className := "-mx-2 space-y-1")(
                  when(state.installedIntegrations.nonEmpty)(
                    li(key := "installed")(
                      a(href := "#", onClick := (_ => Circuit.dispatch(SelectInstalled)), className := "text-gray-700 hover:text-indigo-600 hover:bg-gray-50 group flex gap-x-3 rounded-md p-2 cursor-default select-none text-sm leading-6 font-semibold")(
                        span(className := "mt-2 flex h-5 w-5 shrink-0", style := js.Dynamic.literal("marginTop" -> "1.5px"))(
                          ArrowDownCircleOutlineIcon("text-gray-400")
                        ),
                        span(className := "truncate")("Installed")
                      )
                    )
                  ),
                  when(state.favouriteIntegrations.nonEmpty)(
                    li(key := "favourites")(
                      a(href := "#", onClick := (_ => Circuit.dispatch(SelectFavourites)), className := "text-gray-700 hover:text-indigo-600 hover:bg-gray-50 group flex gap-x-3 rounded-md p-2 cursor-default select-none text-sm leading-6 font-semibold")(
                        span(className := "mt-2 flex h-5 w-5 shrink-0", style := js.Dynamic.literal("marginTop" -> "1.5px"))(
                          StarOutlineIcon("text-gray-400")
                        ),
                        span(className := "truncate")("Favourites")
                      )
                    )
                  )
                )
              )
            )
          )
        )
      ),
      main(drag := true, className := "bg-gray-50 py-12 lg:pl-72 w-full")(
        div(className := "px-10")(
          ul(role := "list", className := "grid grid-cols-2 gap-6 sm:grid-cols-2 md:grid-cols-2 lg:grid-cols-2")(
            state.currentIntegrations.map(integration =>
              li(className := "flex flex-col") {
                ButtonCard(
                  content =
                    Fragment(
                      div(className := "grid grid-cols-3 gap-4")(
                        div(
                          img(src := s"${systemState.appAssetsUrl}/icons/connectors/remote-${integration.id}.svg", className := "h-16 w-16 pb-2 flex-none rounded-full")
                        ),
                        div(className := "col-start-2 col-span-2 ml--2 text-left")(
                          h3(className := "text-semibold font-medium text-gray-900 ml--2 mr--8")(integration.title),
                          div(style := js.Dynamic.literal("margin-left" -> "-13px"))(Badge.gray(integration.category))
                        ),
                        div(className := "col-span-4 mt--4 pl-2 text-left")(
                          span(className := "text-xs text-gray-500")(integration.description)
                        )
                      )
                    ),
                  firstText = "Install",
                  firstOnClick = () => (),
                  className = Some("integrations-card"),
                  contentPadding = Some("p-4")
                )
              }
            )
          )
        )
      )
    )
  }
}
