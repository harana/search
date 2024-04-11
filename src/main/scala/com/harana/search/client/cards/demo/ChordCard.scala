package com.harana.search.client.cards.demo

import com.harana.search.client.cards.Card
import com.harana.search.client.cards.temp._
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js

object ChordCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement =
    div(className := "justify-center")(
      Chord(
        width = 310,
        height = 280,
        margin = new Margin {
          override val top = 15
          override val bottom = 20
          override val left = 20
          override val right = 30
        },
        keys = js.Array("Michael", "Chloe", "Taylor", "Joe", "Rachel"),
        data = js.Array(
          js.Array(418, 1626, 1555, 1220, 205),
          js.Array(122, 1738, 463, 493, 1801),
          js.Array(71, 300, 67, 256, 243),
          js.Array(384, 252, 408, 74, 1897),
          js.Array(285, 315, 1724, 260, 1946)
        )
      )
    )

  override val title = Some("Units Sold")
}