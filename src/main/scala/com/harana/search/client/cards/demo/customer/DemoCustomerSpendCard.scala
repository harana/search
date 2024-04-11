package com.harana.search.client.cards.demo.customer

import com.harana.search.client.cards.Card
import com.harana.search.client.cards.temp._
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js

object DemoCustomerSpendCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement =
    div(className := "justify-center")(
      Pie(
        width = 320,
        height = 320,
        margin = new Margin {
          override val top = 0
          override val bottom = 50
          override val left = 80
          override val right = 100
        },
        data = js.Array(
          js.Dictionary(
            "id"    -> "Sofas",
            "label" -> "Sofas",
            "value" -> 5590,
            "color" -> "hsl(32, 70%, 50%)"
          ),
          js.Dictionary(
            "id"    -> "Tables",
            "label" -> "Tables",
            "value" -> 1421,
            "color" -> "hsl(146, 70%, 50%)"
          ),
          js.Dictionary(
            "id"    -> "Accessories",
            "label" -> "Accessories",
            "value" -> 426,
            "color" -> "hsl(127, 70%, 50%)"
          ),
          js.Dictionary(
            "id"    -> "Beds",
            "label" -> "Beds",
            "value" -> 3550,
            "color" -> "hsl(57, 70%, 50%)"
          ),
          js.Dictionary(
            "id"    -> "Chairs",
            "label" -> "Chairs",
            "value" -> 1950,
            "color" -> "hsl(38, 70%, 50%)"
          )
        )
      )
    )

  override val title = Some("Total Spend")
}