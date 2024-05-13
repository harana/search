package com.harana.search.client.welcome

import com.harana.search.client.models.SearchFolder
import diode.{Action => DiodeAction}

import java.util.Timer

object WelcomeStore {

  case class State(allowTelemetry: Boolean,
                   anonymousMode: Boolean,
                   overrideSpotlight: Boolean,
                   searchFolders: List[SearchFolder],
                   searchFolderStatus: Map[String, Boolean],
                   selectedStep: Int)

  val initialState = State(false, false, false, List(), Map(), 1)

  case object HideWindow extends DiodeAction
  case object CompleteOnboarding extends DiodeAction

  case class UpdateAllowTelemetry(allowTelemetry: Boolean) extends DiodeAction
  case class UpdateAnonymousMode(anonymousMode: Boolean) extends DiodeAction
  case class UpdateOverrideSpotlight(overrideSpotlight: Boolean) extends DiodeAction
  case class UpdateSearchFolder(folder: SearchFolder) extends DiodeAction
  case class UpdateSearchFolders(folders: List[SearchFolder]) extends DiodeAction
  case class UpdateSearchFolderStatus(status: Map[String, Boolean]) extends DiodeAction
  case class UpdateSelectedStep(step: Int) extends DiodeAction

}