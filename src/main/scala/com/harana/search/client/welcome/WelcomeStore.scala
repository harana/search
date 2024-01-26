package com.harana.search.client.welcome

import com.harana.search.client.models.SearchFolder
import diode.{Action => DiodeAction}

import java.util.Timer

object WelcomeStore {

  case class State(searchFolders: List[SearchFolder],
                   searchFolderStatus: Map[String, Boolean],
                   selectedStep: Int,
                   statusTimer: Option[Timer],
                   windowShown: Boolean)

  val initialState = State(List(), Map(), 1, None, false)

  case object ShowWindow extends DiodeAction
  case object HideWindow extends DiodeAction
  case object RefreshStatus extends DiodeAction
  case object CompleteOnboarding extends DiodeAction

  case class UpdateSearchFolder(folder: SearchFolder) extends DiodeAction
  case class UpdateSearchFolders(folders: List[SearchFolder]) extends DiodeAction
  case class UpdateSearchFolderStatus(status: Map[String, Boolean]) extends DiodeAction
  case class UpdateSelectedStep(step: Int) extends DiodeAction
  case class UpdateStatusTimer(timer: Option[Timer]) extends DiodeAction
  case class UpdateWindowShown(shown: Boolean) extends DiodeAction

}