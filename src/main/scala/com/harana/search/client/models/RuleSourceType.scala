package com.harana.search.client.models

import enumeratum._

sealed trait RuleSourceType extends EnumEntry
case object RuleSourceType extends Enum[RuleSourceType] with CirceEnum[RuleSourceType] {
  case object Category extends RuleSourceType
  case object Created extends RuleSourceType
  case object FileExtension extends RuleSourceType
  case object FileName extends RuleSourceType
  case object LastModified extends RuleSourceType
  case object SearchTag extends RuleSourceType
  case object TextContents extends RuleSourceType

  val values = findValues
}
