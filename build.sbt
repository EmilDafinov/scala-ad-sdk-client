import sbt.Keys.version

lazy val SCALATEST_VERSION = "3.0.0"
lazy val scalaAdSdkClient = (project in file("."))
  .enablePlugins(JavaServerAppPackaging, DockerPlugin, UniversalPlugin)
  .settings(
    scalaVersion := "2.11.8",

    organization := "com.emiliorodo",
    name := "scala-ad-sdk-client",
    version := "0.1",

    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),

    resolvers ++= Seq(
      "Artifactory" at "https://oss.jfrog.org/artifactory/oss-snapshot-local/",
      Resolver.bintrayRepo(owner = "emildafinov", repo = "maven"),
      Resolver.jcenterRepo
    ),
    
    libraryDependencies ++= Seq(
      "com.typesafe" % "config" % "1.3.0",
      "ch.qos.logback" % "logback-classic" % "1.1.7",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
      "org.scalactic" %% "scalactic" % SCALATEST_VERSION,
      "org.scalatest" %% "scalatest" % SCALATEST_VERSION % "test",
      "org.mockito" % "mockito-all" % "1.10.19" % "test",

      //SDK dependency
      "com.github.emildafinov" %% "scala-ad-sdk" % "1.7"
    ),

    maintainer in Docker := "Emil Dafinov <emil.dafinov@gmail.com>",
    packageName in Docker := s"emildafinov-docker-emiliorodo-docker.bintray.io/${name.value}",
    dockerUpdateLatest := true
  )
