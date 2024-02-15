package com.harana.search.client.cards

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.cards.CardStore._
import com.harana.web.actions.Init
import diode.Effect.action
import diode._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

class CardHandler extends ActionHandler(zoomTo(_.cardState)) {

  override def handle = {

    case Init(_) =>
      noChange

    case SelectHorizontalLeftCard =>
      effectOnly(action(UpdateMiddleHorizontalIndex(value.middleHorizontalIndex - 1)))

   case SelectHorizontalRightCard =>
     effectOnly(action(UpdateMiddleHorizontalIndex(value.middleHorizontalIndex + 1)))

    case SelectVerticalTopCard =>
      effectOnly(action(UpdateMiddleVerticalIndex(value.middleVerticalIndex - 1)))

    case SelectVerticalBottomCard =>
      effectOnly(action(UpdateMiddleVerticalIndex(value.middleVerticalIndex + 1)))

    case UpdateCards(cards) =>
      updated(value.copy(cards = cards), action(
        ActionBatch(
          UpdateMiddleHorizontalIndex(0),
          UpdateMiddleVerticalIndex(0)
        )
      ))

    case UpdateMiddleHorizontalIndex(index: Int) =>
      updated(value.copy(
        horizontalLeftCard = if (index > 0) Some(value.cards(index - 1).head) else None,
        horizontalRightCard = if (index < value.cards.size - 1) Some(value.cards(index + 1).head) else None,
        middleCard = Some(value.cards(index).head),
        middleHorizontalIndex = index,
        verticalTopCard = None,
        verticalBottomCard = if (value.cards(index).size > 1) Some(value.cards(index)(1)) else None
      ))

    case UpdateMiddleVerticalIndex(index: Int) =>
      val verticalCards = value.cards(value.middleHorizontalIndex)
      updated(value.copy(
        middleCard = Some(verticalCards(index)),
        middleVerticalIndex = index,
        verticalTopCard = if (index > 0) Some(verticalCards(index-1)) else None,
        verticalBottomCard = if (index < verticalCards.size - 1) Some(verticalCards(index+1)) else None
      ))
  }
}