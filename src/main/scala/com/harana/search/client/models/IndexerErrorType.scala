package com.harana.search.client.models

import enumeratum._

sealed trait IndexerErrorType extends EnumEntry
case object IndexerErrorType extends Enum[IndexerErrorType] with CirceEnum[IndexerErrorType] {
  case object NoDiskSpace extends IndexerErrorType
  val values = findValues
}
