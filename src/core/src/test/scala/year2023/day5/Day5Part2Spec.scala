package year2023.day5

import days.year2023.day4.Day4Part2
import days.year2023.day5.Day5Part2
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import services.InputReader

class Day5Part2Spec extends AnyFlatSpec with MockFactory {

  val reader: InputReader = mock[InputReader]

  val part1 = new Day5Part2(reader)

  it should "return 1 when all card" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "xxx"
        )
      )

    val result = part1.result

    assert(result == "1")
  }
}
