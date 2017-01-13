name := """eigenroute-scalikejdbc-test-helpers"""

version := "0.0.1"
organization := "com.eigenroute"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.eigenroute" %% "eigenroute-util" % "0.0.1",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

publishMavenStyle := true
val resolver = Resolver.ssh("Eigenroute maven repo", "mavenrepo.eigenroute.com", 7835, "/home/mavenrepo/repo") withPermissions "0644"
publishTo := Some(resolver as ("mavenrepo", Path.userHome / ".ssh" / "id_rsa"))

publishArtifact in packageSrc := false

publishArtifact in packageDoc := false

