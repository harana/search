package com.harana.search.client.cards.orders

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import com.harana.web.components
import com.harana.web.components.literal
import slinky.core.facade.ReactElement
import slinky.web.html._

object ProductCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement =
    div(className := "relative w-full overflow-x-auto p-4")(
      ul(role := "list", className := "mx-4 inline-flex space-x-8 :grid lg:grid-cols-4 lg:gap-x-8 lg:space-x-0")(
        li(className := "inline-flex w-64 flex-col text-center lg:w-auto")(
          div(className := "group relative")(
            div(className := "aspect-h-1 aspect-w-1 w-full overflow-hidden rounded-md bg-gray-200")(
              img(src := "https://tailwindui.com/img/ecommerce-images/home-page-02-product-01.jpg", className := "h-full w-full object-cover object-center group-hover:opacity-75"),
              div(className := "mt-6")(
                p(className := "text-sm text-gray-500")("Black"),
                h3(className := "mt-1 font-semibold text-gray-900")("Machined Pen"),
                p(className := "mt-1 text-gray-900")("$35")
              )
            ),
            h4(className := "sr-only")("Available colors"),
            ul(role := "list", className := "mt-auto flex items-center justify-center space-x-3 pt-6")(
              li(className := "h-4 w-4 rounded-full border border-black border-opacity-10", style := literal("background-color" -> "#111827"))(
                span(className := "sr-only")("Black")
              ),
              li(className := "h-4 w-4 rounded-full border border-black border-opacity-10", style := literal("background-color" -> "#fde68a"))(
                span(className := "sr-only")("Brass")
              ),
              li(className := "h-4 w-4 rounded-full border border-black border-opacity-10", style := literal("background-color" -> "#e5e7eb"))(
                span(className := "sr-only")("Chrome")
              )
            )
          )
        )
      )
    )

  override val title = Some("Product")
}