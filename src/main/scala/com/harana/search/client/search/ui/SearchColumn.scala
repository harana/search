package com.harana.search.client.search.ui

sealed trait SearchColumn
object SearchColumn {
  case object Search extends SearchColumn
  case object Integration extends SearchColumn
  case object Document extends SearchColumn
  case object Cards extends SearchColumn
}
