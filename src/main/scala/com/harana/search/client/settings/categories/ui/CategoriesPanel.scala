package com.harana.search.client.settings.categories.ui

import com.harana.search.client.Circuit
import com.harana.search.client.models.SearchCategory
import com.harana.search.client.settings.categories.CategoriesStore.UpdateSearchCategory
import com.harana.web.external.tailwind._
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

@react object CategoriesPanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>
    val state = Circuit.state(_.categoriesState, true)
    val splitCategories = state.searchCategories.splitAt((state.searchCategories.size / 2)+1)

    div(className := "grid grid-cols-1 gap-x-10 gap-y-8 sm:grid-cols-6")(
      div(className := "sm:col-span-3")(table(splitCategories._1)),
      div(className := "sm:col-span-3")(table(splitCategories._2))
    )
  }

  private def table(categories: List[SearchCategory]) =
    Table(
      name = "search_categories",
      headers = List("Category", "Enabled"),
      rows = categories.map { category =>
        val updated = category.copy(enabled = !category.enabled)
        List(Switch(s"search_result_${category.name}", Some(category.title), category.enabled, _ => Circuit.dispatch(UpdateSearchCategory(updated)), "px-4 py-2"))
      }
    )
}