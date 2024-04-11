package com.harana.search.client.cards.temp

import slinky.core.ExternalComponent
import slinky.core.annotations.react

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@JSImport("@nivo/boxplot", "BoxPlot")
@js.native
object ReactBoxPlot extends js.Object

@react object BoxPlot extends ExternalComponent {

  case class Props(data: js.Array[js.Dictionary[String | Int | Double]],
                   width: Int,
                   height: Int,
                   groupBy: js.UndefOr[String] = js.undefined,
                   subGroupBy: js.UndefOr[String] = js.undefined,
                   indexBy: js.UndefOr[String] = js.undefined,
                   groupMode: js.UndefOr[String] = js.undefined,
                   layout: js.UndefOr[String] = js.undefined,
                   valueScale: js.UndefOr[js.Object] = js.undefined,
                   indexScale: js.UndefOr[js.Object] = js.undefined,
                   reverse: Boolean = false,
                   minValue: js.UndefOr[Int] = js.undefined,
                   maxValue: js.UndefOr[Int] = js.undefined,
                   valueFormat: js.UndefOr[String | js.Function1[Int, String] | Number] = js.undefined,
                   padding: js.UndefOr[Double] = js.undefined,
                   innerPadding: js.UndefOr[Double] = js.undefined,
                   pixelRatio: js.UndefOr[Int | String] = js.undefined,
                   margin: js.UndefOr[Margin] = js.undefined,
                   borderRadius: js.UndefOr[Int | Double] = js.undefined,
                   borderWidth: js.UndefOr[Int | Double] = js.undefined,
                   borderColor: js.UndefOr[Color] = js.undefined,
                   medianWidth: js.UndefOr[Int | Double] = js.undefined,
                   medianColor: js.UndefOr[Color] = js.undefined,
                   whiskerEndSize: js.UndefOr[Int | Double] = js.undefined,
                   whiskerWidth: js.UndefOr[Int | Double] = js.undefined,
                   whiskerColor: js.UndefOr[Color] = js.undefined,
                   motionConfig: js.UndefOr[String] = js.undefined,
                   fillColor: js.UndefOr[String | js.Object | js.Function0[String]] = js.undefined,
                   defs: js.Array[Definition] = js.Array(),
                   fill: js.Array[Fill] = js.Array())

  override val component = ReactBoxPlot
}