package com.harana.search.client.thumbnail

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.models.{Document, RawDocument}
import com.harana.search.client.thumbnail.ThumbnailStore._
import com.harana.search.client.viewers.needsFullContent
import com.harana.web.actions.{Init, NoChange}
import com.harana.web.external.html_to_image.Encoder.base64Bytes
import com.harana.web.external.html_to_image.HtmlToImage
import com.harana.web.external.tauri.Fs.readTextFile
import com.harana.web.external.tauri.Tauri.convertFileSrc
import com.harana.web.external.tauri.{Directory, FsOptions}
import diode.Effect.action
import diode._
import org.scalajs.dom
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.typedarray.Uint8Array

class ThumbnailHandler extends ActionHandler(zoomTo(_.thumbnailState)) {

  override def handle = {

    case Init(preferences) =>
      noChange

    case LoadDocument(documentId) =>
      effectOnly(
        Effect {
          for {
            (document, thumbnailer)   <- Tauri.invoke[js.Tuple2[RawDocument, String]]("get_document", Map("documentId" -> documentId)).map { results =>
                                          (Document(results._1, ""), results._2)
                                         }
            needsContent              =  needsFullContent(thumbnailer)
            contents                  <- if (needsContent) readTextFile(document.path.get, new FsOptions { val dir: Int = Directory.Home }).toFuture else Future("")
            action                    =  ActionBatch(
                                          UpdateDocumentUrl(Some(convertFileSrc(document.path.get))),
                                          UpdateDocument(Some(document)),
                                          UpdateDocumentContent(if (needsContent) Some(contents) else None),
                                          UpdateViewer(Some(thumbnailer))
                                        )
          } yield action
        } >> action(SaveThumbnail(value.document.get.id))
      )

    case SaveThumbnail(documentId) =>
      effectOnly(
        Effect(
          for {
            blob        <- HtmlToImage.toBlob(dom.document.getElementById("root")).toFuture
            buffer      <- blob.arrayBuffer().toFuture
            base64      =  base64Bytes(new Uint8Array(buffer))
            documentId  =  value.document.get.id
            _           <- Tauri.invoke[String]("save_thumbnail", Map("data" -> base64, "documentId" -> documentId))
          } yield NoChange
        )
      )

    case UpdateDocument(document) =>
      updated(value.copy(document = document))

    case UpdateDocumentContent(content) =>
      updated(value.copy(documentContent = content))

    case UpdateDocumentUrl(url) =>
      updated(value.copy(documentUrl = url))

    case UpdateViewer(viewer) =>
      updated(value.copy(viewer = viewer))
  }
}