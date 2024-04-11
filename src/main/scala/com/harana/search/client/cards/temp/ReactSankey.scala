package com.harana.search.client.cards.temp

import slinky.core.ExternalComponent
import slinky.core.annotations.react

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@JSImport("@nivo/sankey", "Sankey")
@js.native
object ReactSankey extends js.Object

@react object Sankey extends ExternalComponent {

  case class Props(data: SankeyData,
                   width: Int,
                   height: Int,
                   align: js.UndefOr[String] = js.undefined,
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
                   borderWidth: js.UndefOr[Int] = js.undefined,
                   borderColor: js.UndefOr[String | js.Object | js.Function0[String]] = js.undefined,
                   fillColor: js.UndefOr[String | js.Object | js.Function0[String]] = js.undefined,
                   defs: js.Array[Definition] = js.Array(),
                   fill: js.Array[Fill] = js.Array())

  override val component = ReactSankey
}

trait SankeyData extends js.Object {
  val nodes: js.Array[Node]
  val links: js.Array[Link]
}

trait Node extends js.Object {
  val id: String
  val nodeColor: String
}

trait Link extends js.Object {
  val source: String
  val target: String
  val value: Int
}