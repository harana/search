package com.harana.search.client.models

import enumeratum._

sealed trait FontSize extends EnumEntry
case object FontSize extends Enum[FontSize] with CirceEnum[FontSize] {
  case object Dark extends FontSize
  case object Light extends FontSize
  case object System extends FontSize
  val values = findValues
}
