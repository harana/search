package com.harana.search.client.cards.demo.building

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import com.harana.web.components.literal
import com.harana.web.external.tauri.Tauri.convertFileSrc
import slinky.core.facade.ReactElement
import slinky.web.html._

object DemoBuildingThumbnailCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {
    div(className := s"flex-none card-default")(
      img(style := literal("maxWidth" -> "320px"), src := convertFileSrc(s"assets/demos/floorplan.png"))
    )
  }

  override def title = Some("Rendered Floor Plan")
}