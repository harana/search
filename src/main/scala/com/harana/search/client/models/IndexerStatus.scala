package com.harana.search.client.models

import io.circe.generic.extras.ConfiguredJsonCodec

@ConfiguredJsonCodec
case class IndexerStatus(indexerType: IndexerType,
                         indexerProgress: IndexerProgress,
                         fileCount: Int)
