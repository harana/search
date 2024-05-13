package com.harana.search.client.search.ui

import com.harana.search.client.Circuit
import com.harana.search.client.cards.CardPanel
import com.harana.search.client.search.SearchStore._
import com.harana.search.client.search.ui.rows.{DocumentRow, IntegrationRow}
import com.harana.web.components.when
import com.harana.web.external.tailwind.OutlineIcons._
import com.harana.web.external.tailwind.SolidIcons._
import com.harana.web.external.tailwind.popover.PopoverButton
import com.harana.web.external.tauri.Tauri
import com.harana.web.external.virtuoso.{Style, Virtuoso}
import org.scalajs.dom._
import slinky.core.annotations.react
import slinky.core.facade.Hooks.useEffect
import slinky.core.facade.React
import slinky.core.{CustomAttribute, FunctionalComponent}
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

@react object SearchPanel {
  type Props = Unit

  val documentsRef = React.createRef[Virtuoso.RefType]
  val inputRef = React.createRef[HTMLInputElement]
  val integrationsRef = React.createRef[Virtuoso.RefType]

  val component = FunctionalComponent[Unit] { _ =>

    val authState = Circuit.state(_.authState, true)
    val state = Circuit.state(_.searchState, true)
    val systemState = Circuit.state(_.systemState, true)

    useEffect(
      () => {
        if (inputRef.current != null)
          inputRef.current.blur()
      },
      Seq.empty
    )

    Tauri.invoke("update_window_size", Map("label" -> "search", "width" -> 950.0, "height" -> (if (state.searchResults.nonEmpty) 680.0 else 58.0)).toJSDictionary)

    val dragRegionAttr = new CustomAttribute[Boolean]("data-tauri-drag-region")

    div(
      div(className := "relative", dragRegionAttr := true)(
        MagnifyingGlassOutlineIcon("pointer-events-none absolute left-4 mt-half top-4 h-5 w-5 text-gray-400"),

        input(
          className := "h-14 w-350 search-input border-0 bg-transparent ml-10 text-gray-900 placeholder:text-gray-600 focus:ring-0 sm:text-md",
          placeholder := "Search...",
          autoComplete := "false",
          ref := inputRef,
          spellCheck := false,
          onClick := { _ => Circuit.dispatch(SearchFocused) },
          onChange := { e =>
            val value = e.target.asInstanceOf[js.Dynamic].value.asInstanceOf[String]
            Circuit.dispatch(Search(if (value.isEmpty) None else Some(value)))
          }
        ),

        when(state.focusedPanel == SearchColumn.Search)(ApplicationHint()),
        when(state.searchResults.nonEmpty) {
          PopoverButton(
            onClick = () => Tauri.invoke("update_window_size", Map("label" -> "search", "width" -> 950.0, "height" -> 680.0).toJSDictionary),
            className = "absolute right-4 top-4 h-6 w-5 text-gray-400")(
            Bars3Icon()
          )
        }
      ),

      // Integrations
      when(state.searchResults.nonEmpty)(
        div(className := "h-410 flex divide-x divide-gray-100 text-gray-700 text-sm overflow-y-hidden")(
          div(dragRegionAttr := true, className := s"flex-auto mw-250 mxw-250 scroll-py-4 pb-3")(
            Virtuoso(
              className = "search-virtuoso",
              data = state.searchResults,
              itemContent = (index: Int) =>
                IntegrationRow(
                  integration = state.integrations.find(_.id == state.searchResults(index)._1).get,
                  active = state.selectedIntegration.nonEmpty && state.selectedIntegration.get.equals(state.searchResults(index)._1),
                  systemState.appAssetsUrl
                ),
              style = new Style {
                override val height: String = s"100%"
              }
            ).withRef(integrationsRef)
          ),

          // Documents
          div(className := "mw-325 flex-none flex-col divide-y sm:flex pb-3")(
            div(dragRegionAttr := true, className := "flex-auto") {
              val documents = state.selectedIntegration.flatMap(integration => state.searchResults.find(_._1.equals(integration)))

              when(documents.nonEmpty)(
                Virtuoso(
                  className = "search-virtuoso",
                  data = documents.get._2,
                  itemContent = (index: Int) => {
                    val currentDocument = documents.get._2(index)
                    val active = state.selectedDocumentId.nonEmpty && state.selectedDocumentId.get.equals(currentDocument.id)
                    DocumentRow(currentDocument, active, systemState.appAssetsUrl)
                  },
                  style = new Style {
                    override val height: String = s"100%"
                  }
                ).withRef(documentsRef)
              )
            }
          ),

          // Cards
          div(dragRegionAttr := true, className := "w-335 text-md pl-8")(
            CardPanel().withKey(state.selectedDocumentId.getOrElse("-1"))
          )
        )
      ),
      when(state.errorMessage.isDefined)(
        div(className := "error-bar relative", dragRegionAttr := true)(
          state.errorMessage.get
        )
      )
    )
  }
}
