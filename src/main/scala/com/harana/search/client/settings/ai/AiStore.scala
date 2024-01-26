package com.harana.search.client.settings.ai

import com.harana.search.client.models._
import diode.{Action => DiodeAction}

object AiStore {

  case class State(aiModels: List[AiModel])

  val initialState = State(List())

  case class UpdateAiModel(models: AiModel) extends DiodeAction
  case class UpdateAiModels(models: List[AiModel]) extends DiodeAction
}