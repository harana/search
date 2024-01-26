package com.harana.search.client.settings.rules

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.models.{Rule, RuleActionType, RuleSourceType}
import com.harana.search.client.settings.ai.AiStore.UpdateAiModels
import com.harana.search.client.settings.rules.RulesStore._
import com.harana.web.actions.Init
import diode.ActionResult.NoChange
import diode._
import io.circe.parser.decode
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

class RulesHandler extends ActionHandler(zoomTo(_.rulesState)) {
  override def handle = {

    case Init(_) =>
      effectOnly(Tauri.list("list_rules", list => UpdateRules(list)))

    case AddRule =>
      updated(value.copy(rules = value.rules :+ Rule(
        "",
        RuleSourceType.FileName,
        None,
        None,
        "",
        RuleActionType.AddMetadata,
        ""
      )))

    case DeleteRule(rule) =>
      updated(value.copy(rules = value.rules.diff(List(rule))))

    case UpdateRules(rules) =>
      updated(value.copy(rules = rules))

  }
}