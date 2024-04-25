package com.harana.search.client.search

import com.harana.search.client.models.Document.DocumentId
import com.harana.search.client.models.Integration.IntegrationId
import com.harana.search.client.models.{Application, Document, Integration, Integrations}
import com.harana.search.client.search.ui.SearchColumn
import diode.{Action => DiodeAction}
import org.scalajs.dom.KeyboardEvent

object SearchStore {

  type SearchTerm = String

  case class State(allowPreview: Boolean,
                   allowShare: Boolean,
                   integrations: List[Integration],
                   focusedPanel: SearchColumn,
                   errorMessage: Option[String],
                   loadedThumbnails: Map[DocumentId, String],
                   searchApplication: Option[Application],
                   searchResults: List[(IntegrationId, List[Document])],
                   searchTerm: Option[String],
                   selectedCardHorizontal: Int,
                   selectedCardVertical: Int,
                   selectedIntegration: Option[IntegrationId],
                   selectedDocumentId: Option[DocumentId],
                   selectedDocument: Option[Document])

  val initialState = State(false, false, Integrations.list, SearchColumn.Search, None, Map(), None, List(), None, 1, 1, None, None, None)

  case class KeyDown(key: Int, event: KeyboardEvent) extends DiodeAction
  case class KeyUp(key: Int, event: KeyboardEvent) extends DiodeAction
  case object Backspace extends DiodeAction
  case object ShowPreview extends DiodeAction

  case object LoadIntegrations extends DiodeAction
  case class Search(term: Option[SearchTerm]) extends DiodeAction

  case object SearchFocused extends DiodeAction
  case object RefreshFocusedPanel extends DiodeAction

  case object Open extends DiodeAction
  case object OpenApplication extends DiodeAction
  case object OpenParentFolder extends DiodeAction
  case object Share extends DiodeAction

  case object Hide extends DiodeAction
  case class ShowPreview(document: Document) extends DiodeAction
  case object ShowBilling extends DiodeAction
  case object ShowFeedback extends DiodeAction
  case object ShowLogin extends DiodeAction
  case object ShowHaranaPlus extends DiodeAction
  case object ShowSettings extends DiodeAction
  case object ShowSupport extends DiodeAction

  case class SelectIntegration(integrationId: IntegrationId) extends DiodeAction
  case class SelectDocument(documentId: DocumentId, scroll: Boolean)  extends DiodeAction
  case object SelectPreviousDocument  extends DiodeAction
  case object SelectNextDocument  extends DiodeAction

  case class LoadThumbnail(documentId: DocumentId)  extends DiodeAction

  case class ScrollToDocument(document: DocumentId)  extends DiodeAction
  case class ScrollToIntegration(integration: IntegrationId)  extends DiodeAction
  case object ScrollToFirstDocument extends DiodeAction
  case object ScrollToLastDocument extends DiodeAction
  case object ScrollToFirstIntegration extends DiodeAction
  case object ScrollToLastIntegration extends DiodeAction

  case class UpdateAllowPreview(preview: Boolean) extends DiodeAction
  case class UpdateAllowShare(share: Boolean) extends DiodeAction
  case class UpdateErrorMessage(message: Option[String]) extends DiodeAction
  case class UpdateIntegrations(integrations: List[Integration]) extends DiodeAction
  case class UpdateFocusedPanel(panel: SearchColumn) extends DiodeAction
  case class UpdateLoadedThumbnails(thumbnails: Map[DocumentId, String]) extends DiodeAction
  case class UpdateSelectedCardHorizontal(index: Int) extends DiodeAction
  case class UpdateSelectedCardVertical(index: Int) extends DiodeAction
  case class UpdateSearchApplication(application: Option[Application]) extends DiodeAction
  case class UpdateSearchResults(results: List[(IntegrationId, List[Document])]) extends DiodeAction
  case class UpdateSearchTerm(term: Option[SearchTerm]) extends DiodeAction
  case class UpdateSelectedDocument(documentId: Option[DocumentId]) extends DiodeAction
  case class UpdateSelectedIntegration(connector: Option[IntegrationId]) extends DiodeAction
}