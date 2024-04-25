package com.harana.search.client.cards.orders

import com.harana.search.client.cards.Card
import com.harana.search.client.models.{Document, Integrations}
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

object FraudAnalysisCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {
    div(className := s"flex-none card-default bg-gradient-to-br from-green-400 to-blue-600")(
      span(className := "default-icon")(Integrations.get(integration).icon)
    )
  }
}