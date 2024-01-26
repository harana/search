package com.harana.search.client.models

import com.harana.search.client.models.Document.DocumentId
import com.harana.search.client.models.Integration.IntegrationId
import io.circe.generic.extras.ConfiguredJsonCodec

import scala.scalajs.js

trait RawDocument extends js.Object {
  val id: DocumentId
  val title: String
  val description: String
  val author: String
  val primary_tokens: js.Set[String]
  val secondary_tokens: js.Set[String]
  val is_file: Boolean
  val created: String
  val modified: String
  val accessed: String
  val size: String
  val colour: String
  val path: String
  val extension: String
  val extension_title: String
  val parent_folder_name: String
  val parent_folder_path: String
  val metadata: String
  val cards: js.Array[String]
}

@ConfiguredJsonCodec
case class Document(id: DocumentId,
                    integrationId: IntegrationId,
                    title: String,
                    description: Option[String],
                    author: Option[String],
                    primaryTokens: Set[String],
                    secondaryTokens: Set[String],
                    isFile: Boolean,
                    created: Option[String],
                    modified: Option[String],
                    accessed: Option[String],
                    size: Option[String],
                    colour: Option[String],
                    path: Option[String],
                    extension: Option[String],
                    extensionTitle: Option[String],
                    parentFolderName: Option[String],
                    parentFolderPath: Option[String],
                    metadata: Option[String],
                    cards: List[String])

object Document {
  type DocumentId = String

  def apply(rd: RawDocument, integrationId: IntegrationId): Document = {
    Document(
      rd.id,
      integrationId,
      rd.title,
      Option(rd.description),
      Option(rd.author),
      rd.primary_tokens.toSet,
      rd.secondary_tokens.toSet,
      rd.is_file,
      Option(rd.created),
      Option(rd.modified),
      Option(rd.accessed),
      Option(rd.size),
      Option(rd.colour),
      Option(rd.path),
      Option(rd.extension),
      Option(rd.extension_title),
      Option(rd.parent_folder_name),
      Option(rd.parent_folder_path),
      Option(rd.metadata),
      rd.cards.toList
    )
  }
}