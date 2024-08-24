import sbt._

val search = haranaProject("search").in(file("."))
  .settings(
    libraryDependencies += "com.harana" %%% "web" % "1.0.15-2-4623b3f-dirty-SNAPSHOT"
  )
