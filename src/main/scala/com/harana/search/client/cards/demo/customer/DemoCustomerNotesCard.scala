package com.harana.search.client.cards.demo.customer

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

object DemoCustomerNotesCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement =
    div(className := "space-y-8 xl:contents xl:space-y-0")(
      div(className := "space-y-8 xl:row-span-2")(
        figure(className := "p-6")(
          blockquote(className := "text-gray-900")(
            p("“I'm disappointed to find a noticeable scratch on my new dining table and wobbly chairs due to uneven legs."),
            p(className := "pt-2")("I request guidance on receiving a replacement or an entire set exchange to rectify these issues promptly.”")
          ),
          figcaption(className := "mt-8 flex items-center gap-x-4")(
            img(className := "h-10 w-10 rounded-full bg-gray-50", src := "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80"),
            div(
              div(className := "font-semibold")("Aurelia Smith"),
              div(className := "text-gray-600")("@aurelia")
            )
          )
        )
      )
    )

  override def title = Some("Latest Notes")
}