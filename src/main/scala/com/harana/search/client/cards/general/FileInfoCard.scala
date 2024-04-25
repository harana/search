package com.harana.search.client.cards.general

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import com.harana.web.components.when
import slinky.core.facade.ReactElement
import slinky.web.html._

object FileInfoCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]) =
     table(className := "mt-2 ml-4 divide-y divide-gray-300")(
      tbody(className := "divide-y divide-gray-200 bg-white")(
        when(document.created,
          tr(
            td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Created"),
            td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")(document.created)
          )
        ),
        when(document.modified,
          tr(
            td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Modified"),
            td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")(document.modified)
          )
        ),
        when(document.accessed,
          tr(
            td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Accessed"),
            td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")(document.accessed)
          )
        ),
        when(document.size,
          tr(
            td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Size"),
            td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")(document.size)
          )
        ),
        when(document.extensionTitle,
          tr(
            td(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-0")("Type"),
            td(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")(document.extensionTitle)
          )
        )
      )
    )

  override def title = Some("File Information")
}