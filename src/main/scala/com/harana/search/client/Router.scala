package com.harana.search.client

import com.harana.js.reactRouterDom.mod.useHistory
import com.harana.search.client.Main.analytics
import com.harana.web.external.router.{BrowserRouter, Route, Switch, Router => ReactRouter}
import com.harana.search.client.checkout.ui.CheckoutPanel
import com.harana.search.client.integrations.ui.IntegrationsPanel
import com.harana.search.client.login.ui.LoginPanel
import com.harana.search.client.main.ui.{MainPanel, Panel}
import com.harana.search.client.preview.ui.PreviewPanel
import com.harana.search.client.settings.ui.SettingsPanel
import com.harana.search.client.auth.ui.SignupPanel
import com.harana.search.client.main.MainStore.UpdateActivePanel
import com.harana.search.client.support.ui.SupportPanel
import com.harana.search.client.system.SystemStore.WindowReady
import com.harana.search.client.thumbnail.ui.ThumbnailPanel
import com.harana.search.client.welcome.ui.WelcomePanel
import com.harana.web.actions.Init
import com.harana.web.external.helmet.Helmet
import com.harana.web.external.ipynb_renderer.ReactIpynbRendererCSS
import com.harana.web.external.tauri.Window
import slinky.core.annotations.react
import slinky.core.facade.Hooks.useEffect
import slinky.core.{CustomAttribute, FunctionalComponent}
import slinky.reactrouter.ReactRouterDOM.HashRouter
import slinky.web.html._
import typings.std.global.{history, window}

import java.util.concurrent.atomic.AtomicReference

@react
object Router {

  type Props = Unit

  private val didInit = new AtomicReference[Boolean](false)

  println("ROUTER LAUNCHED")
  Tauri.listen("push-route", (route: String) => {
    println("PUSH ROUTE >> " + route)
    route match {
      case "search"   => Circuit.dispatch(UpdateActivePanel(Panel.Search))
      case "share"    => Circuit.dispatch(UpdateActivePanel(Panel.Share))
      case "settings" => Circuit.dispatch(UpdateActivePanel(Panel.Settings))
      case "welcome"  => Circuit.dispatch(UpdateActivePanel(Panel.Welcome))
    }
  })

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
