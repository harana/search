package com.harana.search.client.settings.ui

import com.harana.search.client.Circuit
import com.harana.search.client.auth.ui.SignupPanel
import com.harana.search.client.settings.Section
import com.harana.search.client.settings.SettingsStore.{HideSettings, UpdateSelectedSection}
import com.harana.search.client.settings.ai.ui.AiPanel
import com.harana.search.client.settings.billing.ui.BillingPanel
import com.harana.search.client.settings.categories.ui.CategoriesPanel
import com.harana.search.client.settings.developer.ui.DeveloperPanel
import com.harana.search.client.settings.folders.ui.FoldersPanel
import com.harana.search.client.settings.general.ui.GeneralPanel
import com.harana.search.client.settings.indexing.ui.IndexingPanel
import com.harana.search.client.settings.integrations.ui.IntegrationPanel
import com.harana.search.client.settings.rules.ui.RulesPanel
import com.harana.web.external.tailwind.OutlineIcons._
import com.harana.web.external.tauri.Tauri.convertFileSrc
import slinky.core.annotations.react
import slinky.core.{CustomAttribute, FunctionalComponent}
import slinky.web.html._

import scala.scalajs.js

@react object SettingsPanel {

  val component = FunctionalComponent[Unit] { _ =>

    val navigationItems = List(
      ("General", "Description about general", PhotoOutlineIcon("text-gray-400"), Section.Appearance),
      ("Categories", "Description about categories", ListBulletOutlineIcon("text-gray-400"), Section.Categories),
      ("Folders", "Description about folders", FolderOpenOutlineIcon("text-gray-400"), Section.Folders),
      ("Indexing", "Description about indexing", CloudOutlineIcon("text-gray-400"), Section.Indexing),
      ("Billing", "Description about billing", CreditCardOutlineIcon("text-gray-400"), Section.Billing),
      ("Developer", "Description about developer", CreditCardOutlineIcon("text-gray-400"), Section.Developer),
    )

    val state = Circuit.state(_.settingsState, true)

    val drag = new CustomAttribute[Boolean]("data-tauri-drag-region")

    div(className := "flex min-h-[720px] bg-white rounded-xl")(
      div(className := "flex w-60 flex-col")(
        div(drag := true, className := "flex grow flex-col gap-y-5 overflow-y-auto border-r border-gray-200 bg-white px-6")(
          div(drag := true, className := "flex h-16 shrink-0 items-center")(
            a(onClick := (_ => Circuit.dispatch(HideSettings)))(XMarkOutlineIcon(className = "h-6 w-6 text-gray-400 right"))
          ),
          nav(className := "flex flex-1 flex-col")(
            ul(drag := true, role := "list", className := "flex flex-1 flex-col gap-y-7")(
              li(
                ul(drag := true, role := "list", className := "-mx-2 space-y-1")(
                  navigationItems.map (item => {
                    val selectedClass = if (state.selectedSection == item._4) "text-emerald-600 bg-gray-50" else "text-gray-700"

                    li(key := item._1)(
                      a(href := "#", onClick := (_ => Circuit.dispatch(UpdateSelectedSection(item._4))), className := s"$selectedClass hover:text-emerald-600 hover:bg-gray-50 group flex gap-x-3 rounded-md p-2 cursor-default select-none text-sm leading-6 font-semibold")(
                        span(className := "mt-2 flex h-5 w-5 shrink-0", style := js.Dynamic.literal("marginTop" -> "1.5px"))(
                          item._3
                        ),
                        span(className := "truncate")(item._1)
                      )
                    )
                  })
                )
              ),
//              li(
//                div(className := "text-xs font-semibold leading-6 text-gray-400")("harana+"),
//                ul(drag := true, role := "list", className := "-mx-2 mt-2 space-y-1")(
//                  li(
//                    a(href := "#", onClick := (_ => Circuit.dispatch(UpdateSelectedSection(Section.Upgrade))), className := "text-gray-700 hover:text-indigo-600 hover:bg-gray-50 group flex gap-x-3 rounded-md p-2 text-sm leading-6 font-semibold")(
//                      span(className := "mt-2 flex h-5 w-5 shrink-0", style := js.Dynamic.literal("marginTop" -> "1.5px"))(
//                        RocketLaunchOutlineIcon("text-gray-400")
//                      ),
//                      span(className := "truncate")("Upgrade")
//                    ),
//                  ),
//                  li(
//                    a(href := "#", onClick := (_ => Circuit.dispatch(UpdateSelectedSection(Section.AI))), className := "text-gray-700 hover:text-indigo-600 hover:bg-gray-50 group flex gap-x-3 rounded-md p-2 text-sm leading-6 font-semibold")(
//                      span(className := "mt-2 flex h-5 w-5 shrink-0", style := js.Dynamic.literal("marginTop" -> "1.5px"))(
//                        CpuChipOutlineIcon("text-gray-400")
//                      ),
//                      span(className := "truncate")("AI Models")
//                    ),
//                  ),
//                  li(
//                    a(href := "#", onClick := (_ => Circuit.dispatch(UpdateSelectedSection(Section.Rules))), className := "text-gray-700 hover:text-indigo-600 hover:bg-gray-50 group flex gap-x-3 rounded-md p-2 text-sm leading-6 font-semibold")(
//                      span(className := "mt-2 flex h-5 w-5 shrink-0", style := js.Dynamic.literal("marginTop" -> "1.5px"))(
//                        QueueListOutlineIcon("text-gray-400")
//                      ),
//                      span(className := "truncate")("Rules")
//                    ),
//                  )
//                )
//              )
            )
          )
        )
      ),
      if (state.selectedSection == Section.Upgrade)
        main(drag := true, className := "w-full")(
          SignupPanel()
        )
      else
        main(drag := true, className := "bg-gray-50 py-12 lg:pl-72 w-full")(
          div(className := "px-10")(
            state.selectedSection match {
              case Section.Appearance => GeneralPanel()
              case Section.AI => AiPanel()
              case Section.Billing => BillingPanel()
              case Section.Categories => CategoriesPanel()
              case Section.Developer => DeveloperPanel()
              case Section.Folders => FoldersPanel()
              case Section.Indexing => IndexingPanel()
              case Section.Rules => RulesPanel()
              case Section.Integration(_) => IntegrationPanel()
            }
          )
        )
    )
  }
}
