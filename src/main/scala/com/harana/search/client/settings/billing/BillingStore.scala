package com.harana.search.client.settings.billing

import com.harana.search.client.models._
import diode.{Action => DiodeAction}

object BillingStore {

  case class State(editingDetails: Boolean,
                   invoices: List[Invoice],
                   cardNumber: String,
                   cardExpiry: String,
                   cardCVC: String,
                   addressCountry: String,
                   addressPostalCode: String,
                   contactFullName: String,
                   contactEmail: String)

  val initialState = State(false, List(), "", "", "", "", "", "", "")

  case object SaveDetails extends DiodeAction

  case class UpdateEditingDetails(editing: Boolean) extends DiodeAction
  case class UpdateInvoices(invoices: List[Invoice]) extends DiodeAction
  case class UpdateCardNumber(number: String) extends DiodeAction
  case class UpdateCardExpiry(expiry: String) extends DiodeAction
  case class UpdateCardCVC(cvc: String) extends DiodeAction
  case class UpdateAddressCountry(country: String) extends DiodeAction
  case class UpdateAddressPostalCode(postalCode: String) extends DiodeAction
  case class UpdateContactFullName(fullName: String) extends DiodeAction
  case class UpdateContactEmail(email: String) extends DiodeAction

}