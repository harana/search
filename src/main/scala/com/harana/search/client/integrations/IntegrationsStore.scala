package com.harana.search.client.integrations

import com.harana.search.client.models.Integration
import diode.{Action => DiodeAction}

object IntegrationsStore {

  case class State(integrations: List[Integration],
                   currentIntegrations: List[Integration],
                   favouriteIntegrations: List[Integration],
                   installedIntegrations: List[Integration],
                   popularIntegrations: List[Integration],
                   selectedCategory: Option[String])

  val initialState = State(List(), List(), List(), List(), List(), None)

  case class SelectCategory(category: String) extends DiodeAction
  case object SelectFavourites extends DiodeAction
  case object SelectInstalled extends DiodeAction
  case object SelectPopular extends DiodeAction

  case class UpdateIntegrations(integrations: List[Integration]) extends DiodeAction
  case class UpdateCurrentIntegrations(integrations: List[Integration]) extends DiodeAction
  case class UpdateFavouriteIntegrations(integrations: List[Integration]) extends DiodeAction
  case class UpdateInstalledIntegrations(integrations: List[Integration]) extends DiodeAction
  case class UpdatePopularIntegrations(integrations: List[Integration]) extends DiodeAction
  case class UpdateSelectedCategory(category: Option[String]) extends DiodeAction

}