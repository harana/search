package com.harana.search.client.cards.general

import com.harana.search.client.cards.Card
import com.harana.search.client.models.{Document, Integrations}
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js
import scala.util.Random

object CodeCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {
    div(className := s"flex-none card-default bg-gradient-to-r from-cyan-500 to-blue-500")(
      span(className := "default-icon")(Integrations.get(integration).icon)
    )
  }
}