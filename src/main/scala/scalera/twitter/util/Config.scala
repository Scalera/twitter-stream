package scalera.twitter.util

import com.typesafe.config.ConfigFactory

trait Config {

  lazy val config = ConfigFactory.load("app.conf")

}

object Config {

  val SparkMaster = "scalera.twitter-stream.spark.master"
  val AppName = "scalera.twitter-stream.spark.app-name"
  val WindowSeconds = "scalera.twitter-stream.window-seconds"

}