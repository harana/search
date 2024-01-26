package com.harana.search.client.search

import com.harana.sdk.shared.utils.Random
import com.harana.search.client.models.Integration.IntegrationId
import com.harana.search.client.models.{Document, Integrations}

object SampleData {

  val integrations = List(
    Integrations.get("airtable"),
    Integrations.get("local-audio"),
    Integrations.get("local-document"),
    Integrations.get("github"),
    Integrations.get("local-image"),
    Integrations.get("jira"),
    Integrations.get("notion"),
    Integrations.get("okta"),
    Integrations.get("stripe"),
    Integrations.get("trello"),
    Integrations.get("xero")
  )

  val metadata = Map(
    "Focal Length" -> "f/8",
    "Camera" -> "Sony RX1RII",
    "Shutter Speed" -> "1/125",
    "Location" -> "Perth, Western Australia",
    "ISO" -> "800",
    "Resolution" -> "1080 x 908",
  )

  val sampleData: List[(IntegrationId, List[Document])] =
    List(
      (Integrations.get("airtable").id, documents),
      (Integrations.get("local-contact").id, documents),
      (Integrations.get("local-document").id, documents),
      (Integrations.get("local-email").id, documents),
      (Integrations.get("notion").id, documents),
      (Integrations.get("paypal-transaction").id, documents),
      (Integrations.get("pinterest").id, documents),
      (Integrations.get("quickbooks").id, documents),
      (Integrations.get("slack").id, documents),
      (Integrations.get("todoist").id, documents),
    )

  def documents = List(
    doc("Architect Minutes", "docx", "meetings"),
    doc("Bathroom Rev 10", "pdf", "interior design"),
    doc("Kitchen Plans", "pdf", "construction"),
    doc("Lounge Sofa ", "docx", "interior design"),
    doc("Schedule of Revisions", "pdf", "planning approval"),
  )

  def doc(title: String, extension: String, parentFolderName: String) =
    Document(
      id = Random.short,
      integrationId = Integrations.get("local-document").id,
      title = title,
      description = None,
      author = None,
      primaryTokens = Set(),
      secondaryTokens = Set(),
      isFile = true,
      created = Some("1 day ago"),
      modified = Some("2 hours ago"),
      accessed = Some("2 hours ago"),
      size = Some("421.4 kB"),
      colour = None,
      path = Some("/tmp"),
      extension = Some(extension),
      extensionTitle = None,
      parentFolderName = Some(parentFolderName),
      parentFolderPath = None,
      metadata = None,
      cards = List("sample")
    )
}
