package com.harana.search.client.settings.ai

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.settings.ai.AiStore.{UpdateAiModel, UpdateAiModels}
import com.harana.web.actions.Init
import diode.ActionResult.NoChange
import diode._

class AiHandler extends ActionHandler(zoomTo(_.aiState)) {
  override def handle = {

    case Init(preferences) =>
      effectOnly(Tauri.list("list_ai_models", list => UpdateAiModels(list)))

    case UpdateAiModel(model) =>
      Tauri.update("update_ai_model", Map("id" -> model.id, "enabled" -> model.enabled),
        effect => updated(value.copy(aiModels = value.aiModels.map(m => if (m.id == model.id) model else m)), effect)
      )

    case UpdateAiModels(models) =>
      updated(value.copy(aiModels = models))
  }
}