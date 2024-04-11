import sbt._

val search = haranaProject("search").in(file("."))
  .settings(
    libraryDependencies += "com.harana" %%% "web" % "1.0.6"
  )