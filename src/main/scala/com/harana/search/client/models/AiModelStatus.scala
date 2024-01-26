package com.harana.search.client.models

import enumeratum._

sealed trait AiModelStatus extends EnumEntry
case object AiModelStatus extends Enum[AiModelStatus] with CirceEnum[AiModelStatus] {
  case object InUse extends AiModelStatus
  case object NotYetDownloaded extends AiModelStatus
  case object Downloading extends AiModelStatus

  val values = findValues
}
