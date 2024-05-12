package com.harana.search.client.settings.developer

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.settings.developer.DeveloperStore.{UpdateDeveloperSource, UpdateDeveloperSources}
import com.harana.search.client.settings.folders.FoldersStore._
import com.harana.web.actions.Init
import diode.ActionResult.NoChange
import diode._

class DeveloperHandler extends ActionHandler(zoomTo(_.developerState)) {
  override def handle = {

    case Init(_) =>
      effectOnly(
        Tauri.list("list_developer_sources", list => UpdateDeveloperSources(list))
      )

    case UpdateDeveloperSources(sources) =>
      updated(value.copy(developerSources = sources))

    case UpdateDeveloperSource(source) =>
      Tauri.update("update_developer_source", Map("name" -> source.name, "enabled" -> source.enabled),
        effect => updated(value.copy(developerSources = value.developerSources.map(s => if (s.name == source.name) source else s)), effect)
      )

  }
}