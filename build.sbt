name := "hacknight"

version := "0.1"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.0.0",
  "org.clapper" %% "grizzled-slf4j" % "1.0.1",
  "ch.qos.logback" % "logback-classic" % "1.0.10",
  "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test",
  "org.mockito" % "mockito-all" % "1.9.5"
)

