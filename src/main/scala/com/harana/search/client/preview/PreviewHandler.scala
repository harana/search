package com.harana.search.client.preview

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.models.Document
import com.harana.search.client.preview.PreviewStore._
import com.harana.search.client.viewers.needsFullContent
import com.harana.search.client.search.ui.Keys
import com.harana.search.client.{Circuit, Tauri}
import com.harana.web.actions.{Init, NoChange}
import com.harana.web.external.html_to_image.Encoder.base64Bytes
import com.harana.web.external.html_to_image.HtmlToImage
import com.harana.web.external.tauri.Fs.readTextFile
import com.harana.web.external.tauri.Tauri.convertFileSrc
import com.harana.web.external.tauri.{Directory, FsOptions}
import diode.Effect.action
import diode._
import io.circe.parser.decode
import org.scalajs.dom
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

import scala.concurrent.Future
import scala.scalajs.js.typedarray.Uint8Array

class PreviewHandler extends ActionHandler(zoomTo(_.previewState)) {

  override def handle = {

    case Init(preferences) =>
      effectOnly {
//        Tauri.subscribe("preview_document_changed", (data: String) =>
//          Circuit.dispatch(LoadDocument(data))
//        )
        action(NoChange)
      }

    case KeyDown(key, event) =>
      effectOnly {
        event.stopPropagation()

        key match {
          case Keys.Space | Keys.Escape =>
            Effect(Tauri.invokeAsAction("hide_preview"))

          case Keys.Up =>
            Effect(Tauri.invokeAsAction("emit_search_message", Map("name" -> "select_previous_document", "payload" -> "")))

          case Keys.Down =>
            Effect(Tauri.invokeAsAction("emit_search_message", Map("name" -> "select_next_document", "payload" -> "")))

          case _ =>
            action(NoChange)
        }
      }

    case KeyUp(key, event) =>
      event.stopPropagation()

      noChange

    case LoadDocument(json) =>
      effectOnly(
        Effect {
          for {
            document      <- Future(decode[Document](json).toOption)
            viewer        <- Tauri.invoke[String]("get_viewer", Map("path" -> document.get.path.get))
            needsContent  =  needsFullContent(viewer)
            contents      <- if (needsContent) readTextFile(document.get.path.get, new FsOptions { val dir: Int = Directory.Home }).toFuture else Future("")
            action        =  ActionBatch(
                              UpdateDocumentUrl(Some(convertFileSrc(document.get.path.get))),
                              UpdateDocument(document),
                              UpdateDocumentContent(if (needsContent) Some(contents) else None),
                              UpdateViewer(Some(viewer))
                            )
          } yield action
        }
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