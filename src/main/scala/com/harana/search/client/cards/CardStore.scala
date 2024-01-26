package com.harana.search.client.cards

import diode.{Action => DiodeAction}

object CardStore {

  case class State(cards: List[List[String]],
                   horizontalLeftCard: Option[String],
                   horizontalRightCard: Option[String],
                   middleCard: Option[String],
                   middleHorizontalIndex: Int,
                   middleVerticalIndex: Int,
                   verticalTopCard: Option[String],
                   verticalBottomCard: Option[String])

  val initialState = State(List(), None, None, None, 0, 0, None, None)

  case object SelectHorizontalLeftCard extends DiodeAction
  case object SelectHorizontalRightCard extends DiodeAction
  case object SelectVerticalTopCard extends DiodeAction
  case object SelectVerticalBottomCard extends DiodeAction

  case class UpdateCards(cards: List[List[String]]) extends DiodeAction
  case class UpdateMiddleHorizontalIndex(index: Int) extends DiodeAction
  case class UpdateMiddleVerticalIndex(index: Int) extends DiodeAction

}