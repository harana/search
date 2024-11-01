package com.harana.sbt.common

import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport.*
import sbt.Keys.{resolvers, scalaVersion}
import sbt.*
import sbtghpackages.GitHubPackagesPlugin.autoImport.*

import scala.language.postfixOps

object Hadoop {
  private lazy val components = Library.hadoop
  lazy val provided = components.map(_.map(_ % Provided))
  lazy val test = components.map(_.map(_ % s"$Test,it"))
  lazy val onlyInTests = components.map(a => a.map(_ % Provided) ++ a.map(_ % s"$Test,it"))
}

object Library {

  val common = Def.setting(Seq())
  val js = Def.setting(Seq())
  val jsOverrides = Def.setting(Seq())
  val jvm = Def.setting(Seq())

//  val additionalNpmConfig = Def.setting(Map(
//    "overrides" -> JSON.obj(
//      "oas-xterm-for-react18" -> JSON.obj(
//        "react" -> JSON.str("18.2.0")
//      ),
//      "react-device-detect" -> JSON.obj(
//        "react" -> JSON.str("18.2.0"),
//        "react-dom" -> JSON.str("18.2.0"),
//      ),
//      "mini-create-react-context" -> JSON.obj(
//        "react" -> JSON.str("18.2.0")
//      ),
//      "react-lazylog-x" -> JSON.obj(
//        "react-virtualized" -> JSON.str("9.22.5"),
//        "react" -> JSON.str("18.2.0"),
//        "react-dom" -> JSON.str("18.2.0")
//      ),
//      "react-virtualized" -> JSON.obj(
//        "react" -> JSON.str("18.2.0"),
//        "react-dom" -> JSON.str("18.2.0"),
//      ),
//    )
//  ))

  val globalDependencyOverrides = Def.setting(Seq(
    "org.apache.curator"      %   "curator-recipes"             % "5.7.0",
    "org.json4s"              %%  "json4s-core"                 % "3.7.0-M11",
    "org.json4s"              %%  "json4s-native"               % "3.7.0-M11",
    "org.json4s"              %%  "json4s-jackson"              % "3.7.0-M11",
    "org.json4s"              %%  "json4s-ext"                  % "3.7.0-M11",
    "io.spray"                %%% "spray-json"                  % "1.3.6"
  ))

  val libraryDependencySchemes = Def.setting(Seq())

  val globalExclusions = Def.setting(Seq(
    ExclusionRule("org.slf4j", "slf4j-log4j12"),
    ExclusionRule("org.slf4j", "slf4j-reload4j"),
    ExclusionRule(organization = "org.bouncycastle"),
    ExclusionRule("javax.ws.rs", "jsr311-api"),
    ExclusionRule("com.sun.jersey", "jersey-client"),
    ExclusionRule("com.sun.jersey", "jersey-core"),
    ExclusionRule("com.sun.jersey", "jersey-servlet"),
    ExclusionRule("com.sun.xml.bind", "jaxb-impl"),
    ExclusionRule("org.slf4j", "slf4j-log4j12"),
    ExclusionRule("org.slf4j", "slf4j-reload4j"),
    ExclusionRule("log4j", "log4j"),
    ExclusionRule("org.scala-lang.modules", "scala-xml_2.13"),
    ExclusionRule("org.typelevel", "cats-kernel_2.13")
  ))

  implicit class RichModuleID(m: ModuleID) {
    def excludeAkkaActor = m excludeAll ExclusionRule("com.typesafe.akka")
    def excludeJackson = m excludeAll ExclusionRule("com.fasterxml.jackson.core")
    def excludeGuava = m excludeAll ExclusionRule("com.google.guava", "guava")
    def excludeOkio = m excludeAll ExclusionRule("com.squareup.okio", "okio")
    def excludeScalatest = m excludeAll ExclusionRule("org.scalatest")
    def excludeSprayJson = m excludeAll ExclusionRule("io.spray")
  }

  val airbyte = Def.setting(Seq(
    "io.airbyte" % "airbyte-api" % "0.40.6",
    "io.airbyte.airbyte-protocol" % "protocol-models" % "0.40.6"
  ))

