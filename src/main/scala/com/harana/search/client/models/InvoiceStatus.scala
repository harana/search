package com.harana.search.client.models

import enumeratum._

sealed trait InvoiceStatus extends EnumEntry
case object InvoiceStatus extends Enum[InvoiceStatus] with CirceEnum[InvoiceStatus] {
  case object Unpaid extends InvoiceStatus
  case object Overdue extends InvoiceStatus
  case object Paid extends InvoiceStatus

  val values = findValues
}