package br.com.gabrielguerra.racereport

import br.com.gabrielguerra.racereport.model.Lap

import scala.io.Source

object FileReader {

  def readFile(): List[String] = {
    val source = Source.fromResource("input-fallback.txt")
    val lines = source.getLines().toList
    source.close()
    lines match {
      case Nil => Nil
      case x :: Nil => if (x.startsWith("Hora")) Nil else lines
      case x :: xs => if (x.startsWith("Hora")) xs else lines
    }
  }

  def parseLine(line: String): Lap = {
    val fields = line.replaceAll("\\s{2,}", " ").split(" ")
    Lap.fromStringArray(fields)
  }
}
