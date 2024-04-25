package com.harana.search.client.cards

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.cards.CardStore._
import com.harana.web.actions.{Init, NoChange}
import diode.Effect.action
import diode._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

class CardHandler extends ActionHandler(zoomTo(_.cardState)) {

  override def handle = {

    case Init(_) =>
      noChange

    case SelectHorizontalLeftCard =>
      if (value.middleHorizontalIndex > 0)
        effectOnly(action(UpdateMiddleHorizontalIndex(value.middleHorizontalIndex - 1)))
      else
        noChange

   case SelectHorizontalRightCard =>
     if (value.middleHorizontalIndex < value.cards.size - 1)
      effectOnly(action(UpdateMiddleHorizontalIndex(value.middleHorizontalIndex + 1)))
     else
       noChange

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
      if (index < value.cards.size)
        updated(value.copy(
          horizontalLeftCard = if (index > 0) Some(value.cards(index - 1).head) else None,
          horizontalRightCard = if (index < value.cards.size - 1) Some(value.cards(index + 1).head) else None,
          middleCard = Some(value.cards(index).head),
          middleHorizontalIndex = index,
          verticalTopCard = None,
          verticalBottomCard = value.cards(index).lift(1)
        ))
      else
        noChange

    case UpdateMiddleVerticalIndex(index: Int) =>
      val verticalCards = if (value.cards.isEmpty) List() else value.cards(value.middleHorizontalIndex)
      if (index < verticalCards.size)
        updated(value.copy(
          middleCard = Some(verticalCards(index)),
          middleVerticalIndex = index,
          verticalTopCard = if (index > 0) Some(verticalCards(index-1)) else None,
          verticalBottomCard = if (index < verticalCards.size - 1) Some(verticalCards(index+1)) else None
        ))
      else
        noChange
  }
}