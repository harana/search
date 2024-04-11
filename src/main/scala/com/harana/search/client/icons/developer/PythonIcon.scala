package com.harana.search.client.icons.developer

import slinky.web.svg._

object PythonIcon {

  def apply() =
    svg(viewBox := "0 0 32 32")(
      linearGradient(id := "a", gradientTransform := "matrix(189.38 0 0 189.81 25243.061 38519.17)", gradientUnits := "userSpaceOnUse", x1 := "-133.268", x2 := "-133.198", y1 := "-202.91", y2 := "-202.84")(
       stop(offset := "0", stopColor := "#387eb8"),
       stop(offset := "1", stopColor := "#366994"),
      ),
      linearGradient(id := "b", gradientTransform := "matrix(189.38 0 0 189.81 25309.061 38583.42)", gradientUnits := "userSpaceOnUse", x1 := "-133.575", x2 := "-133.495", y1 := "-203.203", y2 := "-203.133")(
       stop(offset := "0", stopColor := "#ffe052"),
       stop(offset := "1", stopColor := "#ffc331"),
      ),
      path(d := "m15.885 2.1c-7.1 0-6.651 3.07-6.651 3.07v3.19h6.752v1h-9.441s-4.545-.56-4.545 6.645 4.013 6.912 4.013 6.912h2.317v-3.361s-.13-4.013 3.9-4.013h6.762s3.772.06 3.772-3.652v-6.091s.572-3.712-6.842-3.712zm-3.732 2.137a1.214 1.214 0 1 1 -1.183 1.244v-.02a1.214 1.214 0 0 1 1.214-1.214z", fill := "url(#a)"),
      path(d := "m16.085 29.91c7.1 0 6.651-3.08 6.651-3.08v-3.18h-6.751v-1h9.47s4.545.508 4.545-6.655-4.013-6.912-4.013-6.912h-2.347v3.317s.13 4.013-3.9 4.013h-6.765s-3.775-.057-3.775 3.655v6.132s-.572 3.712 6.842 3.712h.04zm3.732-2.147a1.214 1.214 0 1 1 1.183-1.244v.03a1.214 1.214 0 0 1 -1.214 1.214h.03z", fill := "url(#b)"),
    )

}