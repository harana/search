package com.harana.sbt.jvm

import com.harana.sbt.common.versioning.versioning._
import com.harana.sbt.common._
import com.typesafe.sbt.packager.archetypes.JavaAppPackaging
import com.typesafe.sbt.packager.universal.UniversalPlugin
import sbt.Keys._
import sbt._
import sbtghpackages.GitHubPackagesKeys.githubRepository

object Plugin extends AutoPlugin {

  override def trigger = allRequirements

  object autoImport {
    def haranaProject(id: String): Project =
      Project(id = id, file(id))
        .enablePlugins(GitVersioningPlugin, JavaAppPackaging, UniversalPlugin)
        .settings(
          organization := "com.harana",
          name := id,
          githubRepository := id,
          Library.compilerPlugins,
          scalacOptions := (if (scalaVersion.value.startsWith("3")) Settings.scala3Options else Settings.scala2Options),
          Settings.common,
          Settings.jvm,
          unmanagedBase := (ThisBuild / baseDirectory).value / "lib",
          libraryDependencies ++= Library.common.value,
          libraryDependencies ++= Library.jvm.value,
          libraryDependencySchemes ++= Library.libraryDependencySchemes.value,
          dependencyOverrides ++= Library.globalDependencyOverrides.value,
          excludeDependencies ++= Library.globalExclusions.value
        )
  }
}