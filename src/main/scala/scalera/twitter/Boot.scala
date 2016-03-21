package scalera.twitter

object Boot extends Analytics{

  //  Add filters ...

  filter(
    "dance",
    "music"
  )

  //  ... add actions to perform ...

  when { tweets =>
    tweets.foreach {
      tweet => logger.info(s"\n$tweet")
    }
  }

  when { tweets =>
    logger.info(s"Received tweets [${tweets.count()}}]")
  }

  // ... and begin listening

  listen()

}