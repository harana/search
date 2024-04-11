package com.harana.search.client.cards.demo.marketing

import com.harana.search.client.cards.Card
import com.harana.search.client.cards.temp._
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js

object DemoMarketingFunnelCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement =
    div(className := "justify-center")(
      Funnel(
        width = 310,
        height = 280,
        valueFormat = ">-.4s",
        labelColor = new Color {
          override val from = "color"
          override val modifiers = js.Array(js.Array("darker", 3))
        },
        margin = new Margin {
          override val top = 20
          override val bottom = 10
          override val left = 20
          override val right = 20
        },
        data = js.Array(
          new FunnelEntry {
            override val id = "step_sent"
            override val value = 62837
            override val label = "Sent"
          },
          new FunnelEntry {
            override val id = "step_viewed"
            override val value = 44242
            override val label = "Viewed"
          },
          new FunnelEntry {
            override val id = "step_clicked"
            override val value = 28544
            override val label = "Clicked"
          },
          new FunnelEntry {
            override val id = "step_cart"
            override val value = 17544
            override val label = "Add To Cart"
          },
          new FunnelEntry {
            override val id = "step_purchased"
            override val value = 8944
            override val label = "Purchased"
          }
        )
      )
    )

  override val title = Some("July 2024")
}