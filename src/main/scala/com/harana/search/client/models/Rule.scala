package com.harana.search.client.models

import io.circe.generic.extras.ConfiguredJsonCodec

@ConfiguredJsonCodec
case class Rule(id: String,
                sourceType: RuleSourceType,
                dateQualifier: Option[RuleDateQualifier],
                textQualifier: Option[RuleTextQualifier],
                qualifierValue: String,
                actionType: RuleActionType,
                actionValue: String)