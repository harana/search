package com.harana.search.client.main.ui

sealed trait Panel
object Panel {
  case object None extends Panel
  case object Search extends Panel
  case object Settings extends Panel
  case object Share extends Panel
  case object Welcome extends Panel
}
