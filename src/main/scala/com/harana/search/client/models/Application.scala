package com.harana.search.client.models

import com.harana.search.client.models.Integration.IntegrationId
import io.circe.generic.extras.ConfiguredJsonCodec

import scala.scalajs.js

trait RawApplication extends js.Object {
  val name: String
  val path: String
  val source_icon_path: String
  val target_icon_path: String
}

@ConfiguredJsonCodec
case class Application(name: String,
                       path: String,
                       sourceIconPath: String,
                       targetIconPath: String)

object Application {
  def apply(rd: RawApplication): Application =
    Application(rd.name, rd.path, rd.source_icon_path, rd.target_icon_path)
}