package com.harana.search.client.models

import enumeratum._

sealed trait IndexerProgress extends EnumEntry
case object IndexerProgress extends Enum[IndexerProgress] with CirceEnum[IndexerProgress] {
  case object NotYetStarted extends IndexerProgress
  case object InProgress extends IndexerProgress
  case object UpToDate extends IndexerProgress

  val values = findValues
}