package com.harana.search.client.cards.demo.software

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.web.html._

object DemoSoftwareTableCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]) =
    table(className := "mt-2 ml-4 divide-y divide-gray-300")(
      tbody(className := "divide-y divide-gray-200 bg-white")(
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Version"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("2.8.5")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("License"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")(
            span(className := "mr-1 inline-flex items-center rounded-full bg-green-50 px-2 py-1 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20")("MIT")
          )
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Updated"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("5 years ago")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Author"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("dougwilson")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Size"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("20kb")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Downloads"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("9,575,144")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Tags"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")(
            span(className := "inline-flex items-center rounded-full bg-gray-50 px-2 py-1 text-xs font-medium text-gray-700 ring-1 ring-inset ring-gray-600/20")("cors"),
            span(className := "inline-flex ml-1 items-center rounded-full bg-gray-50 px-2 py-1 text-xs font-medium text-gray-700 ring-1 ring-inset ring-gray-600/20")("connect"),
          )
        )
      )
    )

  override def title = Some("Customer")
}