package com.harana.search.client.settings.categories

import com.harana.search.client.models._
import diode.{Action => DiodeAction}

object CategoriesStore {

  case class State(searchCategories: List[SearchCategory])

  val initialState = State(List())

  case class UpdateSearchCategory(category: SearchCategory) extends DiodeAction

  case class UpdateSearchCategories(searchCategories: List[SearchCategory]) extends DiodeAction
}