package com.harana.search.client.integrations

sealed trait Section
object Section {
  case object Database extends Section
  case object eCommerce extends Section
  case object Finance extends Section
  case object News extends Section
  case object Other extends Section
  case object Product extends Section
  case object Productivity extends Section
  case object Sales extends Section
  case object Support extends Section
  case object Weather extends Section
}