package com.harana.search.client.auth

import diode.{Action => DiodeAction}

object AuthStore {

  case class State(loggedIn: Boolean)

  val initialState = State(false)

  case object HideSignup extends DiodeAction
}