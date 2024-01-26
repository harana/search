package com.harana.search.client.settings.general.ui

import com.harana.search.client.Circuit
import com.harana.search.client.settings.general.GeneralStore.{UpdateAppearanceShortcutKeyFirst, UpdateAppearanceShortcutKeySecond, UpdateAppearanceShortcutKeyThird}
import com.harana.web.components.when
import com.harana.web.external.tailwind.SolidIcons.{CheckIcon, ChevronUpDownIcon}
import com.harana.web.external.tailwind.listbox.{Listbox => TwListbox, ListboxButton => TwListboxButton, ListboxLabel => TwListboxLabel, ListboxOption => TwListboxOption, ListboxOptions => TwListboxOptions}
import com.harana.web.external.tailwind.transition.Transition
import slinky.core.{FunctionalComponent, StatelessComponent}
import slinky.core.annotations.react
import slinky.core.facade.Fragment
import slinky.web.html._

import scala.scalajs.js

@react object ShortcutPicker {

  type Props = Unit

  val macFirstCommandTypes = List("-", "Command", "Control", "Option")
  val macSecondCommandTypes = List("-", "Command", "Shift", "Control", "Option")
  val winFirstCommandTypes = List("-", "Alt", "Control", "Option", "Shift", "Windows")
  val winSecondCommandTypes = List("-", "Command", "Control", "Option", "Shift")
  val thirdCommandTypes = List("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
    "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
    "`", "Plus", "Space", "Tab", "Backspace", "Delete", "Insert", "Return",
    "Arrow Up", "Arrow Down", "Arrow Left", "Arrow Right", "Home", "End",
    "Page Up", "Page Down", "Escape")

  val component = FunctionalComponent[Unit] { _ =>
    val state = Circuit.state(_.generalState, true)

    div(className := "pb-3")(
      span(className := "block text-sm font-medium leading-6 text-gray-900")("Shortcut"),
      div(className := "grid grid-cols-3 gap-x-2")(
        div(className := "sm:col-span-1")(
          dropdown(macFirstCommandTypes, state.appearanceShortcutKeyFirst, onChange = value => Circuit.dispatch(UpdateAppearanceShortcutKeyFirst(value.toString))),
        ),
        div(className := "sm:col-span-1")(
          dropdown(macSecondCommandTypes, state.appearanceShortcutKeySecond, onChange = value => Circuit.dispatch(UpdateAppearanceShortcutKeySecond(value.toString))),
        ),
        div(className := "sm:col-span-1")(
          dropdown(thirdCommandTypes, state.appearanceShortcutKeyThird, onChange = value => Circuit.dispatch(UpdateAppearanceShortcutKeyThird(value.toString))),
        )
      )
    )
  }

  private def dropdown(items: List[String], selectedItem: String, onChange: js.Any => Unit) =
    TwListbox(value = selectedItem, onChange = onChange, children = (listboxValue: js.Dynamic) =>
      Fragment(
        div(className := "relative")(
          TwListboxButton(className = "relative w-full cursor-default rounded-md bg-white py-1.5 pl-3 pr-10 text-left text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 focus:outline-none focus:ring-2 focus:ring-indigo-600 sm:text-sm sm:leading-6")(
            span(className := "block truncate")(selectedItem),
            span(className := "pointer-events-none absolute inset-y-0 right-0 flex items-center pr-2")(
              ChevronUpDownIcon(Some("h-5 w-5 text-gray-400"))
            )
          ),
          Transition(
            show = listboxValue.open.toString == "true",
            as = Fragment.component,
            leave = "transition ease-in duration-100",
            leaveFrom = "opacity-100",
            leaveTo = "opacity-0"
          )(
            TwListboxOptions(className = "absolute z-10 mt-1 max-h-60 w-full overflow-auto rounded-md bg-white py-1 text-base shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none sm:text-sm")(
              items.map { item =>
                TwListboxOption(
                  key = item,
                  className = (value: js.Dynamic) => {
                    val active = value.active.toString == "true"
                    s"${if (active) "bg-indigo-600 text-white" else "text-gray-900"} relative cursor-default select-none py-2 pl-3 pr-9"
                  },
                  value = item,
                  children = (optionValue: js.Dynamic) => {
                    val selected = optionValue.selected.toString == "true"
                    val active = optionValue.active.toString == "true"

                    Fragment(
                      span(className := s"${if (selected) "font-semibold" else "font-normal"} block truncate")(item),
                      when(selected)(
                        span(className := s"${if (active) "text-white" else "text-indigo-600"} absolute inset-y-0 right-0 flex items-center pr-4")(
                          CheckIcon("h-5 w-5")
                        )
                      )
                    )
                  }
                )
              }
            )
          )
        )
      )
    )
}