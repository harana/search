package com.harana.sbt.common

import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport.*
import sbt.Keys.{resolvers, scalaVersion}
import sbt.*
import sbtghpackages.GitHubPackagesPlugin.autoImport.*

import scala.language.postfixOps
import com.here.bom.Bom

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

  implicit class RichModuleID(m: ModuleID) {
    def excludeAkkaActor = m excludeAll ExclusionRule("com.typesafe.akka")
    def excludeJackson = m excludeAll ExclusionRule("com.fasterxml.jackson.core")
    def excludeGuava = m excludeAll ExclusionRule("com.google.guava", "guava")
    def excludeOkio = m excludeAll ExclusionRule("com.squareup.okio", "okio")
    def excludeScalatest = m excludeAll ExclusionRule("org.scalatest")
    def excludeSprayJson = m excludeAll ExclusionRule("io.spray")
    def excludeScalaJs = m excludeAll ExclusionRule("org.scala-js")
    def excludeScalaJsDom = m excludeAll ExclusionRule("org.scala-js", "scalajs-dom_sjs1")
  }

  val airbyte = Def.setting(Seq(
    "io.airbyte" % "airbyte-api" % "0.40.6",
    "io.airbyte.airbyte-protocol" % "protocol-models" % "0.40.6"
  ))

  val akka = Def.setting(Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.8.8",
    "com.typesafe.akka" %% "akka-http-core" % "10.5.3",
    "com.typesafe.akka" %% "akka-http-spray-json" % "10.5.3" excludeSprayJson,
    "com.typesafe.akka" %% "akka-slf4j" % "2.8.8",
    "com.typesafe.akka" %% "akka-testkit" % "2.8.8",
    "com.typesafe.akka" %% "akka-protobuf-v3" % "2.8.8",
    "com.typesafe.akka" %% "akka-stream" % "2.8.8"
  ))

  val alluxio = Def.setting(Seq(
    "org.alluxio" % "alluxio-core-client" % "313" exclude("io.netty", "netty-all"),
    "org.alluxio" % "alluxio-core-client-fs" % "313" exclude("io.netty", "netty-all"),
    "org.alluxio" % "alluxio-job-client" % "313" exclude("io.netty", "netty-all")
  ))

  val asm = Def.setting(Seq(
  "org.ow2.asm" % "asm" % "6.0",
    "org.ow2.asm" % "asm-commons" % "6.0",
    "org.ow2.asm" % "asm-tree" % "6.0"
  ))

  val awsS3v1 = Def.setting(Seq(
    "com.amazonaws" % "aws-java-sdk-s3" % "1.12.783"
  ))

  val awsS3v2Version = "2.31.53"
  val awsS3v2 = Def.setting(Seq(
    "software.amazon.awssdk" % "cloudfront" % awsS3v2Version,
    "software.amazon.awssdk" % "iam" % awsS3v2Version,
    "software.amazon.awssdk" % "s3" % awsS3v2Version,
    "software.amazon.awssdk" % "s3-transfer-manager" % awsS3v2Version,
    "software.amazon.awssdk.crt" % "aws-crt" % "0.38.3"
  ))

  val circe = Def.setting(Seq(
    "io.circe" %%% "circe-core" % "0.14.6",
    "io.circe" %%% "circe-generic" % "0.14.6",
    "io.circe" %%% "circe-optics" % "0.15.0",
    "io.circe" %%% "circe-parser" % "0.14.6",
    "io.circe" %% "circe-yaml" % "1.15.0",
    "org.latestbit" %%% "circe-tagged-adt-codec" % (if (scalaVersion.value.startsWith("3")) "0.11.0" else "0.10.0"),
    "com.beachape" %%% "enumeratum-circe" % "1.7.5",
    "com.filippodeluca" %% "jsonpath-parser" % "1.0.1",
    "com.filippodeluca" %% "jsonpath-circe" % "1.0.1"
  ))

  val compilerPlugins = Seq()

  val dockerJava = Def.setting(Seq(
    "com.github.docker-java" % "docker-java" % "3.5.1",
    "com.github.docker-java" % "docker-java-transport-zerodep" % "3.5.1"
  ))

  val googleCloud = Def.setting(Seq(
    "com.google.cloud"      % "google-cloud-dialogflow" % "4.69.0",
    "com.google.cloud"      % "google-cloud-document-ai" % "2.67.0",
    "com.google.cloud"      % "google-cloud-kms" % "2.66.0",
    "com.google.cloud"      % "google-cloud-pubsub" % "1.139.4",
    "com.google.cloud"      % "google-cloud-secretmanager" % "2.63.0",
    "com.google.cloud"      % "google-cloud-storage" % "2.52.3",
  ).map(_.excludeJackson.exclude("com.google.guava", "guava-jdk5")))

  val hadoopVersion = "3.4.1"
  val hadoop = Def.setting(Seq(
    "org.apache.hadoop" % "hadoop-aws" % hadoopVersion,
    "org.apache.hadoop" % "hadoop-client" % hadoopVersion,
    "org.apache.hadoop" % "hadoop-common" % hadoopVersion
  ))

  val http4sVersion = "1.0.0-M44"
  val http4s = Def.setting(Seq(
    "org.http4s" %%% "http4s-circe" % http4sVersion,
    "org.http4s" %%% "http4s-dsl" % http4sVersion,
    "org.http4s" %%% "http4s-ember-server" % http4sVersion,
  ))

  val jacksonVersion = "2.19.0"
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

  val json4sVersion = "3.7.0-M11"
  val json4s = Def.setting(Seq(
    "org.json4s" %% "json4s-core" % json4sVersion,
    "org.json4s" %% "json4s-native" % json4sVersion,
    "org.json4s" %% "json4s-jackson" % json4sVersion,
    "org.json4s" %% "json4s-ext" % json4sVersion
  ))

  val langchain4j = Def.setting(Seq(
    "dev.langchain4j" % "langchain4j" % "1.0.1",
    "dev.langchain4j" % "langchain4j-azure-open-ai" % "1.0.1-beta6",
    "dev.langchain4j" % "langchain4j-google-ai-gemini" % "1.0.1-beta6",
    "dev.langchain4j" % "langchain4j-mcp" % "1.0.1-beta6"
  ))

  val log4jVersion = "2.24.3"
  val logging = Def.setting(Seq(
    "org.apache.logging.log4j"  % "log4j-api" % log4jVersion,
    "org.apache.logging.log4j"  % "log4j-1.2-api" % log4jVersion,
    "org.apache.logging.log4j"  % "log4j-core" % log4jVersion,
    "org.apache.logging.log4j"  % "log4j-slf4j-impl" % log4jVersion,
    "org.apache.logging.log4j"  % "log4j-web" % log4jVersion,
    "org.slf4j"                 % "slf4j-api" % "2.0.17"
  ))

  val luceneVersion = "10.2.1"
  val lucene = Def.setting(Seq(
    "org.apache.lucene" % "lucene-core" % luceneVersion,
    "org.apache.lucene" % "lucene-queryparser" % luceneVersion
  ))

  val micrometer = Def.setting(Seq(
    "io.github.mweirauch" % "micrometer-jvm-extras" % "0.2.2",
    "io.micrometer" % "micrometer-registry-prometheus" % "1.15.0",
    "io.micrometer" % "micrometer-registry-prometheus-simpleclient" % "1.15.0"
  ))

  val netty = Def.setting(Seq(
    "io.netty"            % "netty-resolver-dns-native-macos"             % "4.2.1.Final" classifier "osx-aarch_64",
    "io.netty"            % "netty-resolver-dns-native-macos"             % "4.2.1.Final" classifier "osx-x86_64",
    "io.netty"            % "netty-transport-native-epoll"                % "4.2.0.Final" classifier "linux-x86_64",
    "io.netty.incubator"  % "netty-incubator-transport-native-io_uring"   % "0.0.26.Final" classifier "linux-x86_64"
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
    "org.apache.felix" % "org.apache.felix.configadmin" % "1.9.26",
    "org.apache.felix" % "org.apache.felix.bundlerepository" % "2.0.10",
    "org.osgi" % "org.osgi.core" % "6.0.0"
  ))

  val pac4jVersion = "6.1.3"
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
    "com.github.mjakubowski84"  %% "parquet4s-core" % "2.22.0",
    "org.apache.parquet" % "parquet-avro" % "1.15.2"
  ))

  val sapVersion = "5.19.0"
  val sap = Def.setting(Seq(
    "com.sap.cloud.sdk.cloudplatform" % "cloudplatform-core" % sapVersion,
    "com.sap.cloud.sdk.cloudplatform" % "cloudplatform-connectivity" % sapVersion,
    "com.sap.cloud.sdk.datamodel" % "fluent-result" % sapVersion,
    "com.sap.cloud.sdk.datamodel" % "odata-client" % sapVersion,
    "com.sap.cloud.sdk.datamodel" % "odata-v4-core" % sapVersion,
    "com.sap.cloud.sdk.datamodel" % "odata-generator-utility" % sapVersion,
    "com.sap.cloud.sdk.datamodel" % "odata-v4-generator" % sapVersion,
    "com.sap.cloud.sdk.s4hana" % "s4hana-core" % sapVersion,
    "com.sap.cloud.sdk.s4hana" % "s4hana-connectivity" % sapVersion
  ))

  val sapBom = Bom.dependencies("com.sap.cloud.sdk" % "sdk-bom" % "5.19.0")

  val scala2 = Def.setting(Seq(
    "org.scala-lang" % "scala-compiler" % "2.13.16",
    "org.scala-lang" % "scala-library" % "2.13.16"
  ))

  val scala3 = Def.setting(Seq(
    "org.scala-lang" %%% "scala3-compiler" % scalaVersion.value,
    "org.scala-lang" %%% "scala3-library" % scalaVersion.value
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

  val skuberVersion = "3.0.0-beta7"
  val skuber = Def.setting(Seq(
    "io.skuber" %%% "skuber-core" % skuberVersion,
    "io.skuber" %%% "skuber-pekko" % skuberVersion
  ))

  val slinkyVersion = "0.7.5+12-4397ac09+20250531-1259"
  val slinky = Def.setting(Seq(
    "me.shadaj" %%% "slinky-core" % slinkyVersion,
    "me.shadaj" %%% "slinky-readwrite" % slinkyVersion,
    "me.shadaj" %%% "slinky-web" % slinkyVersion
  ))

  val sparkVersion = "4.0.0"
  val spark = Def.setting {
    Seq(
      "org.apache.spark" % "spark-core_2.13" % sparkVersion,
      "org.apache.spark" % "spark-hive_2.13" % sparkVersion,
      "org.apache.spark" % "spark-sql_2.13" % sparkVersion,
      "org.apache.spark" % "spark-streaming_2.13" % sparkVersion
    )
  }

  val sparkWithConfigs = (version: String, configurations: Seq[String]) => Def.setting {
    configurations.flatMap(c => {
      Seq(
        "org.apache.spark" %% "spark-core_2.13" % version % c,
        "org.apache.spark" %% "spark-hive_2.13" % version % c,
        "org.apache.spark" %% "spark-sql_2.13" % version % c,
        "org.apache.spark" %% "spark-streaming_2.13" % version % c,
      )
    })
  }

  val sttpVersion = "4.0.7"
  val sttp = Def.setting(Seq(
    "com.softwaremill.sttp.client4" %% "armeria-backend-zio" % sttpVersion,
    "com.softwaremill.sttp.client4" %%% "core" % sttpVersion,
    "com.softwaremill.sttp.client4" %%% "circe" % sttpVersion,
    "com.softwaremill.sttp.client4" %%% "zio" % sttpVersion,
    "com.softwaremill.sttp.client4" %%% "zio-json" % sttpVersion
  ))

  val testing = Def.setting(Seq(
    "org.assertj" % "assertj-core" % "3.27.3" % Test,
    "org.awaitility" % "awaitility" % "4.3.0" % Test,
    "net.aichler" % "jupiter-interface" % "0.11.1" % Test,
    "org.scalatest" %%% "scalatest" % "3.2.12" % Test,
    "org.scalatestplus" %% "scalacheck-1-15" % "3.2.11.0" % Test,
    "org.scalatestplus" %% "mockito-4-5" % "3.2.12.0" % Test,
    "org.mockito" % "mockito-core" % "5.18.0" % Test,
    "com.github.tomakehurst" % "wiremock" % "3.0.1" % Test exclude ("com.google.guava", "guava") excludeJackson
  ))

  val velocityVersion = "2.4.1"
  val velocity = Def.setting(Seq(
    "org.apache.velocity" % "velocity-engine-core" % velocityVersion,
  ))

  val vertxVersion = "4.5.14"
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
    "io.vertx" % "vertx-zookeeper" % vertxVersion,
    "io.vertx" % "vertx-zookeeper" % vertxVersion,
    "org.pac4j" % "vertx-pac4j" % "6.0.3"
  ))

  val vfs = Def.setting(Seq(
    "org.apache.commons" % "commons-vfs2" % "2.10.0",
    "org.apache.commons" % "commons-vfs2-jackrabbit2" % "2.10.0",
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

  val zio2Version = "2.1.19"
  val zio2 = Def.setting(Seq(
    "dev.zio" %% "zio" % zio2Version,
    "dev.zio" %% "zio-config" % "4.0.4",
    "dev.zio" %% "zio-config-typesafe" % "4.0.4",
    "dev.zio" %% "zio-http" % "3.3.3",
    "dev.zio" %% "zio-interop-cats" % "23.1.0.5",
    "dev.zio" %% "zio-interop-reactivestreams" % "2.0.2",
    "dev.zio" %% "zio-macros" % zio2Version,
    "dev.zio" %% "zio-streams" % zio2Version,
    "dev.zio" %% "zio-test" % zio2Version % "test",
    "dev.zio" %% "zio-test-sbt" % zio2Version % "test",
    "dev.zio" %% "zio-test-magnolia" % zio2Version % "test"
  ))

  val airtable = Def.setting("dev.fuxing" % "airtable-api" % "0.3.2")
  val auth0 = Def.setting("com.auth0" % "auth0" % "2.21.0")
  val automapper = Def.setting("io.bfil"  %% "automapper" % "0.7.0")
  val avro4s = Def.setting("com.sksamuel.avro4s" %% "avro4s-core" % "5.0.14")
  val awsJavaCloudfront = Def.setting("com.amazonaws" % "aws-java-sdk-cloudfront" % "1.12.783" excludeJackson)
  val awsJavaSes = Def.setting("com.amazonaws" % "aws-java-sdk-ses" % "1.12.783")
  val awsJavaS3 = Def.setting("com.amazonaws" % "aws-java-sdk-s3" % "1.12.783" excludeJackson)
  val awsScalaIam = Def.setting("com.github.seratch" %% "awscala-iam" % "0.9.2")
  val awsScalaS3 = Def.setting("com.github.seratch" %% "awscala-s3" % "0.9.2")
  val azureOpenAi = Def.setting("com.azure" %% "azure-ai-openai" % "1.0.0-beta.16")
  val betterFiles = Def.setting("com.github.pathikrit" %% "better-files" % "3.9.2")
  val bouncycastle = Def.setting("org.bouncycastle" % "bcprov-jdk18on" % "1.80")
  val calciteCore = Def.setting("org.apache.calcite" % "calcite-core" % "1.40.0")
  val caliban = Def.setting("com.github.ghostdogpr" %%% "caliban-client" % "2.10.0")
  val chargebee = Def.setting("com.chargebee" % "chargebee-java" % "3.32.0")
  val chimney = Def.setting("io.scalaland" %% "chimney" % "1.8.1")
  val commonsCodec = Def.setting("commons-codec" % "commons-codec" % "1.18.0")
  val commonsCsv = Def.setting("org.apache.commons" % "commons-csv" % "1.14.0")
  val commonsEmail = Def.setting("org.apache.commons" % "commons-email2-jakarta" % "2.0.0-M1")
  val commonsIo = Def.setting("commons-io" % "commons-io" % "2.19.0")
  val commonsLang3 = Def.setting("org.apache.commons" % "commons-lang3" % "3.17.0")
  val commonsText = Def.setting("org.apache.commons" % "commons-text" % "1.13.1")
  val config = Def.setting("com.typesafe" % "config" % "1.4.3")
  val facebook = Def.setting("com.facebook.business.sdk" % "facebook-java-business-sdk" % "22.0.3" excludeOkio)
  val ficus = Def.setting("com.iheart" %% "ficus" % "1.5.2")
  val flexmark = Def.setting("com.vladsch.flexmark" % "flexmark-all" % "0.64.8")
  val fst = Def.setting("de.ruedigermoeller" % "fst" % "3.0.3")
  val graalvm = Def.setting("org.graalvm.sdk" % "graal-sdk" % "24.2.1")
  val gson = Def.setting("com.google.code.gson" % "gson" % "2.13.1")
  val guava = Def.setting("com.google.guava" % "guava" % "33.4.8-jre")
  val guice = Def.setting("com.google.inject" % "guice" % "7.0.0")
  val handlebars = Def.setting("com.github.jknack" % "handlebars" % "4.4.0")
  val hash4j = Def.setting("com.dynatrace.hash4j" % "hash4j" % "0.22.0")
  val httpCore = Def.setting("org.apache.httpcomponents.core5" % "httpcore5" % "5.3.4")
  val izumiReflect = Def.setting("dev.zio" %%% "izumi-reflect" % "2.2.0")
  val jasyncfio = Def.setting("one.jasyncfio" % "jasyncfio" % "0.0.8" classifier "linux-amd64")
  val jakartaMail = Def.setting("jakarta.mail" % "jakarta.mail-api" % "2.1.3")
  val javassist = Def.setting("org.javassist" % "javassist" % "3.30.2-GA")
  val javaWebsocket = Def.setting("org.java-websocket" % "Java-WebSocket" % "1.6.0")
  val javaxAnnotations = Def.setting("javax.annotation" % "javax.annotation-api" % "1.3.2")
  val javaxInject = Def.setting("javax.inject" % "javax.inject" % "1")
  val jbrowserDriver = Def.setting("com.machinepublishers" % "jbrowserdriver" % "1.1.1")
  val jgit = Def.setting("org.eclipse.jgit" % "org.eclipse.jgit" % "7.2.1.202505142326-r")
  val jose = Def.setting("com.nimbusds" % "nimbus-jose-jwt" % "10.3")
  val jose4j = Def.setting("org.bitbucket.b_c" % "jose4j" % "0.9.6")
  val jsch = Def.setting("com.jcraft" % "jsch" % "0.1.55")
  val json = Def.setting("org.json" % "json" % "20250517")
  val jsonLenses = Def.setting("net.virtual-void" %% "json-lenses" % "0.6.2" excludeSprayJson)
  val jsoup = Def.setting("org.jsoup" % "jsoup" % "1.20.1")
  val jsr305 = Def.setting("com.google.code.findbugs" % "jsr305" % "3.0.2")
  val junixSocketCommon = Def.setting("com.kohlschutter.junixsocket" % "junixsocket-common" % "2.10.1")
  val kryo = Def.setting("com.esotericsoftware" % "kryo" % "5.6.2")
  val kubernetesClient = Def.setting("io.kubernetes" % "client-java" % "24.0.0")
  val lombok = Def.setting("org.projectlombok" % "lombok" % "1.18.38")
  val macwire = Def.setting("com.softwaremill.macwire" %% "macros" % "2.6.6" % "provided")
  val meilisearch = Def.setting("com.meilisearch.sdk" % "meilisearch-java" % "0.14.6")
  val mixpanel = Def.setting("com.mixpanel" % "mixpanel-java" % "1.5.3")
  val mongodbScala = Def.setting("org.mongodb.scala" % "mongo-scala-driver_2.13" % "5.5.0")
  val neo4j = Def.setting("org.neo4j.driver" % "neo4j-java-driver" % "5.28.5")
  val nscalaTime = Def.setting("com.github.nscala-time" %% "nscala-time" % "3.0.0")
  val ognl = Def.setting("ognl" % "ognl" % "3.4.7")
  val ohc = Def.setting("org.caffinitas.ohc" % "ohc-core" % "0.7.4")
  val opencsv = Def.setting("com.opencsv" % "opencsv" % "5.11")
  val outrStripe = Def.setting("com.outr" %%% "scala-stripe" % "1.1.32")
  val parboiled = Def.setting("org.parboiled" %% "parboiled" % "2.5.1")
  val pdfBox = Def.setting("org.apache.pdfbox" %% "pdfbox" % "3.0.3")
  val playExtensions = Def.setting("ai.x" % "play-json-extensions_2.13" % "0.42.0")
  val plexusUtils = Def.setting("org.codehaus.plexus" % "plexus-utils" % "4.0.2")
  val rabbitmq = Def.setting("com.newmotion" %% "akka-rabbitmq" % "6.0.0" excludeAkkaActor)
  val redisson = Def.setting("org.redisson" % "redisson" % "3.48.0")
  val reflections = Def.setting("org.reflections" % "reflections" % "0.10.2")
  val scaffeine = Def.setting("com.github.blemale" %% "scaffeine" % "5.3.0")
  val scalaHashing = Def.setting("com.desmondyeung.hashing"%% "scala-hashing" % "0.1.0")
  val scalaXml = Def.setting("org.scala-lang.modules" %%% "scala-xml" % "2.3.0")
  val scalajsDom = Def.setting("org.scala-js" %%% "scalajs-dom" % "2.8.0")
  val scalajsStubs = Def.setting("org.scala-js" %%% "scalajs-stubs" % "1.1.0")
  val scalate = Def.setting("org.scalatra.scalate" %% "scalate-core" % "1.10.1")
  val scalazCore = Def.setting("org.scalaz" %%% "scalaz-core" % "7.3.3")
  val scopt = Def.setting("com.github.scopt" %% "scopt" % "4.1.0")
  val segment = Def.setting("com.segment.analytics.java" % "analytics" % "3.5.2")
  val sentry = Def.setting("io.sentry" % "sentry" % "8.13.2")
  val shapeless = Def.setting("com.chuusai" % "shapeless_2.13" % "2.3.13")
  val shopify = Def.setting("com.channelape" % "shopify-sdk" % "2.9.3" excludeAll ExclusionRule(organization = "com.sun.xml.bind"))
  val siteCrawler = Def.setting("io.github.jasperroel" % "SiteCrawler" % "1.0.0")
  val slack = Def.setting("com.hubspot.slack" % "slack-java-client" % "1.16.8")
  val snappy = Def.setting("org.xerial.snappy" % "snappy-java" % "1.1.10.7")
  val snakeYaml = Def.setting("org.yaml" % "snakeyaml" % "2.4")
  val sourcecode = Def.setting("com.lihaoyi" %% "sourcecode" % "0.4.2")
  val sparkGCSConnector = Def.setting("com.google.cloud.bigdataoss" % "gcs-connector" % "3.1.3" classifier "shaded")
  val sprayJson = Def.setting("io.spray" %%% "spray-json" % "1.4.0")
  val squants = Def.setting("org.typelevel"  %%% "squants" % "1.8.3")
  val sshj = Def.setting("com.hierynomus" % "sshj" % "0.40.0")
  val stripe = Def.setting("com.stripe" % "stripe-java" % "29.2.0")
  val sttpQuicklens = Def.setting("com.softwaremill.quicklens" %%% "quicklens" % "1.9.9")
  val sundial = Def.setting("org.knowm" % "sundial" % "2.3.0")
  val thumbnailator = Def.setting("net.coobird" % "thumbnailator" % "0.4.20")
  val tomlj = Def.setting("org.tomlj" % "tomlj" % "1.1.1")
  val ulid = Def.setting("net.petitviolet" % "ulid4s_2.13" % "0.5.0")
  val unboundid = Def.setting("com.unboundid" % "unboundid-ldapsdk" % "7.0.2")
  val univocity = Def.setting("com.univocity" % "univocity-parsers" % "2.9.1")
  val upickle = Def.setting("com.lihaoyi" %%% "upickle" % "1.4.3")
  val webjarsLocator = Def.setting("org.webjars" % "webjars-locator-core" % "0.59")
  val xmemcached = Def.setting("com.googlecode.xmemcached" % "xmemcached" % "2.4.8")
  val xmlApis = Def.setting("xml-apis" % "xml-apis" % "2.0.2")
  val zendeskClient = Def.setting("com.cloudbees.thirdparty" % "zendesk-java-client" % "1.2.0")
  val zeroAllocationHashing = Def.setting("net.openhft" % "zero-allocation-hashing" % "0.16")
  val zip4j = Def.setting("net.lingala.zip4j" % "zip4j" % "2.11.5")
  val zstd = Def.setting("com.github.luben" % "zstd-jni" % "1.5.7-3")
  val ztZip = Def.setting("org.zeroturnaround" % "zt-zip" % "1.17")

  // Dependencies for swagger-client generated code
  val oauth2Client = Def.setting("org.apache.oltu.oauth2" % "org.apache.oltu.oauth2.client" % "1.0.2")
  val swaggerAnnotations = Def.setting("io.swagger.corev3" % "swagger-annotations" % "2.2.21")
  val jodaTime = Def.setting("joda-time" % "joda-time" % "2.14.0")

  // Scala.js
  val scalablyTyped = Def.setting("com.olvind" %%% "scalablytyped-runtime" % "2.4.2")
  val scalajsJavaTime = Def.setting("io.github.cquiroz" %%% "scala-java-time" % "2.5.0")
  val scalajsSecureRandom = Def.setting("org.scala-js" %%% "scalajs-java-securerandom" % "1.0.0")

  val resolvers = Seq(
    Resolver.defaultLocal,
    Resolver.mavenCentral,
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

  val globalDependencyOverrides = Def.setting(
    Seq(
      "org.openapitools"        %   "openapi-core"                % "7.11.0-SNAPSHOT",
      "org.openapitools"        %   "openapi-generator"           % "7.11.0-SNAPSHOT",
      "org.apache.curator"      %   "curator-recipes"             % "5.7.1",
      "org.json4s"              %%  "json4s-core"                 % "4.1.0-M8",
      "org.json4s"              %%  "json4s-native"               % "4.1.0-M8",
      "org.json4s"              %%  "json4s-jackson"              % "4.1.0-M8",
      "org.json4s"              %%  "json4s-ext"                  % "4.1.0-M8",
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
    ExclusionRule("org.typelevel", "cats-kernel_2.13"),
    ExclusionRule("org.apache.logging.log4j", "log4j-to-slf4j")
  ))
}