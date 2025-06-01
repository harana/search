package com.harana.sbt.js_jvm

import com.harana.sbt.common.versioning.versioning._
import java.nio.charset.Charset
import java.nio.file._
import com.harana.sbt.common._
import com.typesafe.sbt.packager.archetypes.JavaAppPackaging
import com.typesafe.sbt.packager.universal.UniversalPlugin
import sbt.Keys._
import sbt.{Def, _}
import sbtcrossproject.CrossPlugin.autoImport._
import sbtcrossproject.CrossProject
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import scalajscrossproject.ScalaJSCrossPlugin.autoImport._
import sbtghpackages.GitHubPackagesKeys.githubRepository
import scala.sys.process._
import org.scalablytyped.converter.plugin._
import org.scalablytyped.converter.plugin.STKeys._
import org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport._

object Plugin extends AutoPlugin {

  override def trigger = allRequirements

  object autoImport {

    val utf8: Charset = Charset.forName("UTF-8")

    def haranaRootProject(crossProject: CrossProject): Project =
      Project("root", file(".")).
        aggregate(crossProject.js, crossProject.jvm).
        settings(
          Settings.common,
          publish         := {},
          publishLocal    := {},
          publishArtifact := false
        )

    def haranaCrossProject(id: String): CrossProject =
      CrossProject(id = id, file(id))(JSPlatform, JVMPlatform)
        .crossType(CrossType.Full)
        .jsConfigure(_.enablePlugins(GitVersioningPlugin, ScalablyTypedConverterExternalNpmPlugin))
        .jvmConfigure(_.enablePlugins(GitVersioningPlugin, JavaAppPackaging, UniversalPlugin))
        .settings(
          organization := "com.harana",
          name := id,
          githubRepository := id,
          Library.compilerPlugins,
          libraryDependencies ++= Library.common.value,
          excludeDependencies ++= Library.globalExclusions.value,
          Settings.common,
          scalacOptions ++= (if (scalaVersion.value.startsWith("3")) Settings.scala3Options else Settings.scala2Options),
          unmanagedBase := (ThisBuild / baseDirectory).value / "lib"
        )
        .jsSettings(
          name := id,
          Library.compilerPlugins,
          dependencyOverrides ++= Library.globalDependencyOverrides.value,
          excludeDependencies ++= Library.globalExclusions.value,
          libraryDependencySchemes ++= Library.libraryDependencySchemes.value,
          libraryDependencies ++=  Library.js.value,
          Settings.js,
          unmanagedBase := (ThisBuild / baseDirectory).value / "lib"
        )
        .jvmSettings(
          name := id,
          Library.compilerPlugins,
          dependencyOverrides ++= Library.globalDependencyOverrides.value,
          excludeDependencies ++= Library.globalExclusions.value,
          libraryDependencySchemes ++= Library.libraryDependencySchemes.value,
          libraryDependencies ++= Library.jvm.value,
          Settings.jvm,
          unmanagedBase := (ThisBuild / baseDirectory).value / "lib"
        )
  }
}