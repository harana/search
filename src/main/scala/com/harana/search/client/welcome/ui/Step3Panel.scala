package com.harana.search.client.welcome.ui

import com.harana.search.client.welcome.WelcomeStore.{CompleteOnboarding, UpdateSelectedStep}
import com.harana.web.external.tailwind.OutlineIcons._
import diode.ActionBatch
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

@react object Step3Panel {

  type Props = Unit

  val iconCls = "w-50 text-gray-600 mt-1"

  def todayItems = List(
    ("File Searching", DocumentMagnifyingGlassOutlineIcon(iconCls), "Locates files using names or content, enabling quick and efficient retrieval."),
    ("Metadata Extraction", FilmOutlineIcon(iconCls), "Extracts essential information from files, such as creator and date, for organization."),
    ("Thumbnail Generation", PhotoOutlineIcon(iconCls), "Generates small preview images from files for easy visual identification.")
  )

  def laterItems = List(
    ("Speech Recognition", SpeakerWaveOutlineIcon(iconCls), "Transforms spoken words within audio files into editable, searchable text."),
    ("Object Recognition", ViewfinderCircleOutlineIcon(iconCls), "Identifies and labels objects in images or videos, simplifying searches."),
    ("Text Recognition", DocumentTextOutlineIcon(iconCls), "Converts text found in images into digital text for easy access."),
  )

  val component = FunctionalComponent[Unit] { _ =>
    div(
      p(className := titleCls)("What to expect over the coming days."),
      div(className := "grid grid-cols-2 gap-6 pr-8 mb-6")(
        div(
          p(className := "mt-1 mb-2 text-sm font-bold leading-8 text-gray-800")("Today"),
          todayItems.map { item => iconRow(item._1, item._2, item._3) },
        ),
        div(
          p(className := "mt-1 mb-2 text-sm font-bold leading-8 text-gray-800")("Later"),
          laterItems.map { item => iconRow(item._1, item._2, item._3) }
        )
      ),
      continueButton(
        ActionBatch(
          CompleteOnboarding,
          UpdateSelectedStep(4)
        )
      )
    )
  }

  def iconRow(title: String, icon: ReactElement, description: String) =
    span(className := "flex items-start gap-x-6 mb-6")(
      icon,
      div(
        div(className := "text-sm font-small leading-6 text-gray-900")(title),
        div(className := "text-xs mt-1 text-gray-500")(description),
      )
    )
}