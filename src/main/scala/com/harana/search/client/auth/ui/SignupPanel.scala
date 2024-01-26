package com.harana.search.client.auth.ui

import com.harana.search.client.Circuit
import com.harana.search.client.auth.AuthStore.HideSignup
import com.harana.web.external.tailwind.OutlineIcons._
import com.harana.web.external.tailwind.{Button, ButtonSize}
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

import scala.scalajs.js.Dynamic.{literal => css}

@react object SignupPanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val upgradeItems = List(
      ("integrations", "300+ Integrations", "Description about integrations", PhotoOutlineIcon("absolute left-1 top-1 h-5 w-5 text-indigo-600")),
      ("indexing", "AI Enhanced Indexing", "Description about categories", ListBulletOutlineIcon("absolute left-1 top-1 h-5 w-5 text-indigo-600")),
      ("search", "Customisable Search", "Description about folders", FolderOpenOutlineIcon("absolute left-1 top-1 h-5 w-5 text-indigo-600")),
    )

    div(className := "overflow-hidden bg-white")(
      div()(
        a(onClick := (_ => Circuit.dispatch(HideSignup)))(XMarkOutlineIcon(className = "h-6 w-6 text-gray-400 right"))
      ),
      div(className := "relative isolate px-8 pt-20")(
        div(className := "absolute inset-x-0 -top-40 -z-10 transform-gpu overflow-hidden blur-3xl sm:-top-80")(
          div(className := "relative left-[calc(50%-11rem)] aspect-[1155/678] w-[36.125rem] -translate-x-1/2 rotate-[30deg] bg-gradient-to-tr from-[#ff80b5] to-[#9089fc] opacity-30 sm:left-[calc(50%-30rem)] sm:w-[72.1875rem]",
            style := css("clipPath" -> "polygon(74.1% 44.1%, 100% 61.6%, 97.5% 26.9%, 85.5% 0.1%, 80.7% 2%, 72.5% 32.5%, 60.2% 62.4%, 52.4% 68.1%, 47.5% 58.3%, 45.2% 34.5%, 27.5% 76.7%, 0.1% 64.9%, 17.9% 100%, 27.6% 76.8%, 76.1% 97.7%, 74.1% 44.1%)")
          )
        )
      ),
      div(className := "mx-auto max-w-7xl px-6 lg:px-8")(
        div(className := "mx-auto grid max-w-2xl grid-cols-1 gap-x-8 gap-y-16 sm:gap-y-20 lg:mx-0 lg:max-w-none lg:grid-cols-2")(
          div(className := "lg:pr-8 lg:pt-4")(
            div(className := "lg:max-w-lg")(
              h2(className := "text-base font-semibold leading-7 text-indigo-600")("harana+"),
              p(className := "mt-2 text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl")("A better search"),
              p(className := "mt-6 text-lg leading-8 text-gray-600")("Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maiores impedit perferendis suscipit eaque, iste dolor cupiditate blanditiis ratione."),
              dl(className := "mt-10 max-w-xl space-y-8 text-base leading-7 text-gray-600 lg:max-w-none")(
                upgradeItems.map { item =>
                  div(key := item._1, className := "relative pl-9")(
                    dt(className := "inline font-semibold text-gray-900")(
                      item._4, item._2
                    ),
                    br(),
                    dd(className := "inline")(item._3)
                  )
                }
              )
            ),
            div(className := "pt-12 center")(
              Button(
                label = Some("Upgrade now"),
                size = ButtonSize.Large,
                textColor = "white",
                backgroundColor = "indigo-600",
                hoverColor = "indigo-500",
                rounded = true,
                onClick = () => ()
              )
            )
          )
        )
      )
    )
  }
}
