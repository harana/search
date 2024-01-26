package com.harana.search.client.cards.general

import com.harana.search.client.Icons
import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js
import scala.util.Random

object MapCard extends Card {

  def apply(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {
    div(className := s"flex-none card-default bg-gradient-to-r from-purple-500 to-pink-500")(
      Icons.integration(integration, Some("default-icon"))
    )
  }
}