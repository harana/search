package com.harana.search.client.share

import diode.{Action => DiodeAction}
import org.scalajs.dom.KeyboardEvent

object ShareStore {

  case class State()

  val initialState = State()

  case class KeyDown(key: Int, event: KeyboardEvent) extends DiodeAction
  case class KeyUp(key: Int, event: KeyboardEvent) extends DiodeAction

  case object Cancel extends DiodeAction
  case object Share extends DiodeAction
}