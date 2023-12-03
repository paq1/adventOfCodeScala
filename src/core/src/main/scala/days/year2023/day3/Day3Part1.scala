package days.year2023.day3

import days.DayPartJob
import services.InputReader

class Day3Part1(inputReader: InputReader) extends DayPartJob {
  override def result: String =
    symbolAndNumberAdjacent(inputReader.getList)
      .map(_._2)
      .sum
      .toString

  private def symbolAndNumberAdjacent(
      table: List[String]
  ): List[(String, Int)] = {

    Nil
  }
}
