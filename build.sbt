import sbt._

val search = haranaProject("search").in(file("."))
  .settings(
    libraryDependencies += "com.harana" %%% "web" % "1.0.12-2-446f0a4-SNAPSHOT"
  )
