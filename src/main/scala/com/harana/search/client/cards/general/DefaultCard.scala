package com.harana.search.client.cards.general

import com.harana.search.client.Icons
import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js
import scala.util.Random

object DefaultCard extends Card {

  def apply(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {
    div(className := s"flex-none card-default bg-gradient-to-br from-pink-500 to-orange-400")(
      Icons.integration(integration, Some("default-icon"))
    )
  }
}