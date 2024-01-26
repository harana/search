package com.harana.search.client.models

import enumeratum._

sealed trait IndexerType extends EnumEntry
case object IndexerType extends Enum[IndexerType] with CirceEnum[IndexerType] {
  case object AudioTranscription extends IndexerType
  case object CoreIndexing extends IndexerType
  case object ObjectIdentification extends IndexerType
  case object PDFConversion extends IndexerType
  case object TextRecognition extends IndexerType
  case object TextSummarisation extends IndexerType
  case object VideoTranscription extends IndexerType

  val values = findValues
}
