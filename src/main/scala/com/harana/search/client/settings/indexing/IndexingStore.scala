package com.harana.search.client.settings.indexing

import com.harana.search.client.models._
import diode.{Action => DiodeAction}

object IndexingStore {

  case class State(indexerStatuses: List[IndexerStatus],
                   overallProgress: Int,
                   pauseCpuTemperatureEnabled: Boolean,
                   pauseCpuTemperatureValue: Int,
                   pauseCpuUtilisationEnabled: Boolean,
                   pauseCpuUtilisationValue: Int,
                   pauseHoursBetweenEnabled: Boolean,
                   pauseHoursBetweenStart: Int,
                   pauseHoursBetweenEnd: Int)

  val initialState = State(List(), 0, true, 100, true, 100, true, 0, 0)

  case class UpdateIndexerStatuses(statuses: List[IndexerStatus]) extends DiodeAction
  case class UpdateOverallProgress(progress: Int) extends DiodeAction
  case class UpdatePauseCpuTemperatureEnabled(enabled: Boolean) extends DiodeAction
  case class UpdatePauseCpuTemperatureValue(value: Int) extends DiodeAction
  case class UpdatePauseCpuUtilisationEnabled(enabled: Boolean) extends DiodeAction
  case class UpdatePauseCpuUtilisationValue(value: Int) extends DiodeAction
  case class UpdatePauseHoursBetweenEnabled(enabled: Boolean) extends DiodeAction
  case class UpdatePauseHoursBetweenStart(value: Int) extends DiodeAction
  case class UpdatePauseHoursBetweenEnd(value: Int) extends DiodeAction
}