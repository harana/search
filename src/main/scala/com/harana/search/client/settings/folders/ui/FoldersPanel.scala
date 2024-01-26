package com.harana.search.client.settings.folders.ui

import com.harana.search.client.Circuit
import com.harana.search.client.settings.folders.FoldersStore.{DeletePrivateFolder, UpdateSearchFolder}
import com.harana.web.external.tailwind.OutlineIcons._
import com.harana.web.external.tailwind._
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js.Dynamic.{literal => css}

@react object FoldersPanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.foldersState, true)

    div(className := "grid grid-cols-1 gap-x-10 gap-y-8 sm:grid-cols-6")(
      div(className := "sm:col-span-3")(
        div(style := css("paddingBottom" -> "24px"))(
          div(className := "left")(Heading("Search Folders"))
        ),
        Table(
          name = "search_folders",
          headers = List("Switch"),
          rows =
            state.searchFolders.sortBy(_.nameOrPath).map(folder => {
              val updated = folder.copy(enabled = !folder.enabled)
              List(Switch(s"search_folders_${folder.nameOrPath}", Some(folder.nameOrPath), folder.enabled, _ => Circuit.dispatch(UpdateSearchFolder(updated)), "px-4 py-2"))
            })
        )
      ),
      div(className := "sm:col-span-3")(
        div(style := css("paddingBottom" -> "24px"))(
          div(className := "left")(Heading("Private Folders")),
          Button(
            label = None,
            icon = Some(PlusOutlineIcon("h-4 w-4")),
            size = ButtonSize.ExtraSmall,
            className = Some("right text-gray-600"),
            onClick = () => ()
          )
        ),
        Table(
          name = "private_folders",
          headers = List("Folder"),
          noRowsMessage = Some("No private folders available"),
          rows = List(
            state.privateFolders.sorted.map(folder =>
              List[ReactElement](
                div(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-4")(folder),
                Button(
                  label = None,
                  icon = Some(TrashOutlineIcon("h-4 w-4")),
                  size = ButtonSize.ExtraSmall,
                  className = Some("right text-gray-600"),
                  onClick = () => Circuit.dispatch(DeletePrivateFolder(folder)))
              )
            )
          ),
          actionColumn = true
        )
      )
    )
  }
}
