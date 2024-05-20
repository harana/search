package com.harana.search.client

import com.harana.search.client.main.MainStore.UpdateActivePanel
import com.harana.search.client.main.ui.{MainPanel, Panel}
import com.harana.search.client.system.SystemStore.WindowReady
import com.harana.web.actions.Init
import com.harana.web.external.tauri.Window
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.Hooks.useEffect

import java.util.concurrent.atomic.AtomicReference

@react
object Router {

  type Props = Unit

  private val didInit = new AtomicReference[Boolean](false)

  Tauri.listen("update-active-panel", (route: String) =>
    Circuit.dispatch(UpdateActivePanel(
      route match {
        case "search"   => Panel.Search
        case "share"    => Panel.Share
        case "settings" => Panel.Settings
        case "welcome"  => Panel.Welcome
      }
  )))

  val component = FunctionalComponent[Unit] { _ =>

    Circuit.diodeContext.Provider(Circuit) {

      useEffect(() => {
        if (!didInit.get) {
          Circuit.dispatch(Init(Map()))
          didInit.set(true)
          Circuit.dispatch(WindowReady)
        }
      })

      MainPanel()
    }
  }
}
