package com.harana.search.client.search

import com.harana.search.client.Circuit.zoomTo
import com.harana.search.client.Tauri
import com.harana.search.client.models.{Document, Integrations, RawDocument}
import com.harana.search.client.search.SearchStore._
import com.harana.search.client.search.ui.{Panel, SearchPanel}
import com.harana.web.actions._
import com.harana.web.external.tauri.Asset
import com.harana.web.external.virtuoso.{ScrollIntoViewLocation, Virtuoso}
import diode.Effect.action
import diode._
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global
import slinky.core.facade.ReactRef

import scala.concurrent.Promise
import scala.scalajs.js
import scala.util.Try

class SearchScrollHandler extends ActionHandler(zoomTo(_.searchState)) {

  def scrollToRef(ref: ReactRef[Virtuoso.RefType], scrollIndex: Int) = {
    if (ref == null) noChange
    else {
      val promise = Promise[Unit]()
      ref.current.scrollIntoView(new ScrollIntoViewLocation {
        override val index = scrollIndex
        override val done = () => promise.complete(Try(()))
      })

      effectOnly(Effect(promise.future.map(_ => NoChange)))
    }
  }

  override def handle = {

    case ScrollToDocument(documentId) =>
      val results = value.searchResults.find(_._1 == value.selectedIntegration.get).get._2.map(_.id)
      val documentIndex = results.indexOf(documentId)
      scrollToRef(SearchPanel.documentsRef, documentIndex)

    case ScrollToIntegration(integrationId) =>
      val integrationIndex = value.searchResults.map(_._1).indexOf(integrationId)
      scrollToRef(SearchPanel.integrationsRef, integrationIndex)

    case ScrollToFirstDocument =>
      scrollToRef(SearchPanel.documentsRef, 0)

    case ScrollToLastDocument =>
      val docs = value.searchResults.find(_._1 == value.selectedIntegration.get).get._2
      scrollToRef(SearchPanel.documentsRef, docs.length - 1)

    case ScrollToFirstIntegration =>
      scrollToRef(SearchPanel.integrationsRef, 0)

    case ScrollToLastIntegration =>
      scrollToRef(SearchPanel.integrationsRef, value.searchResults.length - 1)

  }
}