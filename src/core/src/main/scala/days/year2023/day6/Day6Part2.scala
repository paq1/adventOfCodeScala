package days.year2023.day6

import days.DayPartJob
import services.InputReader

class Day6Part2(inputReader: InputReader) extends DayPartJob {
  override def result: String =
    traitement(inputReader.getList).toString

  private def traitement(input: List[String]): Long = {
    val reforttedInput = reformatInput(input)

    (0 until reforttedInput.last.length)
      .map { index =>
        val time = reforttedInput.head.lift(index).get
        val distance = reforttedInput.last.lift(index).get
        evaluate(time, distance).length
      }
      .toList
      .product
  }

  private def evaluate(time: Long, distance: Long): List[Long] = {
    (0L to time)
      .map { timePushingButton =>
        val tempsRestant = time - timePushingButton
        val distanceParcourue = tempsRestant * timePushingButton
        distanceParcourue
      }
      .filter(distanceParcourue => distanceParcourue > distance)
      .toList
  }

  private def reformatInput(input: List[String]): List[List[Long]] = {
    input
      .map(reformat1Line)
      .map(_._2)
  }

  private def reformat1Line(line: String): (String, List[Long]) = {
    val list = line
      .replace(":", "")
      .split(" +")
      .toList

    (list.head.toLowerCase, List(list.tail.mkString.toLong))
  }
}
