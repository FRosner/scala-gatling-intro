val root = project.in(file("."))
  .enablePlugins(GatlingPlugin)
  .settings(
    name := "scala-gatling-intro",
    version := "0.1",

    scalaVersion := "2.12.8",
    scalacOptions := Seq(
      "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
      "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps"),

    libraryDependencies ++= List(
      "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.0.3",
      "io.gatling" % "gatling-test-framework" % "3.0.3",
      "org.scalatest" % "scalatest_2.12" % "3.0.5",
      "com.typesafe.akka" %% "akka-http" % "10.1.8"
    )
  )

