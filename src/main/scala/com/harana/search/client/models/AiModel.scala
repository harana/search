package com.harana.search.client.models

import io.circe.generic.extras.{Configuration, ConfiguredJsonCodec}

@ConfiguredJsonCodec
case class AiModel(id: String,
                   status: AiModelStatus,
                   enabled: Boolean,
                   indexerType: String,
                   name: String,
                   version: String,
                   creationDate: String)
