package com.harana.search.client

import com.harana.web.base.{Analytics, BaseApp}

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("Main")
object Main {

  lazy val analytics = new Analytics("com.harana.search", "Harana Search")
  lazy val circuit = Circuit

  @JSExport
  def main(args: Array[String]): Unit = {

    BaseApp.main(
      circuit,
      Router(),
      auth = false,
      onWindowFocus = None,
      logActions = false,
      logErrorsServerSide = false
    )
  }
}