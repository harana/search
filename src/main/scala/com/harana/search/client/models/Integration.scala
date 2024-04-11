package com.harana.search.client.models

import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html.span

case class Integration(id: IntegrationId,
                       title: String,
                       icon: ReactElement = span(),
                       category: String,
                       description: Option[String] = None,
                       openUrl: Option[String] = None)

object Integration {
  type IntegrationId = String
}