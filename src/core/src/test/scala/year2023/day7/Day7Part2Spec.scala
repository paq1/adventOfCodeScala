package year2023.day7

import days.year2023.day7.Day7Part2
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import services.InputReader

class Day7Part2Spec extends AnyFlatSpec with MockFactory {

  val reader: InputReader = mock[InputReader]

  val part2 = new Day7Part2(reader)

  it should "return ??? when ???" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "Time:      7  15   30",
          "Distance:  9  40  200"
        )
      )

    val result = part2.result

    assert(result == "1")
  }
}
