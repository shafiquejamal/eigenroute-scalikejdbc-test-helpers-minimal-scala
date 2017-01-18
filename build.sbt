name := """eigenroute-scalikejdbc-test-helpers-minimal-scala"""

version := "0.0.1"
organization := "com.eigenroute"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc"             % "2.4.2",
  "org.scalikejdbc" %% "scalikejdbc-config"      % "2.4.2",
  "org.scalikejdbc" %% "scalikejdbc-test"        % "2.4.2",
  "com.eigenroute" % "eigenroute-scalikejdbc-helpers-minimal-scala_2.11" % "0.0.1",
  "com.eigenroute" %% "eigenroute-util" % "0.0.1",
  "org.scalatest" %% "scalatest" % "2.2.4",
  "org.flywaydb" % "flyway-core" % "4.0.3"
)

publishMavenStyle := true
val resolver = Resolver.ssh("Eigenroute maven repo", "mavenrepo.eigenroute.com", 7835, "/home/mavenrepo/repo") withPermissions "0644"
publishTo := Some(resolver as ("mavenrepo", Path.userHome / ".ssh" / "id_rsa"))

publishArtifact in packageSrc := false

publishArtifact in packageDoc := false

