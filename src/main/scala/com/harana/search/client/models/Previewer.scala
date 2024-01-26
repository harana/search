package com.harana.search.client.models

import enumeratum._

sealed trait Previewer extends EnumEntry
case object Previewer extends Enum[Previewer] with CirceEnum[Previewer] {
  case object BimViewer extends Previewer
  case object Certificate extends Previewer
  case object CodeViewer extends Previewer
  case object ComicViewer extends Previewer
  case object Cornerstone extends Previewer
  case object FontSampler extends Previewer
  case object HaranaHtml extends Previewer
  case object HaranaImage extends Previewer
  case object HaranaSvg extends Previewer
  case object HaranaText extends Previewer
  case object HaranaVideo extends Previewer
  case object JsonLens extends Previewer
  case object Leaflet extends Previewer
  case object ModelViewer extends Previewer
  case object Niivue extends Previewer
  case object Pdf extends Previewer
  case object SeqViz extends Previewer
  case object SheetJS extends Previewer
  val values = findValues
}