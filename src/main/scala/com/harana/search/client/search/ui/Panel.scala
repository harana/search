package com.harana.search.client.search.ui

sealed trait Panel
object Panel {
  case object Search extends Panel
  case object Integration extends Panel
  case object Document extends Panel
  case object Cards extends Panel
}
