package com.harana.search.client.cards.demo

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import com.harana.web.external.tailwind.SolidIcons.{CheckCircleIcon, XCircleIcon}
import slinky.core.facade.ReactElement
import slinky.web.html._

object CheckListCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {

    ul(role := "list", className := "space-y-5 px-6 pt-6")(
      li(className := "flex gap-x-3")(checkIcon(true), "Item One"),
      li(className := "flex gap-x-3")(checkIcon(false), "Item Two"),
      li(className := "flex gap-x-3")(checkIcon(true), "Item Three"),
      li(className := "flex gap-x-3")(checkIcon(false), "Item Four"),
      li(className := "flex gap-x-3")(checkIcon(true), "Item Five"),
      li(className := "flex gap-x-3")(checkIcon(true), "Item Six")
    )
  }

  def checkIcon(checked: Boolean) =
    if (checked)
      CheckCircleIcon("text-green-700 h-6 w-6")
    else
      XCircleIcon("text-red-700 h-6 w-6")

  override def title = Some("Ranking")
}