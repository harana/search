package com.harana.search.client.settings.indexing.ui

import com.harana.search.client.Circuit
import com.harana.search.client.models.IndexerProgress
import com.harana.search.client.settings.indexing.IndexingStore._
import com.harana.web.external.tailwind._
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => css}
import scala.scalajs.js.|

@react object IndexingPanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.indexingState, true)

    div(className := "grid grid-cols-1 gap-x-10 gap-y-8 sm:grid-cols-6")(
      div(className := "sm:col-span-6")(
        div(style := css("paddingBottom" -> "40px"))(
          div(className := "left")(Heading("Progress"))
        ),
        div(className := "w-full h-6 bg-gray-200 rounded-full")(
          div(
            className := "bg-indigo-600 text-xs pt-font-medium text-white text-center h-6 leading-none rounded-full",
            style := css("paddingTop" -> "0.35rem", "width" -> "45%")
          )("1 hour remaining")
        ),
        Table(
          name = "indexer_statuses",
          headers = List("Indexer", "Status", "Files"),
          rows = state.indexerStatuses.map { status =>
            List(
              div(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-4")(
                status.indexerType.entryName
              ),
              div(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")(
                status.indexerProgress match {
                  case IndexerProgress.NotYetStarted => Badge.gray("Not Yet Started")
                  case IndexerProgress.InProgress => Badge.yellow("Up to Date")
                  case IndexerProgress.UpToDate => Badge.green("Up to Date")
                }
              ),
              div(
                Badge.gray(s"${status.fileCount} files")
              )
            )
          }
        ),
        div(className := "mb-2", style := js.Dynamic.literal("paddingTop" -> "40px"))(Heading("Pause")),

        div(className := "-mx-4 -my-2 sm:-mx-6 lg:-mx-8")(
          div(className := "inline-block min-w-full py-2 align-middle sm:px-6 lg:px-8")(
            div(className := "shadow ring-1 ring-black ring-opacity-5 sm:rounded-lg")(
              table(className := "min-w-full divide-y divide-gray-300")(
                tbody(className := "divide-y divide-gray-200 bg-white")(
                  tr(
                    td(colSpan := 3, className := "pb-2 pt-3 rounded-tl-lg")(
                      div(className := "whitespace-nowrap pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-4")(
                        Switch("pause_cpu_temperatures",
                          label = Some("CPU Temperature greater than"),
                          state.pauseCpuTemperatureEnabled,
                          _ => Circuit.dispatch(UpdatePauseCpuTemperatureEnabled(!state.pauseCpuTemperatureEnabled))
                        ),
                      )
                    ),
                    td(className := "pb-2 pt-3 rounded-tr-lg")(
                      div(className := "whitespace-nowrap px-1 pr-3 text-sm text-gray-500")(
                        Listbox(
                          "cpu_temperatures_list",
                          selectedItem = state.pauseCpuTemperatureValue,
                          items = (10 to 120).toList,
                          itemId = item => item.toString,
                          itemTitle = item => s"${item.toString}C",
                          label = None,
                          onChange = item => ()
                        )
                      )
                    )
                  ),
                  tr(
                    td(colSpan := 3, className := "py-2")(
                      div(className := "whitespace-nowrap pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-4")(
                        Switch("pause_cpu_utilisation",
                          label = Some("CPU Utilisation greater than"),
                          state.pauseCpuUtilisationEnabled,
                          _ => Circuit.dispatch(UpdatePauseCpuUtilisationEnabled(!state.pauseCpuUtilisationEnabled))
                        ),
                      )
                    ),
                    td(className := "py-2")(
                      div(className := "whitespace-nowrap px-1 pr-3 text-sm text-gray-500")(
                        Listbox(
                          "cpu_utilisations_list",
                          selectedItem = state.pauseCpuUtilisationValue,
                          items = (0 to 100).toList,
                          itemId = item => item.toString,
                          itemTitle = item => s"${item.toString}%",
                          label = None,
                          onChange = item => ()
                        )
                      )
                    )
                  ),
                  tr(
                    td(className := "pt-2 pb-3 rounded-bl-lg")(
                      div(className := "whitespace-nowrap pl-4 text-sm font-medium text-gray-900 sm:pl-4")(
                        Switch("pause_hours_between",
                          label = Some("Hours between"),
                          state.pauseHoursBetweenEnabled,
                          _ => Circuit.dispatch(UpdatePauseHoursBetweenEnabled(!state.pauseHoursBetweenEnabled))
                        ),
                      )
                    ),
                    td(className := "pt-2 pb-3")(
                      div(className := "whitespace-nowrap px-1 text-sm text-gray-500")(
                        Listbox(
                          "pause_hours_between_start",
                          selectedItem = state.pauseHoursBetweenStart,
                          items = (0 to 23).toList,
                          itemId = item => item.toString,
                          itemTitle = item => {
                            val i = item.asInstanceOf[Int]
                            if (i == 0) "12:00 am"
                            else if (i > 0 && i < 12) s"$i:00 am"
                            else if (i == 12) "12:00 pm"
                            else s"${i-12}:00 pm"
                          },
                          label = None,
                          onChange = item => Circuit.dispatch(UpdatePauseHoursBetweenStart(item.asInstanceOf[Int]))
                        )
                      )
                    ),
                    td(style := css("padding-bottom" -> "5px"))(
                      span(className := "text-sm pt-2 pb-2 font-medium text-gray-900")("and")
                    ),
                    td(className := "pt-2 pb-3 rounded-br-lg")(
                      div(className := "whitespace-nowrap px-1 pr-3 text-sm text-gray-500")(
                        Listbox(
                          "pause_hours_between_end",
                          selectedItem = state.pauseHoursBetweenEnd,
                          items = (0 to 23).toList,
                          itemId = item => item.toString,
                          itemTitle = item => {
                            val i = item.asInstanceOf[Int]
                            if (i == 0) "12:00 am"
                            else if (i > 0 && i < 12) s"$i:00 am"
                            else if (i == 12) "12:00 pm"
                            else s"${i-12}:00 pm"
                          },
                          label = None,
                          onChange = item => Circuit.dispatch(UpdatePauseHoursBetweenEnd(item.asInstanceOf[Int])),
                          className = "z-100"
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  }
}
