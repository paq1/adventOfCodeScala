package days.day1

import days.DayPartJob
import services.InputReader

class Day1Part1(inputReader: InputReader) extends DayPartJob {

  override def result: String = {
    inputReader
      .getList
      .mkString("\n")
  }

}
