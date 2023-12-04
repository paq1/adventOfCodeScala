package days.year2023.day5

import days.DayPartJob
import services.InputReader

class Day5Part2(inputReader: InputReader) extends DayPartJob {
  override def result: String =
    inputReader.getList
      .map(traitement)
      .sum
      .toString

  private def traitement(chaine: String): Int = {

    1

  }

}
