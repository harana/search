package com.harana.search.client.auth

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.auth.AuthStore.HideSignup
import com.harana.web.actions.{Init, NoChange}
import diode._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

import scala.scalajs.js

class AuthHandler extends ActionHandler(zoomTo(_.authState)) {
  override def handle = {

    case Init(preferences) =>
      noChange

    case HideSignup =>
      effectOnly(
        Effect(
          Tauri.invoke("hide_signup").map((_: js.Any) => NoChange)
        )
      )
  }
}