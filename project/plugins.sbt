resolvers += Resolver.sonatypeRepo("snapshots")
Compile / unmanagedSourceDirectories += new File("src/main/scala")

addSbtPlugin("com.codecommit"                 % "sbt-github-packages"       % "0.5.3")
addSbtPlugin("com.github.sbt"                 % "sbt-native-packager"       % "1.9.16")
addSbtPlugin("com.here.platform"              % "sbt-bom"                   % "1.0.14")
