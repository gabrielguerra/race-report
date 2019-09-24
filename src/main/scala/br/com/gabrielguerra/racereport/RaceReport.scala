package br.com.gabrielguerra.racereport

import br.com.gabrielguerra.racereport.model.{Lap, PilotAverageSpeed}

class RaceReport(val raceResults: List[Lap]) {

  def sorted(): List[Lap] = {
    raceResults.sortWith((l1, l2) => (l1.lapNumber.compareTo(l2.lapNumber) > 0 || l1.time.compareTo(l2.time) < 0))
  }

  def results(): List[Lap] = {
    sorted().distinctBy(_.pilotName)
  }

  def bestLapPerPilot(): List[Lap] = {
    raceResults.groupBy(_.pilotCode)
      .values
      .map(pilots => pilots.sortWith((r1, r2) => r1.lapTime.compareTo(r2.lapTime) < 0).head).toList
      .sortWith((l1, l2) => l1.lapTime.compareTo(l2.lapTime) < 0)
  }

  def bestRaceLap(): Lap = {
    raceResults.sortWith((r1, r2) => r1.lapTime.compareTo(r2.lapTime) < 0).head
  }

  def pilotsAverageSpeed(): List[PilotAverageSpeed] = {
    raceResults.groupBy(_.pilotCode)
      .values
      .map(pilotResults => PilotAverageSpeed(
        pilotResults.head.pilotCode,
        pilotResults.head.pilotName,
        pilotResults.map(_.averageSpeed).sum / pilotResults.length)).toList
      .sortWith((p1, p2) => p1.raceAverageSpeed.compareTo(p2.raceAverageSpeed) > 0)
  }
}
