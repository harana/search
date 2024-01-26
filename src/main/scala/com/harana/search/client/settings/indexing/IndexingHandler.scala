package com.harana.search.client.settings.indexing

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.models.{IndexerStatus, Theme}
import com.harana.search.client.settings.ai.AiStore.UpdateAiModels
import com.harana.search.client.settings.general.GeneralStore.UpdateAppearanceTheme
import com.harana.search.client.settings.indexing.IndexingStore._
import com.harana.web.actions.Init
import diode.ActionResult.NoChange
import diode._
import io.circe.parser.decode
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

class IndexingHandler extends ActionHandler(zoomTo(_.indexingState)) {
  override def handle = {

    case Init(_) =>
      effectOnly(
        Tauri.list("list_indexer_statuses", list => UpdateIndexerStatuses(list)) +
        Tauri.setting("indexer_pause_cpu_temperature_enabled", value => UpdatePauseCpuTemperatureEnabled(value.toBoolean)) +
        Tauri.setting("indexer_pause_cpu_temperature_value", value => UpdatePauseCpuTemperatureValue(value.toInt)) +
        Tauri.setting("indexer_pause_cpu_utilisation_enabled", value => UpdatePauseCpuTemperatureEnabled(value.toBoolean)) +
        Tauri.setting("indexer_pause_cpu_utilisation_value", value => UpdatePauseCpuUtilisationValue(value.toInt)) +
        Tauri.setting("indexer_pause_hours_between_enabled", value => UpdatePauseHoursBetweenEnabled(value.toBoolean)) +
        Tauri.setting("indexer_pause_hours_between_start", value => UpdatePauseHoursBetweenStart(value.toInt)) +
        Tauri.setting("indexer_pause_hours_between_end", value => UpdatePauseHoursBetweenEnd(value.toInt))
      )

    case UpdateIndexerStatuses(statuses) =>
      updated(value.copy(indexerStatuses = statuses))

    case UpdateOverallProgress(progress) =>
      updated(value.copy(overallProgress = progress))

    case UpdatePauseCpuTemperatureEnabled(enabled) =>
      Tauri.update_setting("indexer_pause_cpu_temperature_enabled", enabled.toString,
        effect => updated(value.copy(pauseCpuTemperatureEnabled = enabled), effect)
      )

    case UpdatePauseCpuTemperatureValue(cpuTemperatureValue) =>
      Tauri.update_setting("indexer_pause_cpu_temperature_value", cpuTemperatureValue.toString,
        effect => updated(value.copy(pauseCpuTemperatureValue = cpuTemperatureValue), effect)
      )

    case UpdatePauseCpuUtilisationEnabled(enabled) =>
      Tauri.update_setting("indexer_pause_cpu_temperature_value", enabled.toString,
        effect => updated(value.copy(pauseCpuTemperatureEnabled = enabled), effect)
      )

    case UpdatePauseCpuUtilisationValue(cpuUtilisationValue) =>
      Tauri.update_setting("indexer_pause_cpu_utilisation_value", cpuUtilisationValue.toString,
        effect => updated(value.copy(pauseCpuUtilisationValue = cpuUtilisationValue), effect)
      )

    case UpdatePauseHoursBetweenEnabled(enabled) =>
      Tauri.update_setting("indexer_pause_hours_between_enabled", enabled.toString,
        effect => updated(value.copy(pauseHoursBetweenEnabled = enabled), effect)
      )

    case UpdatePauseHoursBetweenStart(startValue) =>
      Tauri.update_setting("indexer_pause_hours_between_start", startValue.toString,
        effect => updated(value.copy(pauseHoursBetweenStart = startValue), effect)
      )

    case UpdatePauseHoursBetweenEnd(endValue) =>
      Tauri.update_setting("indexer_pause_hours_between_end", endValue.toString,
        effect => updated(value.copy(pauseHoursBetweenEnd = endValue), effect)
      )
  }
}