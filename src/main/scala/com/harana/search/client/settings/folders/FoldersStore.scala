package com.harana.search.client.settings.folders

import com.harana.search.client.models._
import diode.{Action => DiodeAction}

object FoldersStore {

  case class State(searchFolders: List[SearchFolder],
                   privateFolders: List[String])

  val initialState = State(List(), List())

  case class AddPrivateFolder(path: String) extends DiodeAction
  case class DeletePrivateFolder(path: String) extends DiodeAction

  case class UpdateSearchFolder(folder: SearchFolder) extends DiodeAction

  case class UpdatePrivateFolders(folders: List[String]) extends DiodeAction
  case class UpdateSearchFolders(folders: List[SearchFolder]) extends DiodeAction
}