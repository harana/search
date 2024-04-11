package com.harana.search.client.cards.demo.customer

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.web.html._

object DemoCustomerInfoCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]) =
    table(className := "mt-2 ml-4 divide-y divide-gray-300")(
      tbody(className := "divide-y divide-gray-200 bg-white")(
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Total Spend"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("$3,5890.03")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Orders"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("14")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Location"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("Hobart, TAS")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-00 sm:pl-0")("Last Order"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("11 April 2024")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Reward Points"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("5434")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Subscriptions"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")("Email, SMS")
        ),
        tr(
          td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Tags"),
          td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")(
            span(className := "mr-1 inline-flex items-center rounded-full bg-green-50 px-2 py-1 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20")("High Value"),
          )
        )
      )
    )

  override def title = Some("Information")
}