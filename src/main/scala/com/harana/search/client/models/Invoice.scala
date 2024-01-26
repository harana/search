package com.harana.search.client.models

import io.circe.generic.extras.ConfiguredJsonCodec

@ConfiguredJsonCodec
case class Invoice(date: String, status: InvoiceStatus, downloadUrl: String)
