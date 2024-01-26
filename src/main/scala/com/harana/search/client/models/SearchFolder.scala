package com.harana.search.client.models

import io.circe.generic.extras.ConfiguredJsonCodec

@ConfiguredJsonCodec
case class SearchFolder(title: String,
                        nameOrPath: String,
                        enabled: Boolean,
                        isPath: Boolean)
