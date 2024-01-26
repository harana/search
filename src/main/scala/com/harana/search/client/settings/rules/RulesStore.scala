package com.harana.search.client.settings.rules

import com.harana.search.client.models._
import diode.{Action => DiodeAction}

object RulesStore {

  case class State(rules: List[Rule])

  val initialState = State(List())

  case object AddRule extends DiodeAction
  case class DeleteRule(rule: Rule) extends DiodeAction
  case class UpdateRules(rules: List[Rule]) extends DiodeAction
}