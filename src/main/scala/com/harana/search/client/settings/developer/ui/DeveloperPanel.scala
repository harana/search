package com.harana.search.client.settings.developer.ui

import com.harana.search.client.Circuit
import com.harana.search.client.models.{DeveloperSource, SearchCategory}
import com.harana.search.client.settings.categories.CategoriesStore.UpdateSearchCategory
import com.harana.search.client.settings.developer.DeveloperStore.UpdateDeveloperSource
import com.harana.web.external.tailwind._
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

@react object DeveloperPanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>
    val state = Circuit.state(_.developerState, true)
    val splitSources = state.developerSources.splitAt((state.developerSources.size / 2) + 1)

    div(className := "grid grid-cols-2 gap-x-10 gap-y-8 sm:grid-cols-2")(
      div(className := "sm:col-span-1")(table(splitSources._1)),
      div(className := "sm:col-span-1")(table(splitSources._2)),
    )
  }

  private def table(sources: List[DeveloperSource]) =
    Table(
      name = "developer_sources",
      headers = List("Source", "Enabled"),
      rows = sources.map { source =>
        val updated = source.copy(enabled = !source.enabled)
        List(
          div(className := s"flex cursor-default select-none items-center pl-2")(
            div(className := "flex w-full")(
              div(className := "flex-none")(
                Switch(s"developer_source_${source.name}", Some(source.title), source.enabled, _ => Circuit.dispatch(UpdateDeveloperSource(updated)), "px-4 py-2")
              ),
              div(className := "flex-none mr-2 ml-auto")(
                Badge.gray(source.language)
              )
            )
          )
        )
      }
    )
}