package com.harana.search.client

import com.harana.web.external.router.{Route, Switch, Router => ReactRouter}
import com.harana.search.client.checkout.ui.CheckoutPanel
import com.harana.search.client.integrations.ui.IntegrationsPanel
import com.harana.search.client.login.ui.LoginPanel
import com.harana.search.client.main.ui.MainPanel
import com.harana.search.client.preview.ui.PreviewPanel
import com.harana.search.client.search.ui.SearchPanel
import com.harana.search.client.settings.ui.SettingsPanel
import com.harana.search.client.auth.ui.SignupPanel
import com.harana.search.client.support.ui.SupportPanel
import com.harana.search.client.thumbnail.ui.ThumbnailPanel
import com.harana.search.client.welcome.ui.WelcomePanel
import com.harana.web.actions.Init
import com.harana.web.base.Analytics
import com.harana.web.external.helmet.Helmet
import com.harana.web.external.ipynb_renderer.ReactIpynbRendererCSS
import slinky.core.annotations.react
import slinky.core.facade.Hooks.useEffect
import slinky.core.{CustomAttribute, FunctionalComponent}
import slinky.web.html._

import java.util.concurrent.atomic.AtomicReference

@react
object Router {

  type Props = Unit

  private val didInit = new AtomicReference[Boolean](false)
  private val browserHistory = new Analytics().history(false)

  val component = FunctionalComponent[Unit] { _ =>

    Circuit.diodeContext.Provider(Circuit) {

      useEffect(() => {
        if (!didInit.get) {
          Circuit.dispatch(Init(Map()))
          didInit.set(true)
        }
      })

      ReactRouter(history = browserHistory)(
        div(
          Helmet(
            meta(new CustomAttribute[String]("charSet") := "utf-8"),
            meta(name := "viewport", content := "width := device-width, initial-scale=1, shrink-to-fit=no"),
            meta(name := "theme-color", content := "#000000"),
            link(rel := "shortcut icon", href := "/favicon.ico"),
            style(`type` := "text/css")(ReactIpynbRendererCSS.toString),
          ),
          Switch(
            Route("/", MainPanel.component),
            Route("/auth/signup", SignupPanel.component),
            Route("/cart", CheckoutPanel.component),
            Route("/changelog", CheckoutPanel.component),
            Route("/integrations", IntegrationsPanel.component),
            Route("/login", LoginPanel.component),
            Route("/preview", PreviewPanel.component),
            Route("/settings", SettingsPanel.component),
            Route("/support", SupportPanel.component),
            Route("/thumbnail/:id", ThumbnailPanel.component),
            Route("/welcome", WelcomePanel.component),
            Route("*", SearchPanel.component)
          )
        )
      )
    }
  }
}
