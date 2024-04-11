package com.harana.search.client.cards

import scala.scalajs.js
import scala.scalajs.js.|

package object temp {

  trait Color extends js.Object {
    val from: String
    val modifiers: js.Array[js.Array[Int | String | Double]]
  }

  trait Feature extends js.Object {
    val id: js.UndefOr[String] = js.undefined
    val `type`: js.UndefOr[String] = js.undefined
    val properties: js.UndefOr[js.Object] = js.undefined
    val geometry: js.UndefOr[js.Object] = js.undefined
  }

  trait Definition extends js.Object {
    val id: js.UndefOr[String] = js.undefined
    val `type`: js.UndefOr[String] = js.undefined
    val background: js.UndefOr[String] = js.undefined
    val color: js.UndefOr[String] = js.undefined
    val lineWidth: js.UndefOr[Int] = js.undefined
    val rotation: js.UndefOr[Int] = js.undefined
    val padding: js.UndefOr[Int] = js.undefined
    val size: js.UndefOr[Int] = js.undefined
    val spacing: js.UndefOr[Int] = js.undefined
    val stagger: js.UndefOr[Boolean] = js.undefined
  }

  trait Fill extends js.Object {
    val `match`: FillMatch
    val id: String
  }

  trait FillMatch extends js.Object {
    val id: String
  }

  trait Entry extends js.Object {
    val id: String
    val value: Int
  }

  trait Margin extends js.Object {
    val top: Int
    val bottom: Int
    val left: Int
    val right: Int
  }
}