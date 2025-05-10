package com.harana.sbt.common

import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import com.typesafe.sbt.packager.universal.UniversalPlugin.autoImport._
import sbtghpackages._
import sbtghpackages.GitHubPackagesKeys._
import sbt.Keys.{baseDirectory, _}
import sbt._
import sbt.nio.Keys.{ReloadOnSourceChanges, onChangedBuildSource}
import sbt.{File, nio, _}
import org.scalablytyped.converter.plugin.STKeys._
import org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport._

import scala.sys.process._
import org.scalajs.linker.interface.Report

object Settings {

  lazy val buildCss = taskKey[Unit]("")
  lazy val buildJs = taskKey[Unit]("")
  lazy val buildOutputDir = taskKey[(Report, File)]("")
  lazy val isRelease = sys.env.get("RELEASE").contains("true")

  lazy val scala2Options = Seq(
    "-Xcheck-macros",
    "-Xlog-implicits",
    "-Xmaxerrs", "100",
    "-Xprint-types",
    "-Ybackend-parallelism", "16",
    "-Ybackend-worker-queue", "1000",
    "-Ycheck-mods",
    "-Ycheck:all",
    "-Ydebug-type-error",
    "-Ykind-projector:underscores",
    "-Ymacro-annotations",
    "-Yrangepos",
    "-Yshow-print-errors",
    "-feature",
    "-language:dynamics",
    "-language:experimental.macros",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:namedTypeArguments",
    "-language:postfixOps",
    "-unchecked",
    s"-Wconf:any:warning",
  )

  lazy val scala3Options = Seq(
      "-language:higherKinds",
      "-Ybackend-parallelism", "16",
      "-Ybackend-worker-queue", "1000",
      "-Yretain-trees",
      "-Xmax-inlines", "128"
//      "-explain"
  )

  def common = Seq(
    scalaVersion                                  := "3.7.0",
    doc / sources                                 := Seq(),
    packageDoc / publishArtifact                  := false,
    publishArtifact in (Compile, packageDoc)      := false,
    packageSrc / publishArtifact                  := false,
    publishArtifact in (Compile, packageSrc)      := false,
    maxErrors                                     := 1000,
    fork                                          := true,
    Global / cancelable                           := true,
    ThisBuild / usePipelining                     := true,
    githubOwner                                   := "harana",
    organization                                  := "com.harana",
    githubTokenSource                             := TokenSource.Environment("GITHUB_TOKEN"),

    updateOptions                                 := updateOptions.value.withCachedResolution(true),
    testFrameworks                                := Seq(new TestFramework("zio.test.sbt.ZTestFramework")),
    crossPaths                                    := true,
    resolvers                                     ++= Library.resolvers,
    dependencyOverrides                           ++= Library.globalDependencyOverrides.value,
    updateOptions                                 := updateOptions.value.withCachedResolution(true),
    Test / parallelExecution                      := false,
    Global / nio.Keys.onChangedBuildSource        := ReloadOnSourceChanges
  )

  val js = Seq(
		scalaJSUseMainModuleInitializer               := true,
    Global / onChangedBuildSource                 := ReloadOnSourceChanges,
    scalaJSLinkerConfig                           ~= (_.withModuleKind(ModuleKind.ESModule)),
    unmanagedBase                                 := (ThisProject / unmanagedBase).value,
    libraryDependencySchemes                      ++= Library.libraryDependencySchemes.value,
    externalNpm                                   := {
                                                        sys.process.Process(Seq("/opt/homebrew/bin/pnpm", "--silent", "--cwd", baseDirectory.value.toString)).!
                                                        baseDirectory.value
                                                     },
    stIgnore                                      ++= List(
                                                    "@headlessui/react",
                                                    "@heroicons/react",
                                                    "@lit/reactive-element",
                                                    "@mapbox/togeojson",
                                                    "@niivue/niivue",
                                                    "@nivo/core",
                                                    "@scala-js/vite-plugin-scalajs",
                                                    "@sentry/vite-plugin",
                                                    "@shoelace-style/shoelace",
                                                    "@tailwindcss/aspect-ratio",
                                                    "@tailwindcss/forms",
                                                    "@tailwindcss/typography",
                                                    "@tauri-apps/cli",
                                                    "@vitejs/plugin-react",
                                                    "@xeokit/xeokit-sdk",
                                                    "autoprefixer",
                                                    "chakra-ui/react-types",
                                                    "csstype",
                                                    "d3",
                                                    "framer-motion",
                                                    "history",
                                                    "howler",
                                                    "katex",
                                                    "keen-slider",
                                                    "leaflet",
                                                    "meshgrad",
                                                    "notebookjs",
                                                    "postcss",
                                                    "prismjs",
                                                    "react",
                                                    "react-dom",
                                                    "react-helmet",
                                                    "react-icons",
                                                    "react-json-lens",
                                                    "react-leaflet-kml",
                                                    "react-proxy",
                                                    "react-virtuoso",
                                                    "styled-components",
                                                    "tailwindcss",
                                                    "tauri-plugin-log-api",
                                                    "type-fest",
                                                    "vite",
                                                    "xlsx-viewer"
    ),
//    stFlavour                                     := Flavour.Slinky,
//    stMinimize                                    := Selection.AllExcept("@tauri-apps/api"),
//    stOutputPackage                               := "com.harana.js",
//    stEnableLongApplyMethod                       := true,
//    Global / stQuiet                              := true,
    Compile / packageSrc / mappings               ++= {
                                                    val base = (Compile / sourceManaged).value
                                                    val files = (Compile / managedSources).value
                                                    files.map { f => (f, f.relativeTo(base).get.getPath) }
                                                  },
    buildOutputDir                                := {
                                                    if (isRelease) (Compile / fullLinkJS).value.data -> (Compile / fullLinkJS / scalaJSLinkerOutputDirectory).value
                                                    else (Compile / fastLinkJS).value.data -> (Compile / fastLinkJS / scalaJSLinkerOutputDirectory).value
                                                  },
    buildCss                                      := {
                                                    s"pnpm run --dir ${baseDirectory.value.toString} build-css" !
                                                  },
    buildJs                                       := {
                                                    val (_, outputDir) = buildOutputDir.value
                                                    s"pnpm run --dir ${baseDirectory.value.toString} build-js" !
                                                  },
                                                )

