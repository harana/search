package com.harana.search.client.cards.demo

import com.harana.search.client.cards.Card
import com.harana.search.client.cards.temp._
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js

object SankeyCard extends Card {

  def element(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {
    div(className := "justify-center")(
      Sankey(
        width = 310,
        height = 280,
        margin = new Margin {
          override val top = 15
          override val bottom = 10
          override val left = 20
          override val right = 30
        },
        data = new SankeyData {
          override val nodes = js.Array(
            new Node {
              override val id = "John"
              override val nodeColor = "hsl(238, 70%, 50%)"
            },
            new Node {
              override val id = "Raoul"
              override val nodeColor = "hsl(238, 70%, 50%)"
            },
            new Node {
              override val id = "Jane"
              override val nodeColor = "hsl(238, 70%, 50%)"
            },
            new Node {
              override val id = "Marcel"
              override val nodeColor = "hsl(238, 70%, 50%)"
            },
            new Node {
              override val id = "Ibrahim"
              override val nodeColor = "hsl(238, 70%, 50%)"
            },
            new Node {
              override val id = "Junko"
              override val nodeColor = "hsl(238, 70%, 50%)"
            }
          )

          override val links = js.Array(
            new Link {
              override val source = "Raoul"
              override val target = "Marcel"
              override val value = 199
            },
            new Link {
              override val source = "Ibrahim"
              override val target = "Jane"
              override val value = 90
            },
            new Link {
              override val source = "Ibrahim"
              override val target = "Junko"
              override val value = 34
            },
            new Link {
              override val source = "Ibrahim"
              override val target = "Marcel"
              override val value = 83
            },
            new Link {
              override val source = "Ibrahim"
              override val target = "John"
              override val value = 44
            },
            new Link {
              override val source = "Junko"
              override val target = "Jane"
              override val value = 185
            }
          )
        }
      )
    )
  }

  override val title = Some("Units Sold")
}