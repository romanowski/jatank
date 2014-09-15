scalaVersion := "2.11.0"

unmanagedJars in Compile ++= (file("robocode") / "libs" ** "*.jar").get

packageOptions in(Compile, packageBin) +=
  Package.ManifestAttributes("robots" -> "romanowski.robocode.DummyRobot")

javaOptions in run += "-Xmx512M"

javaOptions in run += "-Dsun.io.useCanonCaches=false"

javaOptions in run += "-DNOSECURITY=true"

javaOptions in run += "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"


fork in run := true

baseDirectory in run := file("robots")