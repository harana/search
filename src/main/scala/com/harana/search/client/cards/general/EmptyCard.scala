package com.harana.search.client.cards.general

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

object EmptyCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement =
    div()
}