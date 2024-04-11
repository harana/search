package com.harana.search.client.system

import diode.Action

object SystemStore {

  case class State(appAssetsUrl: String,
                   appIconsUrl: String,
                   previewsUrl: String,
                   isDebug: Boolean,
                   isDemo: Boolean,
                   thumbnailsUrl: String)

  val initialState = State("", "", "", false, false, "")

  case class UpdateAppIconsUrl(url: String) extends Action
  case class UpdateAppAssetsUrl(url: String) extends Action
  case class UpdateIsDebug(debug: Boolean) extends Action
  case class UpdateIsDemo(demo: Boolean) extends Action
  case class UpdatePreviewsUrl(url: String) extends Action
  case class UpdateThumbnailsUrl(url: String) extends Action

}