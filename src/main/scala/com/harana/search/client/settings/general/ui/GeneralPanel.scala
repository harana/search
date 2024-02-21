package com.harana.search.client.settings.general.ui

import com.harana.search.client.Circuit
import com.harana.search.client.models.Theme
import com.harana.search.client.settings.general.GeneralStore._
import com.harana.web.external.tailwind._
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => css}

@react object GeneralPanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.generalState, true)

    val macFirstCommandTypes = List("-", "Command", "Control", "Option")
    val macSecondCommandTypes = List("-", "Command", "Control", "Option")
    val winFirstCommandTypes = List("-", "Alt", "Control", "Option", "Shift", "Windows")
    val winSecondCommandTypes = List("-", "Command", "Control", "Option", "Shift")
    val thirdCommandTypes = List("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                                 "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                                 "`", "Plus", "Space", "Tab", "Backspace", "Delete", "Insert", "Return",
                                 "Arrow Up", "Arrow Down", "Arrow Left", "Arrow Right", "Home", "End",
                                 "Page Up", "Page Down", "Escape")

    div(className := "grid grid-cols-5 gap-x-10 gap-y-8")(
      div(className := "col-span-3")(
        div(className := "mb-2")(Heading("Appearance")),
        div(className := "py-2")(
//          ShortcutPicker(),
          Listbox(
            "appearance_language",
            selectedItem = state.appearanceLanguage,
            items = List("English"),
            itemId = item => item.toString,
            itemTitle = item => item.toString,
            label = Some("Language"),
            onChange = item => Circuit.dispatch(UpdateAppearanceLanguage(item.toString)),
            className = "py-3"
          ),
          Listbox(
            "appearance_font_size",
            selectedItem = state.appearanceFontSize.toString,
            items = List("14"),
            itemId = item => item.toString,
            itemTitle = item => item.toString,
            label = Some("Font Size"),
            onChange = item => Circuit.dispatch(UpdateAppearanceFontSize(item.toString.toInt)),
            className = "py-3"
          ),
          Listbox(
            "appearance_theme",
            selectedItem = state.appearanceTheme.entryName,
            items = List("Light").map(_.asInstanceOf[js.Any]),
            itemId = item => item.toString,
            itemTitle = item => item.toString,
            label = Some("Theme"),
            onChange = item => Circuit.dispatch(UpdateAppearanceTheme(Theme.withName(item.toString))),
            className = "pt-3"
          )
        ),
        Table(
          name = "general_appearance",
          headers = List("Switch"),
          rows = List(
            List(Switch("always_center_window", Some("Always Center Window"), state.appearanceAlwaysCenterWindow, _ => Circuit.dispatch(UpdateAppearanceAlwaysCenterWindow(!state.appearanceAlwaysCenterWindow)), "px-4 py-2"))
          )
        )
      ),
       div(className := "col-span-2")(
         div(className := "mb-2")(Heading("Startup")),
         Table(
           name = "general_startup",
           headers = List("Switch"),
           rows = List(
             List(Switch("start_at_login", Some("Start at Login"), state.startupStartAtLogin, _ => Circuit.dispatch(UpdateStartupStartAtLogin(!state.startupStartAtLogin)), "px-4 py-2")),
           )
         ),
         div(className := "mb-2", style := css("paddingTop" -> "40px"))(Heading("Privacy")),
         Table(
           name = "general_privacy",
           headers = List("Switch"),
           rows = List(
             List(Switch("share_error_reports", Some("Share Error Reports"), state.privacyShareErrorReports, _ => Circuit.dispatch(UpdatePrivacyShareErrorReports(!state.privacyShareErrorReports)), "px-4 py-2")),
           )
         )
       )
    )
  }
}
