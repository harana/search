package com.harana.search.client.models

import enumeratum._

sealed trait RuleActionType extends EnumEntry
case object RuleActionType extends Enum[RuleActionType] with CirceEnum[RuleActionType] {
  case object AddMetadata extends RuleActionType
  case object BoostLow  extends RuleActionType
  case object BoostHigh extends RuleActionType
  case object Exclude extends RuleActionType
  case object RemoveMetadata extends RuleActionType

  val values = findValues
}