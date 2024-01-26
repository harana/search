package com.harana.search.client.settings.folders

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.settings.folders.FoldersStore._
import com.harana.web.actions.Init
import diode._

class FoldersHandler extends ActionHandler(zoomTo(_.foldersState)) {
  override def handle = {

    case Init(_) =>
      effectOnly(
        Tauri.list("list_private_folders", list => UpdatePrivateFolders(list)) +
        Tauri.list("list_search_folders", list => UpdateSearchFolders(list))
      )

    case AddPrivateFolder(path) =>
      Tauri.update("add_private_folder", Map("path" -> path),
        effect => updated(value.copy(privateFolders = value.privateFolders :+ path), effect)
      )

    case DeletePrivateFolder(path) =>
      Tauri.update("delete_private_folder", Map("path" -> path),
        effect => updated(value.copy(privateFolders = value.privateFolders.diff(List(path))), effect)
      )

    case UpdatePrivateFolders(folders) =>
      updated(value.copy(privateFolders = folders))

    case UpdateSearchFolder(folder) =>
      Tauri.update("update_search_folder", Map("nameOrPath" -> folder.nameOrPath, "isPath" -> folder.isPath, "enabled" -> folder.enabled),
        effect => updated(value.copy(searchFolders = value.searchFolders.map(f => if (f.nameOrPath == folder.nameOrPath) folder else f)), effect)
      )

    case UpdateSearchFolders(folders) =>
      updated(value.copy(searchFolders = folders))

  }
}