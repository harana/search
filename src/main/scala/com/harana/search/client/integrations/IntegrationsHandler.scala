package com.harana.search.client.integrations

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.integrations.IntegrationsStore._
import com.harana.search.client.models.{Integration, Integrations}
import com.harana.web.actions.Init
import com.harana.web.external.tauri.Tauri.convertFileSrc
import com.harana.web.utils.http.Http
import diode._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

class IntegrationsHandler extends ActionHandler(zoomTo(_.integrationsState)) {
  override def handle = {

    case Init(preferences) =>
      effectOnly(
        Effect.action(UpdateIntegrations(Integrations.list.sortBy(_.title)))
      )

    case SelectCategory(category) =>
      updated(value.copy(currentIntegrations = value.integrations.filter(_.category == category)))

    case SelectFavourites =>
      updated(value.copy(currentIntegrations = value.favouriteIntegrations))

    case SelectInstalled =>
      updated(value.copy(currentIntegrations = value.favouriteIntegrations))

    case SelectPopular =>
      updated(value.copy(currentIntegrations = value.favouriteIntegrations))

    case UpdateIntegrations(integrations: List[Integration]) =>
      updated(value.copy(integrations = integrations))

    case UpdateCurrentIntegrations(integrations: List[Integration]) =>
      updated(value.copy(currentIntegrations = integrations))

    case UpdateFavouriteIntegrations(integrations: List[Integration]) =>
      updated(value.copy(favouriteIntegrations = integrations))

    case UpdateInstalledIntegrations(integrations: List[Integration]) =>
      updated(value.copy(installedIntegrations = integrations))

    case UpdatePopularIntegrations(integrations: List[Integration]) =>
      updated(value.copy(popularIntegrations = integrations))

    case UpdateSelectedCategory(category: Option[String]) =>
      updated(value.copy(selectedCategory = category))

  }
}