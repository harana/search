package com.harana.search.client.search

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Main.analytics
import com.harana.search.client.cards.CardStore.UpdateCards
import com.harana.search.client.main.MainStore.UpdateActivePanel
import com.harana.search.client.main.ui.Panel
import com.harana.search.client.models.Document.DocumentId
import com.harana.search.client.models.{Application, Document, Integrations, RawApplication, RawDocument}
import com.harana.search.client.search.SearchStore._
import com.harana.search.client.search.ui.{SearchColumn, SearchPanel}
import com.harana.search.client.{Circuit, Tauri}
import com.harana.web.actions._
import diode.Effect.action
import diode._
import io.circe.syntax._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global
import typings.std.global.{console, window}

import scala.concurrent.Future
import scala.scalajs.js

class SearchHandler extends ActionHandler(zoomTo(_.searchState)) {

  def document(id: DocumentId): Document = {
    val documents = value.searchResults.find(_._1 == value.selectedIntegration.get).get._2
    documents.find(_.id == id).get
  }

  override def handle = {

    case NoChange =>
      noChange

    case Init(preferences) =>
      noChange

    //        Tauri.subscribe("select_previous_document", (_: String) => Circuit.dispatch(SelectPreviousDocument))
    //        Tauri.subscribe("select_next_document", (_: String) => Circuit.dispatch(SelectNextDocument))

    case LoadIntegrations =>
      noChange

    case UpdateSelectedIntegration(integrationId) =>
      updated(value.copy(errorMessage = None, selectedIntegration = integrationId))

    case Search(term) =>
      if (term.isEmpty)
        effectOnly(
          action(
            ActionBatch(
              UpdateSearchApplication(None),
              UpdateSearchResults(List.empty),
              UpdateSearchTerm(None),
              UpdateSelectedDocument(None),
              UpdateSelectedIntegration(None)
            )
          )
        )
      else {
        effectOnly(
          Effect(
            Tauri.invoke("search", Map("query" -> term.get)).map { (jsResults: js.Dictionary[js.Array[RawDocument]]) => {
              analytics.pushEvent("search")
              val results = jsResults.toMap.view
                .map(pair => (pair._1, pair._2.toList.sortBy(_.title.toLowerCase).map(rd => Document(rd, pair._1))))
                .toList
                .sortBy(pair => Integrations.get(pair._1).title.toLowerCase)
              UpdateSearchResults(results)
            }}
          ) +
            Effect(
              Tauri.invoke("search_application", Map("query" -> term.get)).map { (result: js.UndefOr[RawApplication]) => {
                UpdateSearchApplication(result.toOption.map(Application.apply))
              }}
            ) +
            action(
              ActionBatch(
                UpdateSearchTerm(term),
                UpdateSelectedDocument(None),
                UpdateSelectedIntegration(None)
              )
            )
        )
      }

    case Hide =>
      effectOnly(
        Effect(
          Tauri.invoke[Unit]("hide_search").map(_ => NoChange)
        )
      )

    case Open =>
      effectOnly(
        Effect(
          Tauri.invokeAsAction("open_path",
            Map("path" -> document(value.selectedDocumentId.get).path.get),
            onSuccess = (_: Any) => UpdateErrorMessage(None),
            onFailure = (result: scala.Any) => UpdateErrorMessage(Some(result.toString))
          )
        )
      )

    case OpenApplication =>
      effectOnly(
        Effect(
          Tauri.invokeAsAction("open_application",
            Map("path" -> value.searchApplication.get.path),
            onSuccess = (_: Any) => {
              analytics.pushEvent("open_application")
              ActionBatch(
                UpdateErrorMessage(None),
                UpdateSearchApplication(None),
                UpdateSearchTerm(None)
              )
            },
            onFailure = (result: scala.Any) => UpdateErrorMessage(Some(result.toString))
          )
        )
      )

    case OpenParentFolder =>
      Tauri.invoke("open_path", Map("path" -> document(value.selectedDocumentId.get).parentFolderPath.get))
      noChange

    case Share =>
      effectOnly(action(UpdateActivePanel(Panel.Share)))

    case SelectIntegration(integrationId) =>
      effectOnly(
        if (value.selectedIntegration.isEmpty || value.selectedIntegration.get != integrationId)
          action(
            ActionBatch(
              ScrollToIntegration(integrationId),
              UpdateFocusedPanel(SearchColumn.Integration),
              UpdateSelectedDocument(None),
              UpdateSelectedIntegration(Some(integrationId)),
            )
          ) >> action(ScrollToFirstDocument)
        else
          action(UpdateFocusedPanel(SearchColumn.Integration))
      )

    case SelectPreviousDocument =>
      val documents = value.searchResults.find(_._1 == value.selectedIntegration.get).get._2
      val documentIds = documents.map(_.id)

      effectOnly(
        if (value.selectedDocumentId.get != documentIds.head) {
          val old_index = documentIds.indexOf(value.selectedDocumentId.get)
          action(SelectDocument(documentIds(old_index - 1), true))
        } else
          action(NoChange)
      )

    case SelectNextDocument =>
      val documents = value.searchResults.find(_._1 == value.selectedIntegration.get).get._2
      val documentIds = documents.map(_.id)

      effectOnly(
        if (value.selectedDocumentId.get != documentIds.last) {
          val old_index = documentIds.indexOf(value.selectedDocumentId.get)
          val next_document = documentIds(old_index + 1)
          action(SelectDocument(next_document, true))
        } else
          action(NoChange)
      )

    case SelectDocument(documentId, scroll) =>
      val doc = document(documentId)
      effectOnly(
        if (value.selectedDocumentId.isEmpty || value.selectedDocumentId.get != documentId)
          Effect(
            Tauri.invoke[Unit]("emit_preview_message", Map("name" -> "preview_document_changed", "payload" -> doc.asJson.noSpaces)).map(_ => NoChange)
          ) + (if (doc.path.isDefined) Effect(Tauri.invoke[String]("get_viewer", Map("path" -> doc.path.get)).map(viewer => UpdateAllowPreview(viewer != "Noop"))) else Effect.action(NoChange)) +
            action(
              ActionBatch(
                LoadThumbnail(documentId),
                UpdateCards(doc.cards.map(c => List(c))),
                UpdateFocusedPanel(SearchColumn.Document),
                UpdateSelectedDocument(Some(documentId)),
                if (scroll) ScrollToDocument(documentId) else NoChange
              )
            )
        else
          action(UpdateFocusedPanel(SearchColumn.Document))
      )

    case LoadThumbnail(documentId) =>
      effectOnly(
        Effect(
          for {
            exists        <- Tauri.invoke[String]("has_thumbnail", Map("documentId" -> documentId))
            url           =  s"${zoomTo(_.systemState).value.thumbnailsUrl}/$documentId.png"
            thumbnails    =  value.loadedThumbnails + (documentId -> url)
            action        =  if (exists.toBoolean) UpdateLoadedThumbnails(thumbnails) else NoChange
          } yield action
        )
      )

    case ShowPreview(document) =>
      effectOnly(
        Effect(
          Tauri.invoke[Unit]("show_preview", Map("document" -> document.asJson.noSpaces)).map(_ => NoChange)
        )
      )

    case RefreshFocusedPanel =>
      effectOnly(action(UpdateFocusedPanel(value.focusedPanel)))

    case SearchFocused =>
      effectOnly(action(
        ActionBatch(
          UpdateSelectedIntegration(None),
          UpdateSelectedDocument(None),
          UpdateFocusedPanel(SearchColumn.Search)
        )
      ))

    case UpdateAllowPreview(preview) =>
      updated(value.copy(allowPreview = preview))

    case UpdateAllowShare(share) =>
      updated(value.copy(allowShare = share))

    case UpdateErrorMessage(message) =>
      updated(value.copy(errorMessage = message))

    case UpdateIntegrations(integrations) =>
      updated(value.copy(integrations = integrations))

    case UpdateFocusedPanel(panel) =>
      if (value.focusedPanel == panel)
        noChange
      else {
        if (SearchPanel.inputRef.current != null) {
          if (panel == SearchColumn.Search)
            SearchPanel.inputRef.current.focus()
          else
            SearchPanel.inputRef.current.blur()
        }
        updated(value.copy(errorMessage = None, focusedPanel = panel))
      }

    case UpdateLoadedThumbnails(thumbnails) =>
      updated(value.copy(loadedThumbnails = thumbnails))

    case UpdateSearchApplication(application) =>
      updated(value.copy(searchApplication = application))

    case UpdateSearchResults(results) =>
      updated(value.copy(searchResults = results))

    case UpdateSearchTerm(term) =>
      SearchPanel.inputRef.current.value = term.getOrElse("")
      updated(value.copy(errorMessage = None, searchTerm = term))

    case UpdateSelectedCardHorizontal(index) =>
      updated(value.copy(selectedCardHorizontal = index))

    case UpdateSelectedCardVertical(index) =>
      updated(value.copy(selectedCardVertical = index))

    case UpdateSelectedDocument(documentId) =>
      if (documentId.isEmpty)
        updated(
          value.copy(
            errorMessage = None,
            selectedDocumentId = None,
            selectedDocument = None
          )
        )
      else
        updated(
          value.copy(
            errorMessage = None,
            selectedDocumentId = documentId,
            selectedDocument = Some(document(documentId.get))
          )
        )
  }
}