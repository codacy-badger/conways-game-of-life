name := "ConwaysGameOfLife"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-u", "test-results")