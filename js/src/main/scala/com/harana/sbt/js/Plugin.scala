package com.harana.sbt.js

import com.harana.sbt.common.versioning.versioning._
import com.harana.sbt.common._
import org.scalajs.sbtplugin.ScalaJSPlugin
import sbt.Keys._
import sbt._
import sbtghpackages.GitHubPackagesKeys.githubRepository
import org.scalablytyped.converter.plugin._
import org.scalablytyped.converter.plugin.STKeys._
import org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport._

import scala.sys.process._

object Plugin extends AutoPlugin {

  override def trigger = allRequirements

  object autoImport {
    def haranaProject(id: String): Project =
      Project(id = id, file(id))
        .enablePlugins(GitVersioningPlugin, ScalaJSPlugin, ScalablyTypedConverterExternalNpmPlugin)
        .settings(
          organization := "com.harana",
          name := id,
          githubRepository := id,
          Library.compilerPlugins,
          scalacOptions ++= (if (scalaVersion.value.startsWith("3")) Settings.scala3Options else Settings.scala2Options),
          Settings.common,
          Settings.js,
          libraryDependencies ++= Library.common.value,
          libraryDependencies ++=  Library.js.value,
          libraryDependencySchemes ++= Library.libraryDependencySchemes.value,
          excludeDependencies ++= Library.globalExclusions.value,
          dependencyOverrides := Library.jsOverrides.value,
          unmanagedBase := (ThisBuild / baseDirectory).value / "lib"
        )
  }
}