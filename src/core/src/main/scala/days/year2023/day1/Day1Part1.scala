package days.year2023.day1

import days.DayPartJob
import services.InputReader

class Day1Part1(inputReader: InputReader) extends DayPartJob {
  override def result: String =
    inputReader.getList
      .map(traitement)
      .sum
      .toString

  private def traitement(chaine: String): Int = {
    val chaineOfDigitComplet = chaine
      .filter(char => char.isDigit)
      .mkString

    s"${chaineOfDigitComplet.head}${chaineOfDigitComplet.last}".toInt
  }
}
