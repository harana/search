package com.harana.search.client.cards

import com.harana.search.client.cards.general._
import com.harana.search.client.models.Document
import com.harana.search.client.models.Integration.IntegrationId
import slinky.core.facade.ReactElement
import slinky.web.html.div

trait Card {
  def apply(document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement
}

object Card {

  def apply(name: Option[String], document: Document, integration: IntegrationId, thumbnail: Option[String]): ReactElement = {
    if (name.isEmpty) div()
    else
      Map(
        "audio_play"    -> AudioPlayCard(document, integration, thumbnail),
        "camera"        -> CameraCard(document, integration, thumbnail),
        "code"          -> CodeCard(document, integration, thumbnail),
        "data_schema"   -> DataSchemaCard(document, integration, thumbnail),
        "default"       -> DefaultCard(document, integration, thumbnail),
        "file"          -> FileCard(document, integration, thumbnail),
        "map"           -> MapCard(document, integration, thumbnail),
        "metadata"      -> MetadataCard(document, integration, thumbnail),
        "page"          -> PageCard(document, integration, thumbnail),
        "sample"        -> SampleCard(document, integration, thumbnail),
        "thumbnail"     -> ThumbnailCard(document, integration, thumbnail),
        "video_play"    -> VideoPlayCard(document, integration, thumbnail)
      )(name.get)
  }

}