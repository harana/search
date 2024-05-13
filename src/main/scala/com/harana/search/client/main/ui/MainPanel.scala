package com.harana.search.client.main.ui

import com.harana.search.client.Circuit
import com.harana.search.client.main.MainStore.{KeyDown, KeyUp}
import com.harana.search.client.search.SearchStore.{Hide, ShowSettings, ShowSupport}
import com.harana.search.client.search.ui.SearchPanel
import com.harana.search.client.share.ui.SharePanel
import com.harana.search.client.welcome.ui.WelcomePanel
import com.harana.web.external.tailwind.OutlineIcons._
import com.harana.web.external.tailwind.dialog._
import com.harana.web.external.tailwind.popover._
import com.harana.web.external.tailwind.transition.{Transition, TransitionChild}
import org.scalajs.dom.{FocusEvent, KeyboardEvent, window}
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.Fragment
import slinky.core.facade.Hooks.useEffect
import slinky.web.html._

@react object MainPanel {
  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    useEffect(
      () => {
        val keyDownListener = (e: KeyboardEvent) => Circuit.dispatch(KeyDown(e.keyCode, e))
        val keyUpListener = (e: KeyboardEvent) => Circuit.dispatch(KeyUp(e.keyCode, e))
        val blurListener = (_: FocusEvent) => if (!Circuit.state(_.systemState, false).isDebug) Circuit.dispatch(Hide)

        window.addEventListener("keydown", keyDownListener, true)
        window.addEventListener("keyup", keyUpListener, true)
        window.addEventListener("blur", blurListener, true)

        () => {
          window.removeEventListener("keydown", keyDownListener, false)
          window.removeEventListener("keyup", keyUpListener, false)
          window.removeEventListener("blur", blurListener, false)
        }
      },
      Seq.empty
    )
    val settingGroups = List(
      List(
        ("Settings", "", ShowSettings, "bg-gray-200", PhotoOutlineIcon())
      ),
      List(
        ("Support", "", ShowSupport, "bg-gray-200", QuestionMarkCircleOutlineIcon()),
      ),
      //      if (authState.loggedIn)
      //        List(
      //          ("Billing", "Description about billing", ShowBilling, "bg-gray-200", CreditCardOutlineIcon()),
      //          ("Logout", "Description about logout", ShowLogin, "bg-gray-200", ArrowRightStartOnRectangleIcon()),
      //        )
      //      else
      //        List(
      //          ("Login", "Description about logout", ShowLogin, "bg-gray-200", ArrowRightEndOnRectangleIcon()),
      //          ("Free Trial of Harana+", "350+ integrations, AI indexing and more.", ShowHaranaPlus, "bg-emerald-300", PlusIcon())
      //        )
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

    val activePanel = Circuit.state(_.mainState, true).activePanel
    println("ACTIVE PANEL = " + activePanel)

    if (activePanel == Panel.Welcome) {
      WelcomePanel()
    } else {
      Transition(show = true, as = Fragment.component, appear = true)(
        Dialog(as = "div", className = "mb-1 relative z-10", onClose = (_: Boolean) => {})(
          TransitionChild(
            as = Fragment.component,
            enter = "ease-out duration-300", enterFrom = "opacity-0", enterTo = "opacity-100",
            leave = "ease-in duration-200", leaveFrom = "opacity-100", leaveTo = "opacity-0"
          )(
            div(className := "fixed inset-0 bg-gray-500 bg-opacity-0 transition-opacity")
          ),
          div(className := "fixed inset-0 z-10 overflow-y-hidden")(
            TransitionChild(
              as = Fragment.component,
              enter = "ease-out duration-300", enterFrom = "opacity-0 scale-95", enterTo = "opacity-100 scale-100",
              leave = "ease-in duration-200", leaveFrom = "opacity-100 scale-100", leaveTo = "opacity-0 scale-95"
            )(
              DialogPanel(className := "border border-gray-300 mx-auto w-full overflow-auto transform divide-y divide-gray-100 rounded-xl bg-white bg-opacity-70 transition-all")(
                Popover()(
                  popoverTransition(popoverPanel),
                  div(
                    activePanel match {
                      case Panel.Search => SearchPanel()
                      case Panel.Share => SharePanel()
                      case _ => div()
                    }
                  )
                )
              )
            )
          )
        )
      )
    }
  }
}