package com.harana.search.client.models

import io.circe.generic.extras.ConfiguredJsonCodec

@ConfiguredJsonCodec
case class DeveloperSource(title: String,
                           name: String,
                           language: String,
                           enabled: Boolean)