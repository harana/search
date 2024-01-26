package com.harana.search.client.settings.billing

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.settings.billing.BillingStore._
import com.harana.web.actions.Init
import diode.ActionResult.NoChange
import diode._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

class BillingHandler extends ActionHandler(zoomTo(_.billingState)) {
  override def handle = {

    case Init(_) =>
      effectOnly(Tauri.list("list_invoices", list => UpdateInvoices(list)))

    case SaveDetails =>
      updated(value.copy(editingDetails = false))

    case UpdateEditingDetails(editing) =>
      updated(value.copy(editingDetails = editing))

    case UpdateInvoices(invoices) =>
      updated(value.copy(invoices = invoices))

    case UpdateCardNumber(number) =>
      updated(value.copy(cardNumber = number, editingDetails = true))

    case UpdateCardExpiry(expiry) =>
      updated(value.copy(cardExpiry = expiry, editingDetails = true))

    case UpdateCardCVC(cvc) =>
      updated(value.copy(cardCVC = cvc, editingDetails = true))

    case UpdateAddressCountry(country) =>
      updated(value.copy(addressCountry = country, editingDetails = true))

    case UpdateAddressPostalCode(postalCode) =>
      updated(value.copy(addressPostalCode = postalCode, editingDetails = true))

    case UpdateContactFullName(fullName) =>
      updated(value.copy(contactFullName = fullName, editingDetails = true))

    case UpdateContactEmail(email) =>
      updated(value.copy(contactEmail = email, editingDetails = true))

  }
}