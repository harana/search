package com.harana.search.client.cards.general

import com.harana.search.client.cards.Card
import com.harana.search.client.models.{Document, Integrations}
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js
import scala.util.Random

object ThumbnailCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement =
    if (thumbnail.nonEmpty)
      div(className := s"flex-none card-default card-thumbnail")(img(src := thumbnail.getOrElse("#")))
    else
      div(className := s"flex-none card-default bg-gradient-to-br from-pink-500 to-orange-400")(
        span("default-icon")(Integrations.get(integration).icon)
      )
}