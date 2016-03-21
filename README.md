Twitter-stream
==============

This app opens a stream that will receive periodically a bunch of tweets and allows adding actions to perform every time this bunch of tweets arrive.

How to run
----------

Declare an Scala bootable object like this in your project:

```scala

  import scalera.twitter.Analytics
  
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
```

And then:

```
  sbt run
```

Configuration
-------------

The configuration file of this project can be found at ```src/main/resources/app.conf```:

```scala
scalera.twitter-stream {
  spark {
    //  Name of your Spark application
    app-name=twitter-stream
    //  Master of Spark. By default, it's deployed locally
    master="local[4]"
  }
  //  Each batch time window
  window-seconds=5
}
//  Info relative to your Twitter oAuth token
twitter4j.oauth {
  consumerKey=secret
  consumerSecret=secret
  accessToken=secret
  accessTokenSecret=secret
}
```

License
-------

This software is licensed as `Apache2 <http://www.apache.org/licenses/LICENSE-2.0.txt>`_

Licensed to Scalera (C) under one or more contributor license agreements.
See the NOTICE file distributed with this work for additional information
regarding copyright ownership.  The Scalera (C) licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.

Credits
-------

[@Scalera](http://scalera.es)

