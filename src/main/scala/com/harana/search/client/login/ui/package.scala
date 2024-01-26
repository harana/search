package com.harana.search.client.login

import com.harana.search.client.Theme

import scala.scalajs.js.Dynamic.{literal => css}

package object ui {

  val searchBarFormStyle = css(
    background = "transparent",
    border = "none",
    borderRadius = "10px",
    marginBottom = "16px",
    height = "56px",
    width = "100%"
  )

  val searchBarInputStyle = css(
    background = Theme.darkOverlay,
    border = "none",
    borderBottom = s"1px solid ${Theme.highlightOverlay}",
    borderRadius = "8px 8px 0px 0px",
    color = Theme.primaryTextColor,
    fontFamily = "Helvetica",
    fontSize = "18px",
    fontStyle = "normal",
    fontWeight = "500",
    height = "56px",
    lineHeight = "20px",
    outline = "none",
    paddingLeft = "16px",
    width = "100%"
  )

  val footerTextStyle = css(
    color = Theme.secondaryTextColor,
    fontFamily = "Helvetica",
    fontSize = "12px",
    fontStyle = "normal",
    fontWeight = "500",
    marginTop = "8px",
    textAlign = "center"
  )
}