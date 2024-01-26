package com.harana.search.client.models

import enumeratum._

sealed trait RuleDateQualifier extends EnumEntry
case object RuleDateQualifier extends Enum[RuleDateQualifier] with CirceEnum[RuleDateQualifier] {
  case object GreaterThan extends RuleDateQualifier
  case object Is extends RuleDateQualifier
  case object LessThan extends RuleDateQualifier

  val values = findValues
}