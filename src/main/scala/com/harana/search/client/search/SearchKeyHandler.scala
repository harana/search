package com.harana.search.client.search

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.{Circuit, Tauri}
import com.harana.search.client.cards.CardStore._
import com.harana.search.client.models.Integrations
import com.harana.search.client.search.SearchStore._
import com.harana.search.client.search.ui.{Keys, SearchColumn}
import com.harana.web.actions.NoChange
import diode.Effect.action
import diode._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

class SearchKeyHandler extends ActionHandler(zoomTo(_.searchState)) {

  override def handle = {

    case Backspace =>
      effectOnly(
        action(
          ActionBatch(
            UpdateFocusedPanel(SearchColumn.Search),
            UpdateSearchTerm(value.searchTerm.map(s => if (s.nonEmpty) s.dropRight(1) else s))
          )
        )
      )

    case KeyDown(key, event) =>
      effectOnly {
        value.focusedPanel match {
          case SearchColumn.Search =>
            key match {
              case Keys.Down =>
                action(if (value.searchResults.nonEmpty) SelectIntegration(value.searchResults.head._1) else NoChange)

              case Keys.Enter =>
                action(if (value.searchApplication.nonEmpty) OpenApplication else NoChange)

              case Keys.Space =>
                if (value.searchTerm.isEmpty || value.searchTerm.get.isBlank) {
                  event.stopPropagation()
                }
                action(NoChange)

              case _ =>
                action(NoChange)
            }

          case SearchColumn.Integration =>
            key match {
              case Keys.Down =>
                if (value.selectedIntegration.get != value.searchResults.last._1)
                  if (event.getModifierState("Control") || event.getModifierState("Meta"))
                    action(SelectIntegration(value.searchResults.last._1))
                  else {
                    val index = value.searchResults.map(_._1).indexOf(value.selectedIntegration.get)
                    action(SelectIntegration(value.searchResults(index + 1)._1))
                  }
                else
                  action(NoChange)

              case Keys.Up =>
                if (value.selectedIntegration.get == value.searchResults.head._1)
                  action(SearchFocused)
                else
                  if (event.getModifierState("Control") || event.getModifierState("Meta"))
                    action(SelectIntegration(value.searchResults.head._1))
                  else {
                    val index = value.searchResults.map(_._1).indexOf(value.selectedIntegration.get)
                    action(SelectIntegration(value.searchResults(index - 1)._1))
                  }

              case Keys.Right =>
                val documents = value.searchResults.find(_._1 == value.selectedIntegration.get).get._2
                action(SelectDocument(documents.head.id, true))

              case Keys.Backspace | Keys.Delete =>
                action(Backspace)

              case _ =>
                val key = event.key.toLowerCase

                val prefixIntegration = value.searchResults
                  .map(p => Integrations.get(p._1))
                  .sortBy(_.title)
                  .find(_.title.toLowerCase.startsWith(event.key.toLowerCase))

                val selectedIntegration = Integrations.get(value.selectedIntegration.get)

                if (prefixIntegration.nonEmpty && !selectedIntegration.title.toLowerCase.startsWith(key))
                  action(SelectIntegration(prefixIntegration.get.id))
                 else
                  action(NoChange)
            }

          case SearchColumn.Document =>
            event.stopPropagation()

            val documents = value.searchResults.find(_._1 == value.selectedIntegration.get).get._2

            key match {
              case Keys.Down =>
                if (event.getModifierState("Control") || event.getModifierState("Meta"))
                  action(SelectDocument(documents.last.id, true))
                else
                  action(SelectNextDocument)

              case Keys.Up =>
                if (value.selectedDocument.get == documents.head)
                  action(SearchFocused)
                else
                  if (event.getModifierState("Control") || event.getModifierState("Meta"))
                    action(SelectDocument(documents.head.id, true))
                  else
                    action(SelectPreviousDocument)

              case Keys.Left =>
                action(
                  ActionBatch(
                    UpdateFocusedPanel(SearchColumn.Integration),
                    UpdateSelectedDocument(None)
                  )
                )

              case Keys.Right =>
                action(UpdateFocusedPanel(SearchColumn.Cards)) +
                action(SelectHorizontalRightCard) >>
                action(ScrollToDocument(value.selectedDocumentId.get))

              case Keys.Backspace | Keys.Delete =>
                action(Backspace)

              case Keys.Enter =>
                action(if (event.shiftKey) OpenParentFolder else Open)

              case Keys.Space =>
                if (value.selectedDocument.nonEmpty && value.allowPreview)
                  action(ShowPreview(value.selectedDocument.get))
                else
                  action(NoChange)

              case _ =>
                val key = event.key.toLowerCase

                val prefixDocument = documents
                  .sortBy(_.title.toLowerCase)
                  .find(_.title.toLowerCase.startsWith(key))

                if (prefixDocument.nonEmpty || !value.selectedDocument.get.title.toLowerCase.startsWith(key)) {
                  action(UpdateSelectedDocument(Some(prefixDocument.get.id))) >>
                  action(ScrollToDocument(prefixDocument.get.id))
                } else {
                  action(NoChange)
                }
            }

          case SearchColumn.Cards =>
            event.stopPropagation()

            val cardState = Circuit.state(_.cardState, false)
            val hasVerticalCards = cardState.cards.nonEmpty && cardState.cards(cardState.middleHorizontalIndex).nonEmpty

            key match {
              case Keys.Down =>
                if (hasVerticalCards)
                  action(if (cardState.middleVerticalIndex < cardState.cards(cardState.middleHorizontalIndex).size -1) SelectVerticalBottomCard else NoChange)
                else
                  action(SelectNextDocument)

              case Keys.Up =>
                if (hasVerticalCards)
                  action(if (cardState.middleVerticalIndex > 0) SelectVerticalTopCard else SelectPreviousDocument)
                else
                  action(SearchFocused)

              case Keys.Left =>
                action(SelectHorizontalLeftCard) + action(if (cardState.middleHorizontalIndex == 0) UpdateFocusedPanel(SearchColumn.Document) else NoChange)

              case Keys.Right =>
                action(SelectHorizontalRightCard)

              case Keys.Backspace | Keys.Delete =>
                action(Backspace)

              case Keys.Enter =>
                action(if (event.shiftKey) OpenParentFolder else Open)

              case Keys.Space =>
                val shouldShowPreview = value.selectedDocument.nonEmpty && value.allowPreview
                action(if (shouldShowPreview) ShowPreview(value.selectedDocument.get) else NoChange)

              case _ =>
                action(NoChange)
            }
        }
      }

    case KeyUp(key, event) =>
      effectOnly(action(NoChange))

      event.stopPropagation()

      effectOnly {
        if (key == Keys.Escape)
          if (value.searchTerm.isEmpty) {
            Tauri.invoke("hide_search")
            action(NoChange)
          } else
            if (value.focusedPanel != SearchColumn.Search)
              action(
                ActionBatch(
                  UpdateFocusedPanel(SearchColumn.Search),
                  Search(value.searchTerm)
                )
              )
            else
              action(Search(None))
        else {
          event.stopPropagation()
          event.preventDefault()
          action(NoChange)
        }
      }
  }
}