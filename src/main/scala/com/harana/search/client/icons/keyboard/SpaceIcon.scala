package com.harana.search.client.icons.keyboard

import slinky.web.svg._

object SpaceIcon {

  def apply(iconClassName: String = "", iconHeight: String = "50px") =
    svg(className := iconClassName, viewBox := "0 0 801.9 139.05", height := iconHeight)(
      g(
        path(style := cls2, d := "M347.29-331.43h107.32c8.76,0,15.86,7.11,15.86,15.86V454.61c0,8.75-7.11,15.86-15.86,15.86h-107.33c-8.75,0-15.86-7.11-15.86-15.86V-315.56c0-8.76,7.11-15.86,15.86-15.86Z", transform := "translate(470.48 -331.43) rotate(90)"),
        path(style := cls1, d := "M15.86,2.7h770.18c7.26,0,13.16,5.9,13.16,13.16v107.32c0,7.26-5.9,13.16-13.16,13.16H15.86c-7.26,0-13.16-5.9-13.16-13.16V15.86c0-7.26,5.9-13.16,13.16-13.16Z")
      )
    )
}