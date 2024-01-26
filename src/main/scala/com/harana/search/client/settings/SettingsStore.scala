package com.harana.search.client.settings

import diode.{Action => DiodeAction}

object SettingsStore {

  case class State(selectedSection: Section)

  val initialState = State(Section.Billing)

  case object HideSettings extends DiodeAction

  case class UpdateSelectedSection(section: Section) extends DiodeAction
}