package com.harana.search.client.cards.general

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

object AddressCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement =
    div(className := "border-gray-200 bg-white px-3 py-2")(
      div(className := "-ml-2 -mt-2 flex flex-wrap items-center justify-between sm:flex-nowrap")(
        div(className := "ml-2 mt-2")(
          h5(className := "font-semibold leading-6 text-gray-900")("Job Postings")
        )
      )
    )

  override val showBorder = true
}