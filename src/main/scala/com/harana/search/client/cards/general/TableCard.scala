package com.harana.search.client.cards.general

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.web.html._

object TableCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]) =
    table(className := "mt-2 ml-4 divide-y divide-gray-300")(
      tbody(className := "divide-y divide-gray-200 bg-white")(
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Email"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("naden@mac.com")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Phone"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("+61 422 882 082")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Instagram"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("@nadenf")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Total Spend"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("$230.42")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Rewards Points"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("543")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Instagram"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("@nadenf")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Total Spend"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("$230.42")
        )
      )
    )

  override def title = Some("Table")
}