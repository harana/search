package com.harana.search.client.main

import com.harana.search.client.main.ui.Panel
import diode.{Action => DiodeAction}
import org.scalajs.dom.KeyboardEvent

object MainStore {

  case class State(activePanel: Panel)

  val initialState = State(Panel.Search)

  case class KeyDown(key: Int, event: KeyboardEvent) extends DiodeAction
  case class KeyUp(key: Int, event: KeyboardEvent) extends DiodeAction

  case class UpdateActivePanel(panel: Panel) extends DiodeAction
}