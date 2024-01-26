package com.harana.search.client.search.ui

import com.harana.search.client.Circuit
import com.harana.search.client.cards.CardPanel
import com.harana.search.client.search.SearchStore._
import com.harana.search.client.search.ui.rows.{DocumentRow, IntegrationRow}
import com.harana.search.client.{Tauri => SearchTauri}
import com.harana.web.components.when
import com.harana.web.external.tailwind.OutlineIcons._
import com.harana.web.external.tailwind.SolidIcons._
import com.harana.web.external.tailwind.dialog._
import com.harana.web.external.tailwind.popover._
import com.harana.web.external.tailwind.transition.{Transition, TransitionChild}
import com.harana.web.external.tauri.Tauri
import com.harana.web.external.virtuoso.{Style, Virtuoso}
import diode.ActionBatch
import org.scalajs.dom._
import slinky.core.annotations.react
import slinky.core.facade.Hooks.useEffect
import slinky.core.facade.{Fragment, React}
import slinky.core.{CustomAttribute, FunctionalComponent}
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

@react object SearchPanel {
  type Props = Unit

  val documentsRef = React.createRef[Virtuoso.RefType]
  val integrationsRef = React.createRef[Virtuoso.RefType]
  val inputRef = React.createRef[HTMLInputElement]

