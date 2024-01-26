package com.harana.search.client.models

import io.circe.generic.extras.ConfiguredJsonCodec

@ConfiguredJsonCodec
case class SearchCategory(title: String,
                          name: String,
                          enabled: Boolean,
                          position: Int)
