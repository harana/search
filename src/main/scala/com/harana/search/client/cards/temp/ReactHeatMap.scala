package com.harana.search.client.cards.temp

import slinky.core.ExternalComponent
import slinky.core.annotations.react

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@JSImport("@nivo/heatmap", "HeatMap")
@js.native
object ReactHeatMap extends js.Object

@react object HeatMap extends ExternalComponent {

  case class Props(data: js.Array[HeatMapData],
                   width: Int,
                   height: Int,
                   pixelRatio: js.UndefOr[Int] = js.undefined,
                   margin: js.UndefOr[Margin] = js.undefined,
                   enableLabels: Boolean = false,
                   forceSquare: Boolean = false,
                   axisTop: js.UndefOr[HeatMapAxis] = js.undefined,
                   axisLeft: js.UndefOr[HeatMapAxis] = js.undefined,
                   axisRight: js.UndefOr[HeatMapAxis] = js.undefined,
                   axisBottom: js.UndefOr[HeatMapAxis] = js.undefined,
                   xOuterPadding: js.UndefOr[Int] = js.undefined,
                   xInnerPadding: js.UndefOr[Int] = js.undefined,
                   yOuterPadding: js.UndefOr[Int] = js.undefined,
                   yInnerPadding: js.UndefOr[Int] = js.undefined,
                   projectionType: js.UndefOr[String]= js.undefined,
                   projectionScale: js.UndefOr[Int] = js.undefined,
                   projectionRotation: js.UndefOr[List[Int]] = js.undefined,
                   theme: js.UndefOr[String] = js.undefined,
                   borderWidth: js.UndefOr[Int] = js.undefined,
                   borderColor: js.UndefOr[String | js.Object | js.Function0[String]] = js.undefined,
                   defs: js.UndefOr[js.Object] = js.undefined,
                   fill: js.UndefOr[js.Object] = js.undefined,
                   enableGraticule: js.UndefOr[Boolean] = js.undefined,
                   graticuleLineWidth: js.UndefOr[Float] = js.undefined,
                   graticuleLineColor: js.UndefOr[String] = js.undefined,
                   isInteractive: js.UndefOr[Boolean] = js.undefined)

  override val component = ReactHeatMap
}

trait HeatMapData extends js.Object {
  val id: String
  val data: js.Array[js.Dictionary[String | Int | Double]]
}

trait HeatMapAxis extends js.Object {
  val enable: js.UndefOr[Boolean] = js.undefined
  val tickSize: js.UndefOr[Int] = js.undefined
  val tickPadding: js.UndefOr[Int] = js.undefined
  val tickRotation: js.UndefOr[Int] = js.undefined
  val truncateTickAt: js.UndefOr[Int] = js.undefined
}