package com.harana.search.client.models

import enumeratum.{CirceEnum, Enum, EnumEntry}

sealed trait Theme extends EnumEntry
case object Theme extends Enum[Theme] with CirceEnum[Theme] {
  case object System extends Theme
  case object Dark extends Theme
  case object Light extends Theme
  val values = findValues
}