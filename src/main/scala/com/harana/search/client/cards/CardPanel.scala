package com.harana.search.client.cards

import com.harana.search.client.Circuit
import com.harana.search.client.cards.CardStore.{SelectHorizontalLeftCard, SelectHorizontalRightCard, SelectVerticalBottomCard, SelectVerticalTopCard}
import com.harana.search.client.search.SearchStore.{Open, OpenParentFolder, ShowPreview}
import com.harana.web.components.when
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

@react object CardPanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.cardState, true)
    val searchState = Circuit.state(_.searchState, true)

    val buttonClass = "relative inline-flex bg-white py-2 text-xs font-semibold text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-10"

    when(searchState.selectedDocument.nonEmpty && searchState.selectedIntegration.nonEmpty) {
      val thumbnail = searchState.loadedThumbnails.get(searchState.selectedDocument.get.id)

      span(className := "justify-center")(
        div(className := "card-stack")(
          div(className := "container")(
            div(className := "cards")(
              div(className := s"card card-middle ${if (state.middleCard.isEmpty) "card-hidden"}")(
                Card(state.middleCard, searchState.selectedDocument.get, searchState.selectedIntegration.get, thumbnail)
              ),
              div(className := s"card card-horizontal-left ${if (state.horizontalLeftCard.isEmpty) "card-hidden"}", onClick := (_ => Circuit.dispatch(SelectHorizontalLeftCard)))(
                Card(state.horizontalLeftCard, searchState.selectedDocument.get, searchState.selectedIntegration.get, thumbnail)
              ),
              div(className := s"card card-horizontal-right ${if (state.horizontalRightCard.isEmpty) "card-hidden"}", onClick := (_ => Circuit.dispatch(SelectHorizontalRightCard)))(
                Card(state.horizontalRightCard, searchState.selectedDocument.get, searchState.selectedIntegration.get, thumbnail)
              ),
              div(className := s"card card-vertical-top ${if (state.verticalTopCard.isEmpty) "card-hidden"}", onClick := (_ => Circuit.dispatch(SelectVerticalTopCard)))(
                Card(state.verticalTopCard, searchState.selectedDocument.get, searchState.selectedIntegration.get, thumbnail)
              ),
              div(className := s"card card-vertical-bottom ${if (state.verticalBottomCard.isEmpty) "card-hidden"}", onClick := (_ => Circuit.dispatch(SelectVerticalBottomCard)))(
                Card(state.verticalBottomCard, searchState.selectedDocument.get, searchState.selectedIntegration.get, thumbnail)
              )
            )
          )
        ),
        span(className := "inline-flex w-full justify-center rounded-md pb-15")(
          button(disabled := !searchState.allowPreview, onClick := (_ => Circuit.dispatch(ShowPreview(searchState.selectedDocument.get))), `type` := "button", className := s"rounded-l-md px-3 $buttonClass ${if (!searchState.allowPreview) "disabled:opacity-50" }")("Preview"),
          button(onClick := (_ => Circuit.dispatch(Open)), `type` := "button", className := s"-ml-px px-3 $buttonClass")("Open"),
          button(onClick := (_ => Circuit.dispatch(OpenParentFolder)), `type` := "button", className := s"-ml-px px-3 rounded-r-md $buttonClass")("Show Folder")
        )
      )
    }
  }
}