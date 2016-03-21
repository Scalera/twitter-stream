name := "twitter-stream"

organization := "org.bfc"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.5"

libraryDependencies ++= {
  val sparkVersion = "1.3.0"
  Seq(
    "org.apache.spark" %% "spark-core" % sparkVersion,
    "org.apache.spark" %% "spark-streaming" % sparkVersion,
    "org.apache.spark" %% "spark-streaming-twitter" % sparkVersion,
    "org.slf4j" % "slf4j-simple" % "1.7.5")
}
