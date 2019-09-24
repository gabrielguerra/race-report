package br.com.gabrielguerra.racereport.model

case class PilotAverageSpeed(
    pilotCode: String,
    pilotName: String,
    raceAverageSpeed: Double
) {
  override def toString: String = {
    f"$pilotCode-$pilotName%-14s Race avg.speed: $raceAverageSpeed%2.3f"
  }
}
