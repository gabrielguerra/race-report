package br.com.gabrielguerra.racereport.model

import java.time.LocalTime

import br.com.gabrielguerra.racereport.Utils

import scala.concurrent.duration.Duration

case class Lap(
    time: LocalTime,
    pilotCode: String,
    pilotName: String,
    lapNumber: Int,
    lapTime: Duration,
    averageSpeed: Double
) {
  override def toString: String = {
    f"$time - Lap $lapNumber%2s - $pilotCode-$pilotName%-14s Time: ${lapTime.toMillis}%6d - Avg.speed: $averageSpeed%2.3f"
  }
}

object Lap {
  def fromStringArray(array: Array[String]): Lap = {
    Lap(
      LocalTime.parse(array(0)),
      array(1),
      array(3),
      array(4).toInt,
      Utils.stringToDuration(array(5)),
      array(6).replace(",", ".").toDouble
    )
  }
}
