package com.harana.search.client.settings.indexing

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.settings.indexing.IndexingStore._
import com.harana.web.actions.Init
import diode._

class IndexingHandler extends ActionHandler(zoomTo(_.indexingState)) {
  override def handle = {

    case Init(_) =>
      effectOnly(
        Tauri.list("list_indexer_statuses", list => UpdateIndexerStatuses(list)) +
        Tauri.setting("indexer_pause_ac_power_required", value => UpdatePauseAcPowerRequired(value.toBoolean)) +
        Tauri.setting("indexer_pause_battery_life_remaining_enabled", value => UpdatePauseBatteryLifeRemainingEnabled(value.toBoolean)) +
        Tauri.setting("indexer_pause_battery_life_remaining_value", value => UpdatePauseBatteryLifeRemainingValue(value.toInt)) +
        Tauri.setting("indexer_pause_cpu_maximum_temperature_enabled", value => UpdatePauseCpuMaximumTemperatureEnabled(value.toBoolean)) +
        Tauri.setting("indexer_pause_cpu_maximum_temperature_value", value => UpdatePauseCpuMaximumTemperatureValue(value.toInt)) +
        Tauri.setting("indexer_pause_cpu_maximum_usage_enabled", value => UpdatePauseCpuMaximumTemperatureEnabled(value.toBoolean)) +
        Tauri.setting("indexer_pause_cpu_maximum_usage_value", value => UpdatePauseCpuMaximumUsageValue(value.toInt)) +
        Tauri.setting("indexer_pause_hours_between_enabled", value => UpdatePauseHoursBetweenEnabled(value.toBoolean)) +
        Tauri.setting("indexer_pause_hours_between_start", value => UpdatePauseHoursBetweenStart(value.toInt)) +
        Tauri.setting("indexer_pause_hours_between_end", value => UpdatePauseHoursBetweenEnd(value.toInt))
      )

    case UpdateIndexerStatuses(statuses) =>
      updated(value.copy(indexerStatuses = statuses))

    case UpdateOverallProgress(progress) =>
      updated(value.copy(overallProgress = progress))

    case UpdatePauseAcPowerRequired(required) =>
      Tauri.update_setting("indexer_pause_ac_power_required", required.toString,
        effect => updated(value.copy(pauseAcPowerRequired = required), effect)
      )

    case UpdatePauseBatteryLifeRemainingEnabled(enabled) =>
      Tauri.update_setting("indexer_pause_battery_life_remaining_enabled", enabled.toString,
        effect => updated(value.copy(pauseBatteryLifeRemainingEnabled = enabled), effect)
      )

    case UpdatePauseBatteryLifeRemainingValue(newValue) =>
      Tauri.update_setting("indexer_pause_battery_life_remaining_value", newValue.toString,
        effect => updated(value.copy(pauseBatteryLifeRemainingValue = newValue), effect)
      )

    case UpdatePauseCpuMaximumTemperatureEnabled(enabled) =>
      Tauri.update_setting("indexer_pause_cpu_maximum_temperature_enabled", enabled.toString,
        effect => updated(value.copy(pauseCpuMaximumTemperatureEnabled = enabled), effect)
      )

    case UpdatePauseCpuMaximumTemperatureValue(newValue) =>
      Tauri.update_setting("indexer_pause_cpu_maximum_temperature_value", newValue.toString,
        effect => updated(value.copy(pauseCpuMaximumTemperatureValue = newValue), effect)
      )

    case UpdatePauseCpuMaximumUsageEnabled(enabled) =>
      Tauri.update_setting("indexer_pause_cpu_maximum_usage_enabled", enabled.toString,
        effect => updated(value.copy(pauseCpuMaximumUsageEnabled = enabled), effect)
      )

    case UpdatePauseCpuMaximumUsageValue(newValue) =>
      Tauri.update_setting("indexer_pause_cpu_maximum_usage_value", newValue.toString,
        effect => updated(value.copy(pauseCpuMaximumUsageValue = newValue), effect)
      )

    case UpdatePauseHoursBetweenEnabled(enabled) =>
      Tauri.update_setting("indexer_pause_hours_between_enabled", enabled.toString,
        effect => updated(value.copy(pauseHoursBetweenEnabled = enabled), effect)
      )

    case UpdatePauseHoursBetweenStart(newValue) =>
      Tauri.update_setting("indexer_pause_hours_between_start", newValue.toString,
        effect => updated(value.copy(pauseHoursBetweenStart = newValue), effect)
      )

    case UpdatePauseHoursBetweenEnd(newValue) =>
      Tauri.update_setting("indexer_pause_hours_between_end", newValue.toString,
        effect => updated(value.copy(pauseHoursBetweenEnd = newValue), effect)
      )
  }
}