package com.harana.search.client.settings

sealed trait Section
object Section {
  case object AI extends Section
  case object Billing extends Section
  case object Categories extends Section
  case object Developer extends Section
  case object Folders extends Section
  case object General extends Section
  case object Indexing extends Section
  case object Rules extends Section
  case object Upgrade extends Section
  case class Integration(name: String) extends Section
}