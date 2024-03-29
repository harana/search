package com.harana.search.client.system

import diode.Action

object SystemStore {

  case class State(appAssetsUrl: String,
                   appIconsUrl: String,
                   previewsUrl: String,
                   thumbnailsUrl: String)

  val initialState = State("", "", "", "")

  case class UpdateAppIconsUrl(url: String) extends Action
  case class UpdateAppAssetsUrl(url: String) extends Action
  case class UpdatePreviewsUrl(url: String) extends Action
  case class UpdateThumbnailsUrl(url: String) extends Action

}