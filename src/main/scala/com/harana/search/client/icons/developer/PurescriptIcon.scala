package com.harana.search.client.icons.developer

import slinky.web.svg._

object PurescriptIcon {

  def apply() =
    svg(viewBox := "0 0 32 32")(
      path(d := "m0 0h32v32h-32z", fill := "#16171b"),
      g(fill := "#fff")(
        path(d := "m21.892 22.136-2.186-2.041h-9.599l2.186 2.041z"),
        path(d := "m12.293 14.98-2.186 2.041h9.599l2.186-2.041z"),
        path(d := "m21.891 11.906-2.185-2.042h-9.599l2.186 2.042z"),
        path(d := "m9.1 13.926-1.448-1.444-5.352 5.354a1.023 1.023 0 0 0 0 1.443l5.354 5.354 1.446-1.443-4.636-4.632z"),
        path(d := "m29.7 12.721-5.352-5.355-1.448 1.444 4.63 4.632-4.63 4.633 1.443 1.443 5.357-5.353a1.021 1.021 0 0 0 0-1.444z"),
      )
    )

}