package br.com.gabrielguerra.racereport

import scala.concurrent.duration._

object Utils {
  def stringToDuration(value: String): Duration = {
    val colonSplit = value.split(":")
    val dotSplit = colonSplit(1).split("\\.")

    val minutes = colonSplit(0).toLong
    val seconds = dotSplit(0).toLong
    val millis = dotSplit(1).toLong

    minutes.minutes + seconds.seconds + millis.millis
  }
}
