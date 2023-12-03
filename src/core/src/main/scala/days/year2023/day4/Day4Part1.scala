package days.year2023.day4

import days.DayPartJob
import services.InputReader

class Day4Part1(inputReader: InputReader) extends DayPartJob {
  override def result: String =
    inputReader.getList
      .map(traitement)
      .sum
      .toString

  private def traitement(chaine: String): Int = {
    1
  }
}
