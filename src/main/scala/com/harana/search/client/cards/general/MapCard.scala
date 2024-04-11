package com.harana.search.client.cards.general

import com.harana.search.client.cards.Card
import com.harana.search.client.cards.temp.{Choropleth, Entry}
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html.div

import scala.scalajs.js

object MapCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {
    div()
    Choropleth(
      data = js.Array(
        new Entry {
          override val id = "AUS"
          override val value = 4
        }
      ),
      domain = js.Array(0, 10000),
      width = 300,
      height = 300
    )
  }

  override def title = Some("Map")
}