  val javaLaunchOptions                        = Seq("--add-opens=java.base/java.io=ALL-UNNAMED",
                                                     "--add-opens=java.base/java.lang.reflect=ALL-UNNAMED",
                                                     "--add-opens=java.base/java.lang=ALL-UNNAMED",
                                                     "--add-opens=java.base/java.math=ALL-UNNAMED",
                                                     "--add-opens=java.base/java.net=ALL-UNNAMED",
                                                     "--add-opens=java.base/java.security=ALL-UNNAMED",
                                                     "--add-opens=java.base/java.text=ALL-UNNAMED",
                                                     "--add-opens=java.base/java.util.concurrent.atomic=ALL-UNNAMED",
                                                     "--add-opens=java.base/java.util.concurrent.locks=ALL-UNNAMED",
                                                     "--add-opens=java.base/java.util.concurrent=ALL-UNNAMED",
                                                     "--add-opens=java.base/java.util=ALL-UNNAMED",
                                                     "--add-opens=java.base/jdk.internal.reflect=ALL-UNNAMED",
                                                     "--add-opens=java.base/sun.security.pkcs=ALL-UNNAMED",
                                                     "--add-opens=java.base/sun.security.rsa=ALL-UNNAMED",
                                                     "--add-opens=java.base/sun.security.x509=ALL-UNNAMED",
                                                     "--add-opens=java.management/javax.management.openmbean=ALL-UNNAMED",
                                                     "--add-opens=java.management/javax.management=ALL-UNNAMED",
                                                     "--add-opens=java.naming/javax.naming=ALL-UNNAMED",
                                                     "--add-opens=java.sql/java.sql=ALL-UNNAMED")

  val jvm = Seq(
    unmanagedBase                             := (ThisProject / unmanagedBase).value,
    run / fork                                := true,
    javacOptions                              ++= Seq("-encoding", "UTF-8"),
    javaOptions                               ++= javaLaunchOptions,
    Universal / javaOptions                   ++= javaLaunchOptions.map(lo => s"-J$lo"),
    javaOptions                               ++= {
                                                    val Digits = "^(\\d+)$".r
                                                    sys.env.get("HARANA_DEBUG") match {
                                                      case Some("true") =>
                                                        Seq("-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005")
                                                      case Some(Digits(port)) =>
                                                        Seq(s"-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=$port")
                                                      case _ =>
                                                        Seq.empty
                                                    }
                                                  }
  )

  val copyOSGIBundlesTask                     = taskKey[Unit]("Copy OSGI system bundles task")
  val OsgiStage                               = config("CopyOSGIBundlesTask")
  val osgi                                    = Seq(
                                                  OsgiStage / libraryDependencies := Library.osgi.value,
                                                  libraryDependencies ++= Library.osgi.value,
                                                  copyOSGIBundlesTask := {
                                                    (OsgiStage / update).value.allFiles.foreach { f =>
                                                      (OsgiStage / libraryDependencies).value.foreach { lib =>
                                                        (Compile / dependencyClasspath).value.foreach { dep =>
                                                          if (dep.metadata.get(moduleID.key).get.equals(lib) && !dep.data.getName.contains("felix.framework")) {
                                                            IO.copyFile(dep.data, new File("bundles",dep.data.getName))
                                                          }
                                                        }
                                                      }
                                                    }
                                                  },
    Compile / compile                         := ((Compile / compile) dependsOn copyOSGIBundlesTask).value,
    //mappings in Universal                   ++= directory(baseDirectory.value / "bundles"),
    //mappings in Universal                   ++= directory(baseDirectory.value / "plugins"),
  ) ++ inConfig(OsgiStage)(Classpaths.ivyBaseSettings)

  def ramDisk(baseDirectory: File, name: String, size: Long) = {
    val cmd = s"""(rm -rf $baseDirectory/target) &&
      | (mount | grep -q /Volumes/$name || diskutil apfs create `hdiutil attach -nomount ram://$size` $name) &&
      | (ln -s /Volumes/$name $baseDirectory/target)
    """.stripMargin
    Seq("bash", "-c", cmd)
  }

  def javaVersion = {
    var version = System.getProperty("java.version")
    if (version.startsWith("1.")) version = version.substring(2, 3)
    else {
      val dot = version.indexOf(".")
      if (dot != -1) version = version.substring(0, dot)
    }
    val dash = version.indexOf("-")
    if (dash != -1) version = version.substring(0, dash)
    version.toInt
  }
}
