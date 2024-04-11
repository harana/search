package com.harana.search.client.cards.temp

import com.harana.web.external.nivo.Margin
import slinky.core.ExternalComponent
import slinky.core.annotations.react
import typings.react.mod.CSSProperties

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@JSImport("@nivo/geo", "ResponsiveChoropleth")
@js.native
object ReactChoropleth extends js.Object

@react object Choropleth extends ExternalComponent {

  case class Props(data: js.Array[Entry],
                   domain: js.Array[Int | Float],
                   colors: String | js.Array[String] = "nivo",
                   width: Int,
                   height: Int,
                   pixelRatio: js.UndefOr[Int] = js.undefined,
                   margin: js.UndefOr[Margin] = js.undefined,
                   label: String | js.Function0[String] = "id",
                   `match`: String | js.Function0[String] = "id",
                   role: String = "img",
                   value: String | js.Function0[String] = "value",
                   valueFormat: String = ".2",
                   projectionType: String = "mercator",
                   projectionScale: Int = 100,
                   projectionTranslation: js.Array[Double] = js.Array(0.5, 0.5),
                   projectionRotation: js.Array[Int] = js.Array(0, 0, 0),
                   theme: js.UndefOr[String] = js.undefined,
                   borderWidth: Int = 0,
                   borderColor: String | js.Object | js.Function0[String] = "#000000",
                   fillColor: String | js.Object | js.Function0[String] = "#dddddd",
                   defs: js.Array[Definition] = js.Array(),
                   fill: js.Array[Fill] = js.Array(),
                   features: js.Array[Feature] = js.Array(),
                   layers: js.Array[String] = js.Array("graticule", "features"),
                   legends: js.Array[js.Object] = js.Array(),
                   unknownColor: String = "#666666",
                   enableGraticule: Boolean = false,
                   graticuleLineWidth: Double = 0.5,
                   graticuleLineColor: String = "#999999",
                   isInteractive: Boolean = false,
                   tooltip: js.UndefOr[String] = js.undefined,
                   onMouseEnter: js.Function0[Unit] = () => {},
                   onMouseLeave: js.Function0[Unit] = () => {},
                   onMouseMove: js.Function0[Unit] = () => {},
                   onClick: js.Function0[Unit] = () => {})

  override val component = ReactChoropleth
}