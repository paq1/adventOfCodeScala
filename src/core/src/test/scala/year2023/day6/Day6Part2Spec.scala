package year2023.day6

import days.year2023.day6.Day6Part2
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import services.InputReader

class Day6Part2Spec extends AnyFlatSpec with MockFactory {

  val reader: InputReader = mock[InputReader]

  val part2 = new Day6Part2(reader)

  it should "return 71503 when we merge numer" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "Time:      7  15   30",
          "Distance:  9  40  200"
        )
      )

    val result = part2.result

    assert(result == "71503")
  }
}
