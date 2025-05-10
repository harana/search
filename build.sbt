import sbt.addDependencyTreePlugin

lazy val commonSettings = Seq(
    version                                   := "0.0.0",
    sbtPlugin                                 := true,
    scalaVersion                              := "2.12.18",
    organization                              := "com.harana",
    githubOwner                               := "harana",
    githubRepository                          := "sbt-plugin",
    githubTokenSource                         := TokenSource.Environment("GITHUB_TOKEN"),
    doc / sources                             := Seq(),
    Compile / packageDoc / publishArtifact    := false,
    Compile / packageSrc / publishArtifact    := false
)

  lazy val root = Project("sbt-plugin", file(".h"))
    .settings(
      commonSettings,
      moduleName      := "root",
      publish         := {},
      publishLocal    := {},
      publishArtifact := false
    )
    .aggregate(common, js, jvm, js_jvm)

  lazy val common = project
    .settings(
      commonSettings,
      moduleName      := "sbt_common",
      name            := "sbt",

      addSbtPlugin("com.codecommit"                 % "sbt-github-packages"       % "0.5.3"),
      addSbtPlugin("com.eed3si9n"                   % "sbt-assembly"              % "2.1.5"),
      addSbtPlugin("com.eed3si9n"                   % "sbt-buildinfo"             % "0.11.0"),
      addSbtPlugin("com.github.sbt"                 % "sbt-jni"                   % "1.7.0"),
      addSbtPlugin("com.github.sbt"                 % "sbt-native-packager"       % "1.9.16"),
      addSbtPlugin("com.timushev.sbt"               % "sbt-updates"               % "0.6.4"),
      addSbtPlugin("io.github.cquiroz"              % "sbt-locales"               % "4.2.0"),
      addSbtPlugin("net.aichler"                    % "sbt-jupiter-interface"     % "0.11.1"),
      addSbtPlugin("nl.gn0s1s"                      % "sbt-dotenv"                % "3.0.0"),
      addSbtPlugin("org.scala-js"                   % "sbt-scalajs"               % "1.15.0"),
      addSbtPlugin("org.portable-scala"             % "sbt-scalajs-crossproject"  % "1.3.2"),
      addSbtPlugin("org.scalablytyped.converter"    % "sbt-converter"             % "1.0.0-beta44"),
      addSbtPlugin("org.scalameta"                  % "sbt-scalafmt"              % "2.5.2"),
      addSbtPlugin("com.here.platform"              % "sbt-bom"                   % "1.0.14"),
      addSbtPlugin("com.github.ghostdogpr"          % "caliban-codegen-sbt"       % "2.10.0"),
      addDependencyTreePlugin
    )
    .enablePlugins(SbtPlugin)


  lazy val js = project
    .settings(
      commonSettings,
      moduleName      := "sbt_js",
      name            := "sbt"
    )
    .enablePlugins(SbtPlugin)
    .dependsOn(common)

  lazy val jvm = project
    .settings(
      commonSettings,
      moduleName      := "sbt_jvm",
      name            := "sbt"
    )
    .enablePlugins(SbtPlugin)
    .dependsOn(common)

  lazy val js_jvm = project
    .settings(
      commonSettings,
      moduleName      := "sbt_js_jvm",
      name            := "sbt"
    )
    .enablePlugins(SbtPlugin)
    .dependsOn(common)
