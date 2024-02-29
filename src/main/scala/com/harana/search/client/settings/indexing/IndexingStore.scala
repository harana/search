package com.harana.search.client.settings.indexing

import com.harana.search.client.models._
import diode.{Action => DiodeAction}

object IndexingStore {

  case class State(indexerStatuses: List[IndexerStatus],
                   overallProgress: Int,
                   pauseAcPowerRequired: Boolean,
                   pauseBatteryLifeRemainingEnabled: Boolean,
                   pauseBatteryLifeRemainingValue: Int,
                   pauseCpuMaximumTemperatureEnabled: Boolean,
                   pauseCpuMaximumTemperatureValue: Int,
                   pauseCpuMaximumUtilisationEnabled: Boolean,
                   pauseCpuMaximumUtilisationValue: Int,
                   pauseHoursBetweenEnabled: Boolean,
                   pauseHoursBetweenStart: Int,
                   pauseHoursBetweenEnd: Int)

  val initialState = State(List(), 0, true, true, 10, true, 100, true, 100, true, 0, 0)

  case class UpdateIndexerStatuses(statuses: List[IndexerStatus]) extends DiodeAction
  case class UpdateOverallProgress(progress: Int) extends DiodeAction

  case class UpdatePauseAcPowerRequired(enabled: Boolean) extends DiodeAction

  case class UpdatePauseBatteryLifeRemainingEnabled(enabled: Boolean) extends DiodeAction
  case class UpdatePauseBatteryLifeRemainingValue(value: Int) extends DiodeAction

  case class UpdatePauseCpuMaximumTemperatureEnabled(enabled: Boolean) extends DiodeAction
  case class UpdatePauseCpuMaximumTemperatureValue(value: Int) extends DiodeAction

  case class UpdatePauseCpuMaximumUtilisationEnabled(enabled: Boolean) extends DiodeAction
  case class UpdatePauseCpuMaximumUtilisationValue(value: Int) extends DiodeAction

  case class UpdatePauseHoursBetweenEnabled(enabled: Boolean) extends DiodeAction
  case class UpdatePauseHoursBetweenStart(value: Int) extends DiodeAction
  case class UpdatePauseHoursBetweenEnd(value: Int) extends DiodeAction
}