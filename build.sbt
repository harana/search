import sbt._
import com.harana.sbt.common._

val search = haranaCrossProject("search").in(file("."))
  .settings(
    libraryDependencies +=
        "com.harana" %%% "web" % "1.0.0"
  )
  .jsSettings()
  .jvmSettings()

val root = haranaRootProject(search)