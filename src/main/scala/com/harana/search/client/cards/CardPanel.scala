package com.harana.search.client.cards

import com.harana.search.client.Circuit
import com.harana.search.client.cards.CardStore.{SelectHorizontalLeftCard, SelectHorizontalRightCard, SelectVerticalBottomCard, SelectVerticalTopCard}
import com.harana.search.client.search.SearchStore.{Open, OpenParentFolder, Share, ShowPreview}
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
      val document = searchState.selectedDocument.get
      val integration = searchState.selectedIntegration.get
      val thumbnail = searchState.loadedThumbnails.get(searchState.selectedDocument.get.id)

      def card(name: Option[String]) =
        when(name.isDefined,
          div(className := "shadow-lg border border-gray-200 rounded-md bg-white pt-2 h-full")(
            when(Card(name.get).title.isDefined,
              div(className := "-ml-2 -mt-2 px-3 border-gray-200 border-b flex flex-wrap items-center justify-between sm:flex-nowrap")(
                div(className := "ml-2 mt-2 mb-2")(
                  h5(className := "font-semibold leading-6 text-gray-900")(Card(name.get).title.get)
                )
              )
            ),
            Card(name.get).element(document, integration, thumbnail)
          )
        )

      span(className := "justify-center")(
        div(className := "card-stack")(
          div(className := "container")(
            div(className := "cards")(
              div(className := s"card card-middle ${if (state.middleCard.isEmpty) "card-hidden" }")(
                card(state.middleCard)
              ),
              div(className := s"card card-horizontal-left ${if (state.horizontalLeftCard.isEmpty) "card-hidden" }", onClick := (_ => Circuit.dispatch(SelectHorizontalLeftCard)))(
                card(state.horizontalLeftCard)
              ),
              div(className := s"card card-horizontal-right ${if (state.horizontalRightCard.isEmpty) "card-hidden" }", onClick := (_ => Circuit.dispatch(SelectHorizontalRightCard)))(
                card(state.horizontalRightCard)
              ),
              div(className := s"card card-vertical-top ${if (state.verticalTopCard.isEmpty) "card-hidden" }", onClick := (_ => Circuit.dispatch(SelectVerticalTopCard)))(
                card(state.verticalTopCard)
              ),
              div(className := s"card card-vertical-bottom ${if (state.verticalBottomCard.isEmpty) "card-hidden" }", onClick := (_ => Circuit.dispatch(SelectVerticalBottomCard)))(
                card(state.verticalBottomCard)
              )
            )
          )
        ),
        span(className := "inline-flex w-all justify-center rounded-md ml-4 pt-6 pb-15")(
          button(disabled := !searchState.allowPreview, onClick := (_ => Circuit.dispatch(ShowPreview(searchState.selectedDocument.get))), `type` := "button", className := s"rounded-l-md px-3 $buttonClass ${if (!searchState.allowPreview) "disabled:opacity-50" }")("Preview"),
          button(disabled := searchState.selectedDocument.get.path.isEmpty, onClick := (_ => Circuit.dispatch(Open)), `type` := "button", className := s"-ml-px px-3 $buttonClass ${if (searchState.selectedDocument.get.path.isEmpty) "disabled:opacity-50" }")("Open"),
          button(disabled := searchState.selectedDocument.get.parentFolderPath.isEmpty, onClick := (_ => Circuit.dispatch(OpenParentFolder)), `type` := "button", className := s"-ml-px px-3 $buttonClass ${if (searchState.selectedDocument.get.parentFolderPath.isEmpty) "disabled:opacity-50" }")("Show Folder"),
          button(disabled := !searchState.allowShare, onClick := (_ => Circuit.dispatch(Share)), `type` := "button", className := s"-ml-px px-3 rounded-r-md $buttonClass ${if (!searchState.allowShare) "disabled:opacity-50" }")("Share")
        ),
        span(className := "inline-flex right justify-center rounded-md pt-6 pb-15 mr--4")(
        ),
      )
    }
  }
}