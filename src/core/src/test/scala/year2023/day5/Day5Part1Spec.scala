package year2023.day5

import days.year2023.day5.Day5Part1
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import services.InputReader

class Day5Part1Spec extends AnyFlatSpec with MockFactory {

  val reader: InputReader = mock[InputReader]

  val part1 = new Day5Part1(reader)

  it should "return 8 when we have 4 winning" in {

    (reader.getList _)
      .expects()
      .returning(List("xxx"))

    val result = part1.result

    assert(result == "1")
  }

}
