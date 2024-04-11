package com.harana.search.client.icons.developer

import slinky.web.svg._

object RubygemsIcon {

  def apply() =
    svg(viewBox := "0 0 512 512")(
      rect(fill := "#fff", height := "512", rx := "15%", width := "512"),
      g(fill := "#d6422b")(
        path(d := "m301 303.292 65.4-65.4-45.8-45.85v-.207h-130.07l.2.4-.2-.2-45 45.85 110.47 110.115"),
        path(d := "m256 69.704-162 92.94v185.879l162 92.94 162-92.94v-185.88zm131 261.057-131 75.589-131-75.59v-150.768l131-75.59 131 75")
      )
    )
}