package com.harana.search.client.cards.demo.customer

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.web.html._

object DemoCustomerLastOrderCard extends Card {

  val items = List(
    ("Side Table", "1499933374294-4584851497cc", "$2319.00"),
    ("Vase", "1508716897701-edab2a9e860c", "$89.40"),
    ("Bed", "1582582621959-48d27397dc69", "$1919.90"),
    ("Kitchen Table", "1638777927065-43a553d996a4", "$2319.00"),
    ("Sofa", "1567016432779-094069958ea5", "$5944.00"),
  )

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]) =
    table(className := "ml-4 mt-3 divide-y divide-gray-300")(
      tbody(className := "divide-y divide-gray-200 bg-white")(
        items.map(i => row(i._1, i._2, i._3))
      )
    )

  def row(title: String, image: String, price: String) =
    tr(
      td(className := "whitespace-nowrap pb-3 ml-1 text-sm")(
        div(className := "flex items-center")(
          div(className := "h-10 w-10 flex-shrink-0")(
            img(className := "h-10 w-10 rounded-full", src := s"https://images.unsplash.com/photo-$image?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=64&h=64&q=60"),
          ),
          div(className := "ml-4")(
            div(className := "font-medium text-gray-900")(title),
            div(className := "text-xs text-gray-500")(price)
          )
        )
      )
    )

  override def title = Some("Last Order")
}