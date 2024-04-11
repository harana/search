package com.harana.search.client.cards.general

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.web.html._

object RelationshipsCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]) =
    table(className := "ml-3 mt-1 divide-y divide-gray-300")(
      tbody(className := "divide-y divide-gray-200 bg-white")(
        user,
        user,
        user,
        user
      )
    )

  def user =
    tr(
      td(className := "whitespace-nowrap py-3 text-sm")(
        div(className := "flex items-center")(
          div(className := "h-11 w-11 flex-shrink-0")(
            img(className := "h-11 w-11 rounded-full", src := "https://images.unsplash.com/photo-1517841905240-472988babdf9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80"),
          ),
          div(className := "ml-4")(
            div(className := "font-medium text-gray-900")("Lindsay Walton"),
            div(className := "text-gray-500")("lindsay.walton@example.com")
          )
        )
      )
    )

  override def title = Some("Relationships")
}