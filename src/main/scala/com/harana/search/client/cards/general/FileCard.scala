package com.harana.search.client.cards.general

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import com.harana.web.components.when
import slinky.core.facade.ReactElement
import slinky.web.html._

object FileCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {
    div(className := s"flex-none card-top bg-gradient-to-r from-slate-500 to-gray-400")(
      when(document.accessed, div(className := "card-file-row")(div("Accessed"), div(document.accessed))),
      when(document.created, div(className := "card-file-row")(div("Created"), div(document.created))),
      when(document.modified, div(className := "card-file-row")(div("Modified"), div(document.modified))),
      when(document.size, div(className := "card-file-row")(div("Size"), div(document.size))),
      when(document.extensionTitle, div(className := "card-file-row")(div("Type"), div(document.extensionTitle)))
    )
  }
}