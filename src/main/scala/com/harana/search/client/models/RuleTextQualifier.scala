package com.harana.search.client.models

import enumeratum._

sealed trait RuleTextQualifier extends EnumEntry
case object RuleTextQualifier extends Enum[RuleTextQualifier] with CirceEnum[RuleTextQualifier] {
  case object Contains extends RuleTextQualifier
  case object DoesNotContain extends RuleTextQualifier
  case object EndsWith extends RuleTextQualifier
  case object MatchesRegex extends RuleTextQualifier
  case object StartsWith extends RuleTextQualifier

  val values = findValues
}
