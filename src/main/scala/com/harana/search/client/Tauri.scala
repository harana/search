package com.harana.search.client

import com.harana.web.actions.NoChange
import com.harana.web.external.tauri.Event
import com.harana.web.external.tauri.Tauri.{invoke => rawInvoke}
import diode.{Action, ActionResult, Effect}
import io.circe.Decoder
import io.circe.parser.decode
import org.scalajs.dom.Window
import org.scalajs.dom.window.window
import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits.global

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.scalajs.js.|

object Tauri {
  def list[T, A <: Action](command: String, action: List[T] => A)(implicit d: Decoder[T]) =
    Effect(
      invoke(command).map { (json: String) =>
        decode[List[T]](json) match {
          case Left(e) => {
            println(s"Error decoding: ${e.toString} with JSON: $json")
            action(List())
          }
          case Right(list) => action(list)
        }
      }
    )

  def setting[A <: Action](key: String, action: String => A) =
    Effect(invoke[String]("get_setting", Map("key" -> key)).map(value => action(value)))

  def update_setting[S](key: String, value: String, updater: Effect => ActionResult[S]) =
    updater(Effect(invoke[Unit]("update_setting", Map("key" -> key, "value" -> value)).map(_ => NoChange)))

  def state[A <: Action](key: String, action: String => A) =
    Effect(invoke[String]("get_state", Map("key" -> key)).map(value => action(value)))

  def update_state[S](key: String, value: String, updater: Effect => ActionResult[S]) =
    updater(Effect(invoke[Unit]("update_state", Map("key" -> key, "value" -> value)).map(_ => NoChange)))

  def update[S](cmd: String, updater: Effect => ActionResult[S]) =
    updater(Effect(invoke[Unit](cmd, Map()).map(_ => NoChange)))

  def update[S](cmd: String, args: Map[String, Any], updater: Effect => ActionResult[S]) =
    updater(Effect(invoke[Unit](cmd, args).map(_ => NoChange)))

  def invoke[T, A <: Action](cmd: String, action: T => A): Future[T] =
    invokeAny(cmd, Map(), (s: Any) => s.asInstanceOf[T], (s: Any) => s.asInstanceOf[T])

  def invoke[T](cmd: String, args: Map[String, Any] = Map()): Future[T] =
    invokeAny(cmd, args, (s: Any) => s.asInstanceOf[T], (s: Any) => s.asInstanceOf[T])

  def invokeAsAction(cmd: String, args: Map[String, Any] = Map()): Future[Action] =
    invokeAsAction(cmd, args, (_: Any) => NoChange, (_: Any) => NoChange)

  def invokeAsAction[A <: diode.Action, B <: diode.Action](cmd: String,
                     args: Map[String, Any],
                     onSuccess: Any => A,
                     onFailure: Any => B): Future[Action] =
    invokeAny[Unit, Unit, Unit](
      cmd,
      args,
      _ => Circuit.dispatch(onSuccess()),
      _ => Circuit.dispatch(onFailure())
    ).map(_ => NoChange)

  def invokeAny[T, A <: T, B <: T](cmd: String,
                                   args: Map[String, Any],
                                   onSuccess: Any => A,
                                   onFailure: Any => B): Future[T] = {

    val success: js.Function1[Any, A] = onSuccess
    val failure: js.Function1[Any, B | scala.scalajs.js.Thenable[B]] = (any: Any) => {
      println("Error: Failed Tauri invoke: " + any.toString)
      onFailure(any)
    }

    val future = rawInvoke(cmd, args.toJSDictionary)
      .`then`[A](onFulfilled = success, onRejected = js.undefined)
      .`catch`(onRejected = Some(failure).orUndefined)
      .toFuture

    future.recover {
      case e: Exception =>
        e.printStackTrace()
        println("Error: Failed Tauri invoke: " + e.toString)
      }

    future
  }

  def listen[T <: js.Any](event: String, handler: T => Unit): Future[Unit] =
    Event.listen[T](event, payload => {
      handler(payload.payload)
    }).toFuture.map(_ => ())

  def emit[T <: js.Object](event: String, payload: Option[T] = None): Future[Unit] = {
    Event.emit(event, payload).toFuture
  }

  def subscribe(name: String, callback: String => Unit): Unit = {
    val tauriWindow = window.asInstanceOf[TauriWindow]
    tauriWindow.RpcEvent.listen(name, callback)
  }
}

@js.native
trait TauriWindow extends Window {
  def RpcEvent: RpcEvent = js.native
}

@js.native
trait RpcEvent extends js.Object {
  def listen(eventName: String, callback: js.Function1[String, Unit]): () => Unit = js.native
}