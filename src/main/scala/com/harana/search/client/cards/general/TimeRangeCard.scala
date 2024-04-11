package com.harana.search.client.cards.general

import com.harana.search.client.cards.Card
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import com.harana.web.external.nivo.{CalendarEntry, TimeRange}
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js

object TimeRangeCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {
    div(className := "p-2 pt-8")(
      TimeRange(
        data = data,
        width = 285,
        height = 285,
        emptyColor = "#eeeeee",
        legends = js.undefined,
        weekdayTicks = List(),
        weekdayLegendOffset = 0
      )
    )
  }

  override val showBorder = true
  override val title = Some("Monthly Sales")

  val data = js.Array(
    new CalendarEntry {
      override val day = "2024-01-01"
      override val value = 5
    },
    new CalendarEntry {
      override val day = "2024-02-01"
      override val value = 8
    },
    new CalendarEntry {
      override val day = "2024-02-15"
      override val value = 2
    },
    new CalendarEntry {
      override val day = "2024-03-03"
      override val value = 6
    },
    new CalendarEntry {
      override val day = "2024-02-21"
      override val value = 4
    },
  )}