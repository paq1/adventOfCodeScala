package year2023.day6

import days.year2023.day6.Day6Part1
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import services.InputReader

class Day6Part1Spec extends AnyFlatSpec with MockFactory {

  val reader: InputReader = mock[InputReader]

  val part1 = new Day6Part1(reader)

  it should "return 288 for sample input" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "Time:      7  15   30",
          "Distance:  9  40  200"
        )
      )

    val result = part1.result

    assert(result == "288")
  }

}
