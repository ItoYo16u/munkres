import Dependencies._
val scala3Version = "3.1.0"
credentials += Credentials(Path.userHome / ".sbt" / "sonatype_credentials")

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
    pomIncludeRepository := { _ => false },
    developers := List(
      Developer(
        "i10416",
        "Yoichiro ITO",
        "ito.yo16uh90616+munkres@gmail.com",
        url("https://github.com/i10416")
      )
    ),
    versionScheme := Some("early-semver"),
    crossScalaVersions ++= Seq(scala3Version),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/i10416/munkres"),
        "scm:git@github.com:i10416/munkres.git"
      )
    ),
    publishTo := {
        val nexus = "https://s01.oss.sonatype.org/"
        if ((root/isSnapshot).value) Some("snapshots" at nexus + "content/repositories/snapshots")
        else Some("releases" at nexus + "service/local/staging/deploy/maven2")
    }
  )
)

lazy val root = project
    .in(file("."))
    .settings(
      name := "munkres",
      version := "0.0.1",
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
