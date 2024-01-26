package com.harana.search.client.settings.ai.ui

import com.harana.search.client.Circuit
import com.harana.search.client.models.AiModelStatus
import com.harana.search.client.settings.ai.AiStore.{UpdateAiModel, UpdateAiModels}
import com.harana.web.external.tailwind._
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

import scala.scalajs.js

@react object AiPanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.aiState, true)

    div(className := "grid grid-cols-1 gap-x-10 gap-y-8 sm:grid-cols-6")(
      div(className := "sm:col-span-6")(
        div(style := js.Dynamic.literal("paddingBottom" -> "24px"))(
          div(className := "left")(Heading("AI Models"))
        ),
        Table(
          name = "ai_models",
          headers = List("Enabled", "IndexerType", "Model Name", "Model Status"),
          rows = state.aiModels.map { model =>
            List(
              div(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-6")(
                Switch(s"ai_model_${model.indexerType}", None, model.enabled, _ => Circuit.dispatch(UpdateAiModel(model)))
              ),
              div(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-6")(
                model.indexerType
              ),
              div(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")(
                Badge.gray(model.name)
              ),
              div(className := "whitespace-nowrap px-3 py-2 text-sm text-gray-500")(
                model.status match {
                  case AiModelStatus.InUse => Badge.green("In Use")
                  case AiModelStatus.NotYetDownloaded => Badge.yellow("Not Yet Downloaded")
                  case AiModelStatus.Downloading => Badge.gray("Downloading ..")
                }
              )
            )
          }
        )
      )
    )
  }
}
