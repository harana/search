package com.harana.search.client.cards.demo.sales

import com.harana.search.client.cards.Card
import com.harana.search.client.cards.temp.{Bar, Margin}
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js

object DemoSalesBarCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {
    div(className := "justify-center")(
      Bar(
        width = 310,
        height = 280,
        margin = new Margin {
          override val top = 15
          override val bottom = 25
          override val left = 40
          override val right = 20
        },
        keys = js.Array("hot dog", "burger", "sandwich", "kebab", "fries", "donut"),
        indexBy = "country",
        data = js.Array(
          js.Dictionary(
            "country"       -> "AU",
            "hot dog"       -> "69",
            "hot dogColor"  -> "hsl(351, 70%, 50%)",
            "burger"        -> "192",
            "burgerColor"   -> "hsl(114, 70%, 50%)",
            "sandwich"      -> "180",
            "sandwichColor" -> "hsl(97, 70%, 50%)",
            "kebab"         -> "133",
            "kebabColor"    -> "hsl(13, 70%, 50%)",
            "fries"         -> "158",
            "friesColor"    -> "hsl(125, 70%, 50%)",
            "donut"         -> "20",
            "donutColor"    -> "hsl(122, 70%, 50%)"
          ),
          js.Dictionary(
            "country"       -> "DE",
            "hot dog"       -> "139",
            "hot dogColor"  -> "hsl(314, 70%, 50%)",
            "burger"        -> "200",
            "burgerColor"   -> "hsl(190, 70%, 50%)",
            "sandwich"      -> "71",
            "sandwichColor" -> "hsl(207, 70%, 50%)",
            "kebab"         -> "55",
            "kebabColor"    -> "hsl(40, 70%, 50%)",
            "fries"         -> "15",
            "friesColor"    -> "hsl(110, 70%, 50%)",
            "donut"         -> "169",
            "donutColor"    -> "hsl(149, 70%, 50%)"
          ),
          js.Dictionary(
            "country"       -> "UK",
            "hot dog"       -> "132",
            "hot dogColor"  -> "hsl(4, 70%, 50%)",
            "burger"        -> "45",
            "burgerColor"   -> "hsl(135, 70%, 50%)",
            "sandwich"      -> "103",
            "sandwichColor" -> "hsl(2, 70%, 50%)",
            "kebab"         -> "28",
            "kebabColor"    -> "hsl(152, 70%, 50%)",
            "fries"         -> "199",
            "friesColor"    -> "hsl(109, 70%, 50%)",
            "donut"         -> "138",
            "donutColor"    -> "hsl(44, 70%, 50%)"
          ),
          js.Dictionary(
            "country"       -> "US",
            "hot dog"       -> "132",
            "hot dogColor"  -> "hsl(4, 70%, 50%)",
            "burger"        -> "45",
            "burgerColor"   -> "hsl(135, 70%, 50%)",
            "sandwich"      -> "103",
            "sandwichColor" -> "hsl(2, 70%, 50%)",
            "kebab"         -> "28",
            "kebabColor"    -> "hsl(152, 70%, 50%)",
            "fries"         -> "199",
            "friesColor"    -> "hsl(109, 70%, 50%)",
            "donut"         -> "138",
            "donutColor"    -> "hsl(44, 70%, 50%)"
          )
        )
      )
    )
  }

  override val title = Some("Units Sold")
}