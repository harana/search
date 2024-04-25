package com.harana.search.client.welcome

import com.harana.search.client.Circuit
import com.harana.web.components
import com.harana.web.external.tailwind.{Button, ButtonSize}
import diode.Action
import slinky.web.html.{className, div, style}

package object ui {

  val titleCls = "mt-4 mb-6 text-lg leading-7 text-gray-500"

  def continueButton(action: Action) =
    div(className := "fixed bottom-0 pb-8", style := components.literal("marginLeft" -> "150px"))(
      Button(
        label = Some("Continue"),
        size = ButtonSize.Large,
        textColor = "text-white",
        backgroundColor = "bg-teal-600",
        hoverColor = "bg-teal-500",
        className = Some("rounded-md"),
        onClick = () => Circuit.dispatch(action)
      )
    )
}