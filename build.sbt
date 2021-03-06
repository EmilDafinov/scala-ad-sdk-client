import sbt.Keys.version
import Resolver.bintrayRepo
import Resolver.jcenterRepo

lazy val SCALATEST_VERSION = "3.0.0"
lazy val dockerRepositoryName = "emildafinov-docker-docker.bintray.io"

lazy val scalaAdSdkClient = (project in file("."))
  .enablePlugins(JavaServerAppPackaging, DockerPlugin, UniversalPlugin)
  .settings(
    scalaVersion := "2.12.2",

    organization := "com.emiliorodo",
    name := "scala-ad-sdk-client",
    version := "0.1",

    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    
    libraryDependencies ++= Seq(
      "com.typesafe" % "config" % "1.3.0",
      "ch.qos.logback" % "logback-classic" % "1.1.7",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
      "org.scalactic" %% "scalactic" % SCALATEST_VERSION,
      "org.scalatest" %% "scalatest" % SCALATEST_VERSION % "test",
      "org.mockito" % "mockito-all" % "1.10.19" % "test",

      //SDK dependency
      "com.github.emildafinov" %% "scala-ad-sdk" % "1.9.17"
    ),

    maintainer in Docker := "Emil Dafinov <emil.dafinov@gmail.com>",
    packageName in Docker := s"$dockerRepositoryName/${name.value}",
    dockerUpdateLatest := true
  )
