package com.harana.search.client.cards.demo

import com.harana.search.client.cards.Card
import com.harana.search.client.cards.temp.{HeatMap, HeatMapAxis, HeatMapData, Margin}
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js

object HeatMapCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement =
    div(className := "justify-center")(
      HeatMap(
        width = 280,
        height = 280,
        axisLeft = new HeatMapAxis { override val tickRotation = 45 },
        axisTop = new HeatMapAxis { override val tickRotation = 45 },
        data = js.Array[HeatMapData](
          new HeatMapData {
            override val id = "Japan"
            override val data = js.Array(
              js.Dictionary("x" -> "Train", "y" -> -73218),
              js.Dictionary("x" -> "Subway", "y" -> -32525),
              js.Dictionary("x" -> "Bus", "y" -> -70544),
              js.Dictionary("x" -> "Car", "y" -> 69110),
              js.Dictionary("x" -> "Boat", "y" -> -55772),
              js.Dictionary("x" -> "Moto", "y" -> -43461),
              js.Dictionary("x" -> "Moped", "y" -> -65307),
              js.Dictionary("x" -> "Bicycle", "y" -> -70354),
              js.Dictionary("x" -> "Others", "y" -> 15826)
            )
          },
          new HeatMapData {
            override val id = "France"
            override val data = js.Array(
              js.Dictionary("x" -> "Train", "y" -> 65000),
              js.Dictionary("x" -> "Subway", "y" -> -80712),
              js.Dictionary("x" -> "Bus", "y" -> -83461),
              js.Dictionary("x" -> "Car", "y" -> -69045),
              js.Dictionary("x" -> "Boat", "y" -> -54732),
              js.Dictionary("x" -> "Moto", "y" -> 41034),
              js.Dictionary("x" -> "Moped", "y" -> 31399),
              js.Dictionary("x" -> "Bicycle", "y" -> -55733),
              js.Dictionary("x" -> "Others", "y" -> -62144)
            )
          },
          new HeatMapData {
            override val id = "US"
            override val data = js.Array(
              js.Dictionary("x" -> "Train", "y" -> 41268),
              js.Dictionary("x" -> "Subway", "y" -> 14747),
              js.Dictionary("x" -> "Bus", "y" -> 95909),
              js.Dictionary("x" -> "Car", "y" -> 80138),
              js.Dictionary("x" -> "Boat", "y" -> 16676),
              js.Dictionary("x" -> "Moto", "y" -> -6383),
              js.Dictionary("x" -> "Moped", "y" -> -12691),
              js.Dictionary("x" -> "Bicycle", "y" -> -29690),
              js.Dictionary("x" -> "Others", "y" -> -8438)
            )
          },
          new HeatMapData {
            override val id = "Germany"
            override val data = js.Array(
              js.Dictionary("x" -> "Train", "y" -> 47364),
              js.Dictionary("x" -> "Subway", "y" -> -63760),
              js.Dictionary("x" -> "Bus", "y" -> 86179),
              js.Dictionary("x" -> "Car", "y" -> 2120),
              js.Dictionary("x" -> "Boat", "y" -> -97163),
              js.Dictionary("x" -> "Moto", "y" -> 10573),
              js.Dictionary("x" -> "Moped", "y" -> 98558),
              js.Dictionary("x" -> "Bicycle", "y" -> -51947),
              js.Dictionary("x" -> "Others", "y" -> -63190),
            )
          },
          new HeatMapData {
            override val id = "Norway"
            override val data = js.Array(
              js.Dictionary("x" -> "Train", "y" -> -68368),
              js.Dictionary("x" -> "Subway", "y" -> -1440),
              js.Dictionary("x" -> "Bus", "y" -> 42264),
              js.Dictionary("x" -> "Car", "y" -> -71908),
              js.Dictionary("x" -> "Boat", "y" -> 28203),
              js.Dictionary("x" -> "Moto", "y" -> -76562),
              js.Dictionary("x" -> "Moped", "y" -> 59152),
              js.Dictionary("x" -> "Bicycle", "y" -> -51743),
              js.Dictionary("x" -> "Others", "y" -> -16251),
            )
          }
        ),
        margin = new Margin {
          override val top = 60
          override val bottom = 10
          override val left = 50
          override val right = 0
        }
      )
    )

  override val title = Some("Units Sold")
}