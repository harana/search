package com.harana.search.client.models

import com.harana.search.client.models.Integration.IntegrationId

case class Integration(id: IntegrationId,
                       title: String,
                       category: String,
                       description: String,
                       openUrl: String)

object Integration {
  type IntegrationId = String
}