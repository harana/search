package com.harana.search.client.icons.developer

import slinky.web.svg._

object HaskellIcon {

  def apply() =
      svg(viewBox := "0 0 17 12")(
        path(fill := "#453a62", d := "M 0 12 L 4 6 L 0 0 L 3 0 L 7 6 L 3 12"),
        path(fill := "#5e5086", d := "M 4 12 L 8 6 L 4 0 L 7 0 L 15 12 L 12 12 L 9.5 8.25 L 7 12"),
        path(fill := "#8f4e8b", d := "M 13.66 8.5 L 12.333 6.5 L 17 6.5 L 17 8.5 M 11.666 5.5 L 10.333 3.5 L 17 3.5 L 17 5.5"),
      )
}