package com.harana.search.client.icons.developer

import slinky.web.svg._

object RacketIcon {

  def apply() =
    svg(viewBox := "0 0 32 32")(
      circle(cx := "16", cy := "16", fill := "#fff", r := "14"),
      path(d := "m27.016 24.641a14 14 0 0 0 -15.8-21.8c5.684 2.981 13.197 12.708 15.8 21.8z", fill := "#3e5ba9"),
      g(fill := "#9f1d20")(
        path(d := "m13.995 10.93a24.3 24.3 0 0 0 -7.22-5.46 14 14 0 0 0 -1.312 19.747 39.56 39.56 0 0 1 8.532-14.287z"),
        path(d := "m16.575 14.1a32.645 32.645 0 0 0 -7.145 14.265 14.016 14.016 0 0 0 13.3-.089 38.642 38.642 0 0 0 -6.155-14.176z")
      )
    )
}