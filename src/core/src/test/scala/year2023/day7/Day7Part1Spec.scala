package year2023.day7

import days.year2023.day7.Day7Part1
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import services.InputReader

class Day7Part1Spec extends AnyFlatSpec with MockFactory {

  val reader: InputReader = mock[InputReader]

  val part1 = new Day7Part1(reader)

  it should "return xxx when xxx" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "Time:      7  15   30",
          "Distance:  9  40  200"
        )
      )

    val result = part1.result

    assert(result == "1")
  }

}
