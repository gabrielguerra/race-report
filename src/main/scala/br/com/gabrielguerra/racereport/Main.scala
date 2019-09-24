package br.com.gabrielguerra.racereport

object Main extends App {
  val laps = FileReader.readFile().map(FileReader.parseLine)

  val raceReport = new RaceReport(laps)

  println("\nResultados")
  raceReport.results().zipWithIndex.foreach { case (lap, pos) => println(s"${pos + 1} - $lap") }

  println("\nMelhor volta por piloto")
  raceReport.bestLapPerPilot().zipWithIndex.foreach { case (lap, pos) => println(s"${pos + 1} - $lap") }

  println("\nMelhor volta na corrida")
  println(raceReport.bestRaceLap())

  println("\nVelocidade média por piloto")
  raceReport.pilotsAverageSpeed().zipWithIndex.foreach { case (res, pos) => println(s"${pos + 1} - $res") }
}
