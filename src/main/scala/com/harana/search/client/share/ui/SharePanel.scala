package com.harana.search.client.share.ui

import com.harana.search.client.Circuit
import com.harana.search.client.search.SearchStore.Share
import com.harana.search.client.share.ShareStore.Cancel
import com.harana.web.external.tauri.Tauri
import slinky.core.annotations.react
import slinky.core.{CustomAttribute, FunctionalComponent}
import slinky.web.html._

import scala.scalajs.js.JSConverters._

@react object SharePanel {
  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    Tauri.invoke("update_window_size", Map("label" -> "search", "width" -> 960.0, "height" -> 680.0).toJSDictionary)

    val buttonClass = "relative inline-flex bg-white py-2 text-xs font-semibold ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-10"

    val recentUrls = List(
      ("https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=200&h=200&q=90", "Emma Clarke", "Frontend Developer"),
    )

    val personUrls = List(
      ("https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=200&h=200&q=90", "Emma Clarke", "Frontend Developer"),
      ("https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=200&h=200&q=90", "Isabella Rossi", "VP, Sales"),
      ("https://images.unsplash.com/photo-1519244703995-f4e0f30006d5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=200&h=200&q=90", "Luca Muller", "Data Engineer"),
      ("https://images.unsplash.com/photo-1517841905240-472988babdf9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=200&h=200&q=90", "Sophia Smith", "Customer Service Manager"),
      ("https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=200&h=200&q=90", "Aurelia Smith", "VP, Marketing"),
    )

    div(className := "mx-auto w-full h-410 overflow-auto transform divide-y divide-gray-100 rounded-xl bg-white bg-opacity-70 transition-all")(
      div(className := "grid grid-cols-3 gap-x-2 p-6 pl-8")(
        div(className := "sm:col-span-1 pr-6")(
          h2(className := "text-sm text-gray-600 mb-4")("Recent"),
          ul(role := "grid gap-x-8 gap-y-8")(
            recentUrls.map(p => person(p._1, p._2, p._3, personUrls.indexOf(p) == 0))
          )
        ),
        div(className := "sm:col-span-1 pr-6")(
          h2(className := "text-sm text-gray-600 mb-4")("Nearby"),
          ul(role := "grid gap-x-8 gap-y-2")(
            personUrls.map(p => person(p._1, p._2, p._3, false))
          )
        ),
        div(className := "sm:col-span-1 pr-2")(
          h2(className := "text-sm text-gray-600 mb-4")("Email or Search"),
          div(className := "mt-2 flex rounded-md shadow-sm")(
            div(className := "relative flex flex-grow items-stretch focus-within:z-10")(
              input(className := "block w-full rounded-md border-0 py-1.5 pr-10 text-gray-900 ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-emerald-600 sm:text-sm sm:leading-6")
            ),
          ),
          div(className := "absolute bottom-6 right-6")(
            button(onClick := (_ => Circuit.dispatch(Cancel)), CustomAttribute[String]("type") := "button", className := s"px-3 mr-2 rounded-md $buttonClass text-gray-900")("Cancel"),
            button(onClick := (_ => Circuit.dispatch(Share)), CustomAttribute[String]("type") := "button", className := s"px-3 rounded-md $buttonClass text-emerald-600")("Share")
          )
        )
      )
    )
  }

  def person(url: String, name: String, role: String, selected: Boolean) =
    li(className := s"mb-2 p-2 ${if (selected) "ring-1 ring-inset ring-emerald-600 rounded-md"}")(
      div(className := "flex items-center gap-x-6 gap-y-6")(
        img(className := "h-10 w-10 rounded-full", src := url),
        div(
          h5(className := "text-sm font-semibold leading-6 text-gray-900 -mt-1")(name),
          p(className := "text-xs text-gray-600 -mt-1")(role)
        )
      )
    )

  h5(className := "font-semibold leading-6 text-gray-900")
}
