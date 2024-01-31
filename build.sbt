import sbt._
import com.harana.sbt.common._

val search = haranaProject("search").in(file("."))
  .settings(
    libraryDependencies +=
        "com.harana" %%% "web" % "1.0.0"
  )