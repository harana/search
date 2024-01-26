package com.harana.search.client.settings.categories

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.settings.categories.CategoriesStore.{UpdateSearchCategories, UpdateSearchCategory}
import com.harana.web.actions.Init
import diode._

class CategoriesHandler extends ActionHandler(zoomTo(_.categoriesState)) {
  override def handle = {

    case Init(_) =>
      effectOnly(Tauri.list("list_search_categories", list => UpdateSearchCategories(list)))

    case UpdateSearchCategory(category) =>
      Tauri.update("update_search_category", Map("name" -> category.name, "enabled" -> category.enabled, "position" -> category.position),
        effect => updated(value.copy(searchCategories = value.searchCategories.map(c => if (c.name == category.name) category else c)), effect)
      )

    case UpdateSearchCategories(categories) =>
      updated(value.copy(searchCategories = categories))
  }
}