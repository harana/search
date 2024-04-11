package com.harana.search.client.cards.general

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import com.harana.web.components.literal
import com.harana.web.external.tauri.Tauri.convertFileSrc
import slinky.core.facade.ReactElement
import slinky.web.html._

object SampleCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {
    div(className := s"flex-none card-default")(
      img(style := literal("max-width" -> "320px"), src := convertFileSrc(s"assets/card.jpg"))
    )
  }
}