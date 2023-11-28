package days.`2019`.day1

import days.DayPartJob
import services.InputReader

class Day1Part1(inputReader: InputReader) extends DayPartJob {

  override def result: String = {
    inputReader.getList
      .map(_.toInt)
      .map(x => x / 3 - 2)
      .sum
      .toString
  }

}
