package scalera.twitter

import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.dstream.ReceiverInputDStream

/**
 * It Handles all action additions
 */
trait Actions {
  _: util.Config =>

  type Content

  type Action = RDD[Content] => Unit

  private var actions: List[Action] = List()

  val ssc: StreamingContext

  val stream: ReceiverInputDStream[Content]

  /**
   * Start listening from incoming bunches of tweets.
   */
  def listen(): Unit = {
    actions.foreach(f => stream.foreachRDD(rdd => f(rdd)))
    ssc.start()
  }

  /**
   * Add a new action to perform when a bunch of tweets comes.
 *
   * @param action Action to perform.
   */
  def when(action: Action): Unit = {
    actions = actions :+ action
  }

}