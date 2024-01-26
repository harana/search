package com.harana.search.client.settings.developer

import com.harana.search.client.models._
import diode.{Action => DiodeAction}

object DeveloperStore {

  case class State(developerSources: List[DeveloperSource])

  val initialState = State(List())

  case class UpdateDeveloperSources(sources: List[DeveloperSource]) extends DiodeAction
  case class UpdateDeveloperSource(source: DeveloperSource) extends DiodeAction

}