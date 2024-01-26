package com.harana.search.client.cards.general

import com.harana.search.client.Icons
import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js

object PageCard extends Card {

  def apply(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {
    div(className := s"flex-none card-default bg-gradient-to-r from-teal-200 to-lime-200")(
      Icons.integration(integration, Some("default-icon"))
    )
  }
}