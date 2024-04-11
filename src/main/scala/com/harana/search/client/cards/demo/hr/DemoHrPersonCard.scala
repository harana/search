package com.harana.search.client.cards.demo.hr

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

object DemoHrPersonCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {
    div(className := "justify-center text-center")(
      ul(role := "list", className := "w-full mx-auto mt-3 grid max-w-2xl grid-cols-1")(
        li(
          img(className := "mx-auto h-175 w-175 rounded-full", src := "https://images.unsplash.com/photo-1519244703995-f4e0f30006d5?ixlib=rb-=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=8&w=1024&h=1024&q=80"),
          h3(className := "text-md mt-4 text-base font-semibold leading-7 tracking-tight text-gray-900")("Aiden Foster"),
          p(className := "text-sm leading-6 text-gray-600")("AI Lead, Hodinkee"),
          span(
            span(className := "mt-4 mr-1 inline-flex items-center rounded-full bg-green-50 px-2 py-1 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20")("SME"),
            span(className := "mt-4 inline-flex items-center rounded-full bg-gray-50 px-2 py-1 text-xs font-medium text-gray-700 ring-1 ring-inset ring-gray-600/20")("HiPo"),
            span(className := "mt-4 ml-1 inline-flex items-center rounded-full bg-red-50 px-2 py-1 text-xs font-medium text-red-700 ring-1 ring-inset ring-red-600/20")("Target")
          )
        )
      )
    )
  }
}