package com.harana.search.client.cards.demo.customer

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.CustomAttribute
import slinky.core.facade.ReactElement
import slinky.web.html._

object DemoCustomerTimelineCard extends Card {

  val events = List(
    ("Signed up via Google Search", "1m", "system"),
    ("Placed order #4401 ($11455)", "3w", "order"),
    ("Dispatched to Springvale, VIC", "3w", "order-dispatch"),
    ("Placed order #4411 ($109)", "2h", "order"),
    ("Dispatched to Mulgrave, VIC", "1h", "order-dispatch"),
    ("Added phone for Klaviyo campaign", "30m", "campaign"),
    ("Support ticket raised #1101", "15m", "support")
  )

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement =
    ul(role := "list", className := "space-y-4 px-1 pt-3")(
      events.map(e => item(e._1, e._2, e._3))
    )

  def item(name: String, date: String, eventType: String) =
    li(className := "relative flex")(
      div(className := "absolute left-0 top-0 flex w-6 justify-center -bottom-6")(
        div(className := "w-px bg-gray-200")
      ),
      div(className := "relative flex h-6 w-6 flex-none items-center justify-center bg-white")(
        eventType match {
          case "system" =>
            div(className := s"h-1.5 w-1.5 rounded-full bg-gray-400 ring-1 ring-gray-500")

          case "order" =>
            div(className := s"h-1.5 w-1.5 rounded-full bg-emerald-400 ring-1 ring-green-500")

          case "order-dispatch" =>
            div(className := s"h-1.5 w-1.5 rounded-full bg-emerald-300 ring-1 ring-green-400")

          case "campaign" =>
            div(className := s"h-1.5 w-1.5 rounded-full bg-blue-400 ring-1 ring-blue-500")

          case "support" =>
            div(className := s"h-1.5 w-1.5 rounded-full bg-red-400 ring-1 ring-red-500")
        }
      ),
      p(className := "flex-auto py-0.5 text-xs leading-5 text-gray-500")(name),
      time(CustomAttribute[String]("dateTime") := "2023-01-23T10:32", className := "flex-none py-0.5 pr-1 text-xs leading-5 text-gray-500")(date)
    )


  override def title = Some("Interactions")
}