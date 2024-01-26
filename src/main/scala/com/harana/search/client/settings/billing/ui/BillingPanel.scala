package com.harana.search.client.settings.billing.ui

import com.harana.search.client.Circuit
import com.harana.search.client.models.InvoiceStatus.{Overdue, Paid, Unpaid}
import com.harana.search.client.settings.billing.BillingStore._
import com.harana.web.components.when
import com.harana.web.external.tailwind.OutlineIcons._
import com.harana.web.external.tailwind._
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.{Fragment, ReactElement}
import slinky.web.html._

import scala.scalajs.js

@react object BillingPanel {

  type Props = Unit

  val component = FunctionalComponent[Unit] { _ =>

    val state = Circuit.state(_.billingState, true)

    div(className := "grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-10 md:col-span-2")(
      div(className := "sm:col-span-6")(
        div(className := "pb-4")(Heading("Plan")),

        ButtonCard(
          content =
            Fragment(
              h3(className := "text-semibold font-medium text-gray-900")("harana+"),
              dl(className := "mt-1 flex flex-grow flex-col justify-between")(
                dd(className := "text-sm text-gray-500")("$29 / month plan"),
                dd(className := "mt-3")(
                  span(className := "inline-flex items-center rounded-full bg-green-50 px-2 py-1 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20")("Active until 27 September")
                )
              )
            ),
          firstText = "Cancel",
          firstOnClick = () => (),
          className = Some("mb-8")
        ),
        div(style := js.Dynamic.literal("paddingBottom" -> "40px"))(
          div(className := "left")(Heading("Billing")),

          when(state.editingDetails)(
            div(
              Button(
                label = None,
                icon = Some(CheckOutlineIcon("h-4 w-4")),
                size = ButtonSize.ExtraSmall,
                className = Some("bg-green-400 right"),
                onClick = () => Circuit.dispatch(UpdateEditingDetails(false))
              ),
              Button(
                label = None,
                icon = Some(XMarkOutlineIcon("h-4 w-4")),
                size = ButtonSize.ExtraSmall,
                className = Some("pl-1 right"),
                onClick = () => Circuit.dispatch(SaveDetails)
              )
            )
          )
        ),

        fieldset(
          legend(className := "block text-sm font-medium leading-6 text-gray-900")("Card"),
          div(className := "mt-2 -space-y-px rounded-md bg-white shadow-sm")(
            div(
              label(htmlFor := "card-number", className := "sr-only")("Card Number"),
              Input("card-number", placeholder = Some("Card Number"), roundTop = true, onChange = Some(value => Circuit.dispatch(UpdateCardNumber(value))))
            ),
            div(className := "flex -space-x-px")(
              div(className := "w-1/2 min-w-0 flex-1")(
                label(htmlFor := "card-expiration-date", className := "sr-only")("Expiration date"),
                Input("card-expiration-date", placeholder = Some("MM / YY"), roundBottomLeft = true, onChange = Some(value => Circuit.dispatch(UpdateCardExpiry(value))))
              ),
              div(className := "min-w-0 flex-1")(
                label(htmlFor := "card-cvc", className := "sr-only")("CVC"),
                Input("card-cvc", placeholder = Some("CVC"), roundBottomRight = true, onChange = Some(value => Circuit.dispatch(UpdateCardCVC(value))))
              )
            )
          )
        ),
        fieldset(className := "mt-6")(
          legend(className := "block text-sm font-medium leading-6 text-gray-900")("Address"),
          div(className := "mt-2 -space-y-px rounded-md bg-white shadow-sm")(
            div(
              label(htmlFor := "country", className := "sr-only")("Country"),
              Select(
                name = "country",
                onChange = value => Circuit.dispatch(UpdateAddressCountry(value)),
                options = List("United States", "Canada", "Mexico")
              )
            ),
            div(
              label(htmlFor := "postal-code", className := "sr-only")("ZIP / Postal Code"),
              Input("postal-code", placeholder = Some("ZIP / Postal Code"), roundBottom = true, onChange = Some(value => Circuit.dispatch(UpdateAddressPostalCode(value))))
            )
          )
        ),
        fieldset(className := "mt-6")(
          legend(className := "block text-sm font-medium leading-6 text-gray-900")("Contact"),
          div(className := "mt-2 -space-y-px rounded-md bg-white shadow-sm")(
            div(
              label(htmlFor := "name", className := "sr-only")("Full Name"),
              Input("full-name", placeholder = Some("Full Name"), roundTop = true, onChange = Some(value => Circuit.dispatch(UpdateContactFullName(value))))
            ),
            div(
              label(htmlFor := "email-address", className := "sr-only")("Email Address"),
              Input("email-address", placeholder = Some("Email Address"), roundBottom = true, onChange = Some(value => Circuit.dispatch(UpdateContactEmail(value))))
            )
          )
        )
      ),
      div(className := "sm:col-span-4 pl-4")(
        when(state.invoices.nonEmpty)(
          Fragment(
            Heading("Invoices"),
            Table(
              name = "invoices",
              headers = List("Date", "Status"),
              rows = List(
                state.invoices.map(invoice =>
                  List[ReactElement](
                    div(className := "whitespace-nowrap py-2 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-4")("Oct 2023"),
                    div(className := "pr-6 pb-1")(
                      invoice.status match {
                        case Paid => Badge.green("Paid")
                        case Overdue => Badge.yellow("Overdue")
                        case Unpaid => Badge.red("Unpaid")
                      }
                    ),
                    Button(
                      label = None,
                      icon = Some(ArrowSmallDownOutlineIcon("h-4 w-4")),
                      size = ButtonSize.ExtraSmall,
                      className = Some("text-gray-600"),
                      onClick = () => ()
                    )
                  )
                )
              ),
              actionColumn = true
            )
          )
        )
      )
    )
  }
}
