import Dependencies._
val scala3Version = "3.1.0"
val scala213 = "2.13.6"

inThisBuild(
  Seq(
    homepage := Some(url("https://github.com/i10416/munkres")),
    organization := "dev.i10416",
    description := "Munkres Algorithm implementation for Scala",
    scalacOptions ++= Seq(
      "-deprecation"
    ),
    licenses := Seq(
      "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")
    ),
    versionScheme := Some("early-semver"),
    crossScalaVersions ++= Seq(scala3Version, scala213)
  )
)

lazy val root = project
    .in(file("."))
    .settings(
      name := "scala-munkres",
      version := "0.1.0-SNAPSHOT",
      scalaVersion := scala3Version,
      libraryDependencies ++= Dependencies.deps
    )

lazy val docs = project
    .in(file(".generated_docs"))
    .dependsOn(root)
    .settings(
      scalaVersion := scala3Version,
      mdocIn := file("docs"),
      mdocVariables := Map[String, String](),
      publish := none
    )
    .enablePlugins(MdocPlugin)
