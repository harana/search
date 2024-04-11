package com.harana.search.client.cards.temp

import com.harana.web.external.nivo.Margin
import slinky.core.ExternalComponent
import slinky.core.annotations.react
import typings.react.mod.CSSProperties

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@JSImport("@nivo/geo", "GeoMap")
@js.native
object ReactGeoMap extends js.Object

@react object GeoMap extends ExternalComponent {

  case class Props(width: js.UndefOr[Int] = js.undefined,
                   height: js.UndefOr[Int] = js.undefined,
                   pixelRatio: js.UndefOr[Int] = js.undefined,
                   margin: js.UndefOr[Margin] = js.undefined,
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

  override val component = ReactGeoMap
}