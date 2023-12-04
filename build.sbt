ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "scala-basics-18",
    
    libraryDependencies += "org.playframework" %% "play-json" % "3.0.1",
    libraryDependencies += "org.apache.pekko" %% "pekko-http" % "1.0.0",
    libraryDependencies += "org.scalatest"     %% "scalatest"    % "3.2.17"   % Test,
    libraryDependencies += "org.scalatestplus" %% "mockito-4-11" % "3.2.17.0" % Test,

    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-feature",
      "-unchecked",
      "-deprecation"
    )
  )
