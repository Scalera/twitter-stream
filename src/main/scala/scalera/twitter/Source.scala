package scalera.twitter

import org.apache.spark.SparkConf
import org.apache.spark.streaming.twitter.TwitterUtils
import org.apache.spark.streaming.{StreamingContext, Seconds}
import util.Config

/**
 * A Source opens a stream of tweets from set configuration.
 */
trait Source extends Actions with Filters {
  _: util.Config =>

  type Content = twitter4j.Status

  val conf = new SparkConf()
    .setAppName(config.getString(Config.AppName))
    .setMaster(config.getString(Config.SparkMaster))

  val windowTime = Seconds(config.getInt(Config.WindowSeconds))

  val ssc = new StreamingContext(conf, windowTime)

  lazy val stream = TwitterUtils.createStream(ssc, None, filters)

}

