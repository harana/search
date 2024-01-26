package com.harana.search.client.preview

import com.harana.search.client.models.Document
import diode.{Action => DiodeAction}
import org.scalajs.dom.KeyboardEvent

object PreviewStore {

  case class State(document: Option[Document],
                   documentContent: Option[String],
                   documentUrl: Option[String],
                   viewer: Option[String])

  val initialState = State(None, None, None, None)

  case class KeyDown(key: Int, event: KeyboardEvent) extends DiodeAction
  case class KeyUp(key: Int, event: KeyboardEvent) extends DiodeAction

  case class LoadDocument(json: String) extends DiodeAction

  case class UpdateDocument(document: Option[Document]) extends DiodeAction
  case class UpdateDocumentContent(documentContent: Option[String]) extends DiodeAction
  case class UpdateDocumentUrl(documentUrl: Option[String]) extends DiodeAction
  case class UpdateViewer(viewer: Option[String]) extends DiodeAction

}