  val component = FunctionalComponent[Unit] { _ =>

    val authState = Circuit.state(_.authState, true)
    val state = Circuit.state(_.searchState, true)
    val systemState = Circuit.state(_.systemState, true)

    useEffect(
      () => {
        val keyDownListener = (e: KeyboardEvent) => Circuit.dispatch(KeyDown(e.keyCode, e))
        val keyUpListener = (e: KeyboardEvent) => Circuit.dispatch(KeyUp(e.keyCode, e))

        window.addEventListener("keydown", keyDownListener, false)
        window.addEventListener("keyup", keyUpListener, false)
        window.onblur = (_: FocusEvent) =>
          Circuit.dispatch(Hide)

        window.onfocus = (_: FocusEvent) =>
          Circuit.dispatch(
            ActionBatch(
              UpdateFocusedPanel(Panel.Search),
              UpdateSelectedIntegration(None),
              UpdateSelectedDocument(None)
            )
          )

        () => {
          window.removeEventListener("keydown", keyDownListener, false)
          window.removeEventListener("keyup", keyUpListener, false)
        }
      },
      Seq.empty
    )

    Tauri.invoke("update_window_size", Map("width" -> 950.0, "height" -> (if (state.searchResults.nonEmpty) 466.0 else 58.0)).toJSDictionary)

    val settingGroups = List(
      List(
        ("Settings", "Description about settings", ShowSettings, "bg-gray-200", PhotoOutlineIcon())
      ),
      List(
        ("Support", "Description about support", ShowSupport, "bg-gray-200", QuestionMarkCircleOutlineIcon()),
        ("Feedback", "Description about support", ShowFeedback, "bg-gray-200", ChatBubbleLeftEllipsisOutlineIcon())
      ),
      if (authState.loggedIn)
        List(
          ("Billing", "Description about billing", ShowBilling, "bg-gray-200", CreditCardOutlineIcon()),
          ("Logout", "Description about logout", ShowLogin, "bg-gray-200", ArrowRightStartOnRectangleIcon()),
        )
      else
        List(
          ("Login", "Description about logout", ShowLogin, "bg-gray-200", ArrowRightEndOnRectangleIcon()),
          ("Free Trial of Harana+", "350+ integrations, AI indexing and more.", ShowHaranaPlus, "bg-emerald-300", PlusIcon())
        )
    )

    val popoverPanel =
      PopoverPanel(className = "absolute settings-popover z-100 mt-3 w-screen max-w-sm -translate-x-1/2 transform px-4 sm:px-0 lg:max-w-3xl shadow-2xl")(
        div(className := "overflow-hidden rounded-lg shadow-lg ring-1 ring-black ring-opacity-5")(
          div(className := "relative grid gap-8 bg-white p-7 lg:grid-cols-2")(
            settingGroups.map { settingGroup =>
              settingGroup.map { setting =>
                a(onClick := (_ => Circuit.dispatch(setting._3)), key := setting._1, className := "-m-3 flex items-center rounded-lg p-2 transition duration-150 ease-in-out hover:bg-gray-50 focus:outline-none focus-visible:ring focus-visible:ring-orange-500 focus-visible:ring-opacity-50 divide-gray-200 select-none cursor-pointer")(
                  div(className := s"flex h-10 w-10 flex-none items-center justify-center rounded-lg ${setting._4}")(
                    div(className := "h-6 w-6 text-gray-700")(setting._5)
                  ),
                  div(className := "ml-4 flex-auto")(
                    p(className := "text-sm font-medium text-gray-900")(setting._1),
                    p(className := "text-sm text-gray-500")(setting._2)
                  )
                )
              }
            }
          )
        )
      )

    val popoverTransition =
      Transition(
        as = Fragment.component,
        enter = "transition ease-out duration-200", enterFrom = "opacity-0 translate-y-1", enterTo = "opacity-100 translate-y-0",
        leave = "transition ease-in duration-150", leaveFrom = "opacity-100 translate-y-0", leaveTo = "opacity-0 translate-y-1"
      )

    val dragRegionAttr = new CustomAttribute[Boolean]("data-tauri-drag-region")

    Transition(show = true, as = Fragment.component, appear = true)(
      Dialog(as = "div", className = "relative z-10", onClose = (closing: Boolean) => println("Closing"))(
        TransitionChild(
          as = Fragment.component,
          enter = "ease-out duration-300", enterFrom = "opacity-0", enterTo = "opacity-100",
          leave = "ease-in duration-200", leaveFrom = "opacity-100", leaveTo = "opacity-0"
        )(
          div(className := "fixed inset-0 bg-gray-500 bg-opacity-0 transition-opacity")
        ),
        div(className := "fixed inset-0 z-10 overflow-y-auto")(
          TransitionChild(
            as = Fragment.component,
            enter = "ease-out duration-300", enterFrom = "opacity-0 scale-95", enterTo = "opacity-100 scale-100",
            leave = "ease-in duration-200", leaveFrom = "opacity-100 scale-100", leaveTo = "opacity-0 scale-95"
          )(
            DialogPanel(className := "mx-auto w-full overflow-auto transform divide-y divide-gray-100 rounded-xl bg-white bg-opacity-70 transition-all")(
              Popover()(
                popoverTransition(popoverPanel),
                div(className := "relative", dragRegionAttr := true)(
                  MagnifyingGlassIcon("pointer-events-none absolute left-4 mt-half top-4 h-5 w-5 text-gray-400"),

                  input(
                    className := "h-14 w-350 search-input border-0 bg-transparent ml-10 text-gray-900 placeholder:text-gray-400 focus:ring-0 sm:text-md",
                    placeholder := "Search...",
                    autoComplete := "false",
                    ref := inputRef,
                    spellCheck := false,
                    onClick := { _ => Circuit.dispatch(SearchFocused) },
                    onChange := { e =>
                      val value = e.target.asInstanceOf[js.Dynamic].value.asInstanceOf[String]
                      Circuit.dispatch(Search(if (value.isEmpty) None else Some(value)))
                    }
                  ),
                  ApplicationHint(),
                  when(state.searchResults.nonEmpty) {
                    PopoverButton(
                      onClick = () => Tauri.invoke("update_window_size", Map("width" -> 950.0, "height" -> 680.0).toJSDictionary),
                      className = "absolute right-4 top-4 h-6 w-5 text-gray-400")(
                      Bars3Icon()
                    )
                  }
                ),

                // Integrations
                when(state.searchResults.nonEmpty)(
                  div(className := "h-410 flex divide-x divide-gray-100 text-gray-700 text-sm overflow-y-auto")(
                    div(dragRegionAttr := true, className := s"flex-auto mw-250 mxw-250 scroll-py-4 pb-3")(
                      Virtuoso(
                        className = "search-virtuoso",
                        data = state.searchResults,
                        itemContent = (index: Int) =>
                          IntegrationRow(
                            integration = state.integrations.find(_.id == state.searchResults(index)._1).get,
                            active = state.selectedIntegration.nonEmpty && state.selectedIntegration.get.equals(state.searchResults(index)._1),
                            systemState.appAssetsUrl
                          ),
                        style = new Style {
                          override val height: String = s"100%"
                        }
                      ).withRef(integrationsRef)
                    ),

                    // Documents
                    div(className := "mw-325 flex-none flex-col divide-y sm:flex pb-3")(
                      div(dragRegionAttr := true, className := "flex-auto") {
                        val documents = state.selectedIntegration.flatMap(integration => state.searchResults.find(_._1.equals(integration)))

                        when(documents.nonEmpty)(
                          Virtuoso(
                            className = "search-virtuoso",
                            data = documents.get._2,
                            itemContent = (index: Int) => {
                              val currentDocument = documents.get._2(index)
                              val active = state.selectedDocumentId.nonEmpty && state.selectedDocumentId.get.equals(currentDocument.id)
                              DocumentRow(currentDocument, active, systemState.appAssetsUrl)
                            },
                            style = new Style {
                              override val height: String = s"100%"
                            }
                          ).withRef(documentsRef)
                        )
                      }
                    ),

                    // Cards
                    div(dragRegionAttr := true, className := "text-md mw-350 h-750 pl-3 flex-none flex-col items-center divide-y divide-gray-100 overflow-y-auto sm:flex")(
                      CardPanel()
                    )
                  )
                ),
                when(state.errorMessage.isDefined)(
                  div(className := "error-bar relative", dragRegionAttr := true)(
                    state.errorMessage.get
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