  val akka = Def.setting(Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.8.0",
    "com.typesafe.akka" %% "akka-http-core" % "10.5.0",
    "com.typesafe.akka" %% "akka-http-spray-json" % "10.5.0" excludeSprayJson,
    "com.typesafe.akka" %% "akka-slf4j" % "2.8.0",
    "com.typesafe.akka" %% "akka-testkit" % "2.8.0",
    "com.typesafe.akka" %% "akka-protobuf-v3" % "2.8.0",
    "com.typesafe.akka" %% "akka-stream" % "2.8.0"
  ))

  val alluxio = Def.setting(Seq(
    "org.alluxio" % "alluxio-core-client" % "313" exclude("io.netty", "netty-all"),
    "org.alluxio" % "alluxio-core-client-fs" % "312" exclude("io.netty", "netty-all"),
    "org.alluxio" % "alluxio-job-client" % "312" exclude("io.netty", "netty-all")
  ))

  val asm = Def.setting(Seq(
  "org.ow2.asm" % "asm" % "6.0",
    "org.ow2.asm" % "asm-commons" % "6.0",
    "org.ow2.asm" % "asm-tree" % "6.0"
  ))

  val awsS3v1 = Def.setting(Seq(
    "com.amazonaws" % "aws-java-sdk-s3" % "1.12.765"
  ))

  val awsS3v2Version = "2.26.15"
  val awsS3v2 = Def.setting(Seq(
    "software.amazon.awssdk" % "cloudfront" % awsS3v2Version,
    "software.amazon.awssdk" % "iam" % awsS3v2Version,
    "software.amazon.awssdk" % "s3" % awsS3v2Version,
    "software.amazon.awssdk.crt" % "aws-crt" % "0.29.22"
  ))

  val circe = Def.setting(Seq(
    "io.circe" %%% "circe-core" % "0.14.6",
    "io.circe" %%% "circe-generic" % "0.14.6",
    "io.circe" %%% "circe-parser" % "0.14.6",
    "io.circe" %% "circe-yaml" % "1.15.0",
    "org.latestbit" %%% "circe-tagged-adt-codec" % "0.11.0",
    "com.beachape" %%% "enumeratum-circe" % "1.7.5"
  ))

  val compilerPlugins = Seq()

  val dockerJava = Def.setting(Seq(
    "com.github.docker-java" % "docker-java" % "3.4.0",
    "com.github.docker-java" % "docker-java-transport-zerodep" % "3.3.4"
  ))

  val googleServiceApi = Def.setting(Seq(
    "com.google.api-client" % "google-api-client" % "2.6.0",
    "com.google.api-client" % "google-api-client-gson" % "2.6.0",
    "com.google.apis"       % "google-api-services-drive" % "v3-rev20240509-2.0.0"
  ).map(_.excludeJackson.exclude("com.google.guava", "guava-jdk5")))

  val hadoop = Def.setting(Seq(
    "org.apache.hadoop" % "hadoop-aws" % "3.4.0",
    "org.apache.hadoop" % "hadoop-client" % "3.4.0",
    "org.apache.hadoop" % "hadoop-common" % "3.4.0"
  ))

  val jacksonVersion = "2.17.2"
  val jackson = Def.setting(Seq(
    "com.fasterxml.jackson.dataformat"  % "jackson-dataformat-yaml" % jacksonVersion,
    "com.fasterxml.jackson.module"      % "jackson-module-afterburner" % jacksonVersion,
    "com.fasterxml.jackson.module"      % "jackson-modules-java8" % jacksonVersion,
    "com.fasterxml.jackson.module"      %% "jackson-module-scala" % jacksonVersion
  ))

  val jgrapht = Def.setting(Seq(
    "org.jgrapht" % "jgrapht-core" % "1.5.2",
    "org.jgrapht" % "jgrapht-ext" % "1.5.2"
  ))

  val json4s = Def.setting(Seq(
    "org.json4s" %% "json4s-core" % "3.7.0-M11",
    "org.json4s" %% "json4s-native" % "3.7.0-M11",
    "org.json4s" %% "json4s-jackson" % "3.7.0-M11",
    "org.json4s" %% "json4s-ext" % "3.7.0-M11"
  ))

  val log4jVersion = "2.23.1"
  val logging = Def.setting(Seq(
    "org.apache.logging.log4j"  % "log4j-api" % log4jVersion,
    "org.apache.logging.log4j"  % "log4j-1.2-api" % log4jVersion,
    "org.apache.logging.log4j"  % "log4j-core" % log4jVersion,
    "org.apache.logging.log4j"  % "log4j-slf4j-impl" % log4jVersion,
    "org.apache.logging.log4j"  % "log4j-web" % log4jVersion,
    "org.slf4j"                 % "slf4j-api" % "2.0.12"
  ))

  val micrometer = Def.setting(Seq(
    "io.github.mweirauch" % "micrometer-jvm-extras" % "0.2.2",
    "io.micrometer" % "micrometer-registry-prometheus" % "1.13.2",
    "io.micrometer" % "micrometer-registry-prometheus-simpleclient" % "1.13.2"
  ))

  val netty = Def.setting(Seq(
    "io.netty"            % "netty-resolver-dns-native-macos"             % "4.1.108.Final" classifier "osx-aarch_64",
    "io.netty"            % "netty-resolver-dns-native-macos"             % "4.1.108.Final" classifier "osx-x86_64",
    "io.netty"            % "netty-transport-native-epoll"                % "4.1.108.Final" classifier "linux-x86_64",
    "io.netty.incubator"  % "netty-incubator-transport-native-io_uring"   % "0.0.25.Final" classifier "linux-x86_64"
  ))

  val npmResolutions = Def.setting(Map(
    "react"                                 -> "18.2.0",
    "source-map"                            -> "0.7.3"
  ))

  // val npmDependencies = Def.setting(Seq(
  //   "@cantoo/html2canvas"                   -> "1.5.7",
  //   "@google/model-viewer"                  -> "3.3.0",
  //   "@headlessui/react"                     -> "1.7.17",
  //   "@heroicons/react"                      -> "2.1.1",
  //   "@mapbox/togeojson"                     -> "0.16.2",
  //   "@niivue/niivue"                        -> "0.38.0",
  //   "@nivo/bar"                             -> "0.83.0",
  //   "@nivo/calendar"                        -> "0.83.0",
  //   "@nivo/core"                            -> "0.83.0",
  //   "@nivo/waffle"                          -> "0.83.0",
  //   "@peculiar/certificates-viewer-react"   -> "3.10.1",
  //   "@react-three/fiber"                    -> "8.15.3",
  //   "@shoelace-style/shoelace"              -> "2.9.0",
  //   "@tauri-apps/api"                       -> "^1.5.0",
  //   "@vertx/eventbus-bridge-client.js"      -> "1.0.0-3-SNAPSHOT",
  //   "@visx/gradient"                        -> "3.0.0",
  //   "@visx/shape"                           -> "3.2.0",
  //   "@xeokit/xeokit-sdk"                    -> "2.4.0-alpha-80",
  //   "closest"                               -> "0.0.1",
  //   "docx-preview"                          -> "0.1.20",
  //   "dxf-viewer"                            -> "1.0.29",
  //   "filepond"                              -> "4.30.4",
  //   "highlight.js"                          -> "11.9.0",
  //   "history"                               -> "5.3.0",
  //   "howler"                                -> "2.2.4",
  //   "keen-slider"                           -> "6.8.6",
  //   "leaflet"                               -> "1.9.4",
  //   "notebookjs"                            -> "0.6.7",
  //   "oas-xterm-for-react18"                 -> "1.1.0",
  //   "peaks.js"                              -> "3.1.0",
  //   "prismjs"                               -> "1.29.0",
  //   "prop-types"                            -> "15.8.1",
  //   "react"                                 -> "18.2.0",
  //   "react-color"                           -> "2.19.3",
  //   "react-copy-to-clipboard"               -> "5.1.0",
  //   "react-dom"                             -> "18.2.0",
  //   "react-filepond"                        -> "7.1.2",
  //   "react-helmet"                          -> "6.1.0",
  //   "react-intl"                            -> "6.4.4",
  //   "react-ipynb-renderer"                  -> "2.1.2",
  //   "react-json-lens"                       -> "1.0.1",
  //   "react-latex-next"                      -> "2.2.0",
  //   "react-lazylog-x"                       -> "4.5.6",
  //   "react-leaflet"                         -> "4.2.1",
  //   "react-leaflet-kml"                     -> "2.1.1",
  //   "react-markdown"                        -> "8.0.7",
  //   "react-markdown"                        -> "9.0.0",
  //   "react-pdf"                             -> "7.5.1",
  //   "react-proxy"                           -> "1.1.8",
  //   "react-router"                          -> "5.3.4",
  //   "react-router-cache-route"              -> "1.12.11",
  //   "react-router-dom"                      -> "5.3.4",
  //   "react-terminal"                        -> "1.3.1",
  //   "react-terminal-ui"                     -> "1.0.5",
  //   "react-virtuoso"                        -> "4.6.0",
  //   "reactflow"                             -> "11.7.4",
  //   "seqviz"                                -> "3.9.2",
  //   "sockjs-client"                         -> "1.6.1",
  //   "source-map"                            -> "0.7.3",
  //   "throttle-debounce"                     -> "5.0.0",
  //   "xlsx-viewer"                           -> "1.1.5",
  //   "xterm-addon-fit"                       -> "0.7.0",
  // ))

  val okhttp = Def.setting(Seq(
    "com.squareup.okhttp3" % "logging-interceptor" % "4.12.0",
    "com.squareup.okhttp3" % "okhttp" % "4.12.0"
  ))

  val osgi = Def.setting(Seq(
    "org.apache.felix" % "org.apache.felix.framework" % "7.0.5",
    "org.apache.felix" % "org.apache.felix.fileinstall" % "3.7.4",
    "org.apache.felix" % "org.apache.felix.configadmin" % "1.9.24",
    "org.apache.felix" % "org.apache.felix.bundlerepository" % "2.0.10",
    "org.osgi" % "org.osgi.core" % "6.0.0"
  ))

  val pac4jVersion = "6.0.5"
  val pac4j = Def.setting(Seq(
    "org.pac4j" % "pac4j-cas" % pac4jVersion,
    "org.pac4j" % "pac4j-config" % pac4jVersion,
    "org.pac4j" % "pac4j-http" % pac4jVersion,
    "org.pac4j" % "pac4j-jwt" % pac4jVersion,
    "org.pac4j" % "pac4j-oauth" % pac4jVersion,
    "org.pac4j" % "pac4j-oidc" % pac4jVersion,
    "org.pac4j" % "pac4j-saml" % pac4jVersion,
  ))

  val parquet = Def.setting(Seq(
    "com.github.mjakubowski84"  %% "parquet4s-core" % "2.18.0",
    "org.apache.parquet" % "parquet-avro" % "1.14.1"
  ))

  val scala = Def.setting(Seq(
    "org.scala-lang" % "scala-compiler" % scalaVersion.value % "provided",
    "org.scala-lang" % "scala-reflect" % scalaVersion.value
  ))

  val scalajs = Def.setting(Seq(
    "org.scala-js" %%% "scala-js-macrotask-executor" % "1.0.0",
    "org.scala-js" % "scalajs-fake-insecure-java-securerandom_sjs1_2.13" % "1.0.0",
    "com.vmunier" %% "scalajs-scripts" % "1.3.0"
  ))

  val scalapy = Def.setting(Seq(
    "me.shadaj" %%% "scalapy-core" % "0.5.2",
    "ai.kien"   %% "python-native-libs" % "0.2.4"
  ))

  val sisu = Def.setting(Seq(
    "org.eclipse.sisu" % "org.eclipse.sisu.inject" % "0.3.5",
    "org.eclipse.sisu" % "org.eclipse.sisu.plexus" % "0.3.5"
  ))

  val slinkyVersion = "0.7.4+17-f74988fd"
  val slinky = Def.setting(Seq(
    "me.shadaj" %%% "slinky-core" % slinkyVersion,
    "me.shadaj" %%% "slinky-readwrite" % slinkyVersion,
    "me.shadaj" %%% "slinky-web" % slinkyVersion,
  ))

  val sparkVersion = "3.5.1"
  val spark = Def.setting {
    Seq(
      "org.apache.spark" % "spark-core_2.13" % sparkVersion,
      "org.apache.spark" % "spark-hive_2.13" % sparkVersion,
      "org.apache.spark" % "spark-mllib_2.13" % sparkVersion,
      "org.apache.spark" % "spark-sql_2.13" % sparkVersion,
      "org.apache.spark" % "spark-streaming_2.13" % sparkVersion
    )
  }

  val sparkWithConfigs = (version: String, configurations: Seq[String]) => Def.setting {
    configurations.flatMap(c => {
      Seq(
        "org.apache.spark" %% "spark-core_2.13" % version % c,
        "org.apache.spark" %% "spark-hive_2.13" % version % c,
        "org.apache.spark" %% "spark-mllib_2.13" % version % c,
        "org.apache.spark" %% "spark-sql_2.13" % version % c,
        "org.apache.spark" %% "spark-streaming_2.13" % version % c,
      )
    })
  }

  val sttp = Def.setting(Seq(
    "com.softwaremill.sttp.client3" %%% "core" % "3.3.18",
    "com.softwaremill.sttp.client3" %%% "circe" % "3.3.18"
  ))

  val testing = Def.setting(Seq(
    "org.assertj" % "assertj-core" % "3.26.3" % Test,
    "org.awaitility" % "awaitility" % "4.2.1" % Test,
    "net.aichler" % "jupiter-interface" % "0.11.1" % Test,
    "org.scalatest" %%% "scalatest" % "3.2.12" % Test,
    "org.scalatestplus" %% "scalacheck-1-15" % "3.2.11.0" % Test,
    "org.scalatestplus" %% "mockito-4-5" % "3.2.12.0" % Test,
    "org.mockito" % "mockito-core" % "5.11.0" % Test,
    "com.github.tomakehurst" % "wiremock" % "3.0.1" % Test exclude ("com.google.guava", "guava") excludeJackson
  ))

  val vertxVersion = "4.5.9"
  val vertx = Def.setting(Seq(
    "io.vertx" % "vertx-auth-jwt" % vertxVersion,
    "io.vertx" % "vertx-codegen" % vertxVersion,
    "io.vertx" % "vertx-config-git" % vertxVersion,
    "io.vertx" % "vertx-core" % vertxVersion excludeAll "io.netty",
    "io.vertx" % "vertx-health-check" % vertxVersion,
    "io.vertx" % "vertx-micrometer-metrics" % vertxVersion,
    "io.vertx" % "vertx-reactive-streams" % vertxVersion,
    "io.vertx" % "vertx-service-discovery-bridge-kubernetes" % vertxVersion,
    "io.vertx" % "vertx-tcp-eventbus-bridge" % vertxVersion,
    "io.vertx" % "vertx-unit" % vertxVersion,
    "io.vertx" % "vertx-web" % vertxVersion,
    "io.vertx" % "vertx-web-client" % vertxVersion,
    "io.vertx" % "vertx-web-sstore-cookie" % vertxVersion,
    "io.vertx" % "vertx-web-templ-handlebars" % vertxVersion,
    "io.vertx" % "vertx-zookeeper" % vertxVersion
  ))

  val vfs = Def.setting(Seq(
    "org.apache.commons" % "commons-vfs2" % "2.9.0",
    "org.apache.commons" % "commons-vfs2-jackrabbit2" % "2.9.0",
    "com.github.abashev" % "vfs-s3" % "4.4.0"
  ))

  val zio1 = Def.setting(Seq(
    "dev.zio" %% "zio" % "1.0.18",
    "dev.zio" %% "zio-interop-cats" % "3.2.9.1",
    "dev.zio" %% "zio-interop-reactivestreams" % "1.3.12",
    "dev.zio" %% "zio-macros" % "1.0.18",
    "dev.zio" %% "zio-process" % "0.7.2",
    "dev.zio" %% "zio-streams" % "1.0.14",
    "dev.zio" %% "zio-test" % "1.0.18" % "test",
    "dev.zio" %% "zio-test-sbt" % "1.0.18" % "test",
    "dev.zio" %% "zio-test-magnolia" % "1.0.18" % "test"
  ))

  val zio2 = Def.setting(Seq(
    "dev.zio" %% "zio" % "2.1.11",
    "dev.zio" %% "zio-interop-cats" % "23.1.0.3",
    "dev.zio" %% "zio-interop-reactivestreams" % "2.0.2",
    "dev.zio" %% "zio-macros" % "2.1.11",
    "dev.zio" %% "zio-process" % "0.7.2",
    "dev.zio" %% "zio-streams" % "2.1.6",
    "dev.zio" %% "zio-test" % "2.1.5" % "test",
    "dev.zio" %% "zio-test-sbt" % "2.1.6" % "test",
    "dev.zio" %% "zio-test-magnolia" % "2.1.6" % "test"
  ))

  val airtable = Def.setting("dev.fuxing" % "airtable-api" % "0.3.2")
  val auth0 = Def.setting("com.auth0" % "auth0" % "2.11.0")
  val automapper = Def.setting("io.bfil"  %% "automapper" % "0.7.0")
  val avro4s = Def.setting("com.sksamuel.avro4s" %% "avro4s-core" % "4.1.2")
  val awsJavaCloudfront = Def.setting("com.amazonaws" % "aws-java-sdk-cloudfront" % "1.12.765" excludeJackson)
  val awsJavaSes = Def.setting("com.amazonaws" % "aws-java-sdk-ses" % "1.12.765")
  val awsJavaS3 = Def.setting("com.amazonaws" % "aws-java-sdk-s3" % "1.12.765" excludeJackson)
  val awsScalaIam = Def.setting("com.github.seratch" %% "awscala-iam" % "0.9.2")
  val awsScalaS3 = Def.setting("com.github.seratch" %% "awscala-s3" % "0.9.2")
  val betterFiles = Def.setting("com.github.pathikrit" %% "better-files" % "3.9.2")
  val bouncycastle = Def.setting("org.bouncycastle" % "bcprov-jdk18on" % "1.78.1")
  val calciteCore = Def.setting("org.apache.calcite" % "calcite-core" % "1.37.0")
  val chargebee = Def.setting("com.chargebee" % "chargebee-java" % "3.17.2")
  val chimney = Def.setting("io.scalaland" %% "chimney" % "1.3.0")
  val commonsCodec = Def.setting("commons-codec" % "commons-codec" % "1.17.0")
  val commonsCsv = Def.setting("org.apache.commons" % "commons-csv" % "1.10.0")
  val commonsEmail = Def.setting("org.apache.commons" % "commons-email" % "1.5")
  val commonsIo = Def.setting("commons-io" % "commons-io" % "2.16.1")
  val commonsLang3 = Def.setting("org.apache.commons" % "commons-lang3" % "3.15.0")
  val commonsText = Def.setting("org.apache.commons" % "commons-text" % "1.11.0")
  val config = Def.setting("com.typesafe" % "config" % "1.4.3")
  val deepstream = Def.setting("io.deepstream" % "deepstream.io-client-java" % "2.2.2")
  val facebook = Def.setting("com.facebook.business.sdk" % "facebook-java-business-sdk" % "19.0.3" excludeOkio)
  val ficus = Def.setting("com.iheart" %% "ficus" % "1.5.2")
  val fst = Def.setting("de.ruedigermoeller" % "fst" % "3.0.3")
  val graalvm = Def.setting("org.graalvm.sdk" % "graal-sdk" % "24.0.1")
  val gson = Def.setting("com.google.code.gson" % "gson" % "2.10.1")
  val guava = Def.setting("com.google.guava" % "guava" % "33.2.1-jre")
  val guice = Def.setting("com.google.inject" % "guice" % "7.0.0")
  val handlebars = Def.setting("com.github.jknack" % "handlebars" % "4.4.0")
  val httpCore = Def.setting("org.apache.httpcomponents.core5" % "httpcore5" % "5.2.4")
  val izumiReflect = Def.setting("dev.zio" %%% "izumi-reflect" % "2.2.0")
  val jasyncfio = Def.setting("one.jasyncfio" % "jasyncfio" % "0.0.8" classifier "linux-amd64")
  val javaMail = Def.setting("com.sun.mail" % "jakarta.mail" % "2.0.1")
  val javassist = Def.setting("org.javassist" % "javassist" % "3.23.0-GA")
  val javaWebsocket = Def.setting("org.java-websocket" % "Java-WebSocket" % "1.5.6")
  val javaxAnnotations = Def.setting("javax.annotation" % "javax.annotation-api" % "1.3.2")
  val javaxInject = Def.setting("javax.inject" % "javax.inject" % "1")
  val jbrowserDriver = Def.setting("com.machinepublishers" % "jbrowserdriver" % "1.1.1")
  val jgit = Def.setting("org.eclipse.jgit" % "org.eclipse.jgit" % "6.9.0.202403050737-r")
  val jose = Def.setting("com.nimbusds" % "nimbus-jose-jwt" % "9.40")
  val jose4j = Def.setting("org.bitbucket.b_c" % "jose4j" % "0.9.6")
  val jsch = Def.setting("com.jcraft" % "jsch" % "0.1.55")
  val json = Def.setting("org.json" % "json" % "20240303")
  val jsonLenses = Def.setting("net.virtual-void" %% "json-lenses" % "0.6.2" excludeSprayJson)
  val jsoup = Def.setting("org.jsoup" % "jsoup" % "1.17.2")
  val jsr305 = Def.setting("com.google.code.findbugs" % "jsr305" % "3.0.2")
  val junixSocketCommon = Def.setting("com.kohlschutter.junixsocket" % "junixsocket-common" % "2.10.0")
  val kryo = Def.setting("com.esotericsoftware" % "kryo" % "5.5.0")
  val kubernetesClient = Def.setting("io.kubernetes" % "client-java" % "20.0.1")
  val meilisearch = Def.setting("com.meilisearch.sdk" % "meilisearch-java" % "0.12.0")
  val mixpanel = Def.setting("com.mixpanel" % "mixpanel-java" % "1.5.2")
  val mongodbScala = Def.setting("org.mongodb.scala" %% "mongo-scala-driver" % "5.1.1")
  val nscalaTime = Def.setting("com.github.nscala-time" %% "nscala-time" % "2.32.0")
  val ognl = Def.setting("ognl" % "ognl" % "3.4.3")
  val ohc = Def.setting("org.caffinitas.ohc" % "ohc-core" % "0.7.4")
  val opencsv = Def.setting("com.opencsv" % "opencsv" % "5.9")
  val parboiled = Def.setting("org.parboiled" %% "parboiled" % "2.5.1")
  val playJsonExtensions = Def.setting("ai.x" %% "play-json-extensions" % "0.42.0")
  val plexusUtils = Def.setting("org.codehaus.plexus" % "plexus-utils" % "4.0.1")
  val pureCsv = Def.setting("io.kontainers" %% "purecsv" % "1.3.10")
  val rabbitmq = Def.setting("com.newmotion" %% "akka-rabbitmq" % "6.0.0" excludeAkkaActor)
  val redisson = Def.setting("org.redisson" % "redisson" % "3.33.0")
  val reflections = Def.setting("org.reflections" % "reflections" % "0.10.2")
  val scaffeine = Def.setting("com.github.blemale" %% "scaffeine" % "5.3.0")
  val scalaHashing = Def.setting("com.desmondyeung.hashing"%% "scala-hashing" % "0.1.0")
  val scalajsDom = Def.setting("org.scala-js" %%% "scalajs-dom" % "2.8.0")
  val scalajsStubs = Def.setting("org.scala-js" %% "scalajs-stubs" % "1.1.0")
  val scalate = Def.setting("org.scalatra.scalate" %% "scalate-core" % "1.10.1")
  val scalazCore = Def.setting("org.scalaz" %%% "scalaz-core" % "7.3.3")
  val scopt = Def.setting("com.github.scopt" %% "scopt" % "4.1.0")
  val segment = Def.setting("com.segment.analytics.java" % "analytics" % "3.5.1")
  val sentry = Def.setting("io.sentry" % "sentry" % "7.12.1")
  val shapeless = Def.setting("com.chuusai" % "shapeless_2.13" % "2.3.12")
  val shopify = Def.setting("com.channelape" % "shopify-sdk" % "2.9.2" excludeAll(ExclusionRule(organization = "com.sun.xml.bind")))
  val siteCrawler = Def.setting("io.github.jasperroel" % "SiteCrawler" % "1.0.0")
  val skuber = Def.setting("io.github.hagay3" %% "skuber" % "4.0.3")
  val slack = Def.setting("com.hubspot.slack" % "slack-java-client" % "1.15.1")
  val snappy = Def.setting("org.xerial.snappy" % "snappy-java" % "1.1.9.1")
  val sourcecode = Def.setting("com.lihaoyi" %% "sourcecode" % "0.4.1")
  val sparkGCSConnector = Def.setting("com.google.cloud.bigdataoss" % "gcs-connector" % "3.0.1" classifier "shaded")
  val sprayJson = Def.setting("io.spray" %%% "spray-json" % "1.4.0")
  val squants = Def.setting("org.typelevel"  %%% "squants" % "1.8.3")
  val sshj = Def.setting("com.hierynomus" % "sshj" % "0.38.0")
  val stripe = Def.setting("com.stripe" % "stripe-java" % "26.5.1")
  val sttpQuicklens = Def.setting("com.softwaremill.quicklens" %%% "quicklens" % "1.9.9")
  val sundial = Def.setting("org.knowm" % "sundial" % "2.2.2")
  val thumbnailator = Def.setting("net.coobird" % "thumbnailator" % "0.4.20")
  val ulid = Def.setting("net.petitviolet" %% "ulid4s" % "0.5.0")
  val unboundid = Def.setting("com.unboundid" % "unboundid-ldapsdk" % "7.0.1")
  val univocity = Def.setting("com.univocity" % "univocity-parsers" % "2.9.1")
  val upickle = Def.setting("com.lihaoyi" %%% "upickle" % "1.4.3")
  val webjarsLocator = Def.setting("org.webjars" % "webjars-locator-core" % "0.59")
  val xmlApis = Def.setting("xml-apis" % "xml-apis" % "2.0.2")
  val youiClient = Def.setting("io.youi" %% "youi-client" % "0.14.4")
  val zendeskClient = Def.setting("com.cloudbees.thirdparty" % "zendesk-java-client" % "1.0.0")
  val zeroAllocationHashing = Def.setting("net.openhft" % "zero-allocation-hashing" % "0.16")
  val zip4j = Def.setting("net.lingala.zip4j" % "zip4j" % "2.11.5")
  val zstd = Def.setting("com.github.luben" % "zstd-jni" % "1.5.6-4")
  val ztZip = Def.setting("org.zeroturnaround" % "zt-zip" % "1.17")

  // Dependencies for swagger-client generated code
  val oauth2Client = Def.setting("org.apache.oltu.oauth2" % "org.apache.oltu.oauth2.client" % "1.0.2")
  val swaggerAnnotations = Def.setting("io.swagger.corev3" % "swagger-annotations" % "2.2.21")
  val jodaTime = Def.setting("joda-time" % "joda-time" % "2.12.7")

  // Scala.js
  val scalablyTyped = Def.setting("com.olvind" %%% "scalablytyped-runtime" % "2.4.2")
  val scalajsJavaTime = Def.setting("io.github.cquiroz" %%% "scala-java-time" % "2.5.0")
  val scalajsSecureRandom = Def.setting("org.scala-js" %%% "scalajs-java-securerandom" % "1.0.0")

  val resolvers = Seq(
    Resolver.mavenLocal,
    Resolver.githubPackages("harana"),
    Resolver.jcenterRepo,
    Resolver.sonatypeOssRepos("releases").head,
    Resolver.sonatypeOssRepos("snapshots").head,
    Resolver.url("heroku-sbt-plugin-releases", url("https://dl.bintray.com/heroku/sbt-plugins/"))(Resolver.ivyStylePatterns),
    "airbyte"                 at "https://airbyte.mycloudrepo.io/public/repositories/airbyte-public-jars",
    "jitpack"                 at "https://jitpack.io",
    "mulesoft"                at "https://repository.mulesoft.org/nexus/content/repositories/public/",
    "orientdb"                at "https://dl.bintray.com/sbcd90/org.apache.spark",
    "ossrh"                   at "https://oss.sonatype.org/service/local/staging/deploy/maven2",
    "shibboleth"              at "https://build.shibboleth.net/nexus/content/repositories/releases/",
    "sonatype"                at "https://oss.sonatype.org/content/repositories/releases",
    "spark-packages"          at "https://dl.bintray.com/spark-packages/maven",
    "typesafe"                at "https://repo.typesafe.com/typesafe/releases/",
    "typesafe.com"            at "https://repo.typesafe.com/typesafe/repo/"
  )
}

