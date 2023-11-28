ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .aggregate(models, core, app)
  .settings(
    name := "adventOfCodeScala"
  )

lazy val app = (project in file("src/adventOfCode"))
  .dependsOn(models, core)
  .settings(
    name := """adventOfCode"""
  )

lazy val core = (project in file("src/core"))
  .dependsOn(models)
  .settings(
    name := """core""",
    libraryDependencies ++= List(
      "org.scalamock" %% "scalamock" % "5.2.0" % Test,
      "org.scalatest" %% "scalatest" % "3.2.15" % Test
    )
  )

lazy val models = (project in file("src/models"))
  .settings(
    name := """models"""
  )
