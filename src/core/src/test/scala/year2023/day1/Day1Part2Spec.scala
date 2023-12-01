package year2023.day1

import days.`2023`.day1.Day1Part2
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import services.InputReader

class Day1Part2Spec extends AnyFlatSpec with MockFactory {

  val reader: InputReader = mock[InputReader]

  val part2 = new Day1Part2(reader)

  it should "return 29 when two1nine" in {

    (reader.getList _)
      .expects()
      .returning(List("two1nine"))

    val result = part2.result

    assert(result == "29")
  }

  it should "return 83 when eightwothree" in {

    (reader.getList _)
      .expects()
      .returning(List("eightwothree"))

    val result = part2.result

    assert(result == "83")
  }

  it should "return 13 when abcone2threexyz" in {

    (reader.getList _)
      .expects()
      .returning(List("abcone2threexyz"))

    val result = part2.result

    assert(result == "13")
  }

  it should "return 42 when 4nineeightseven2" in {

    (reader.getList _)
      .expects()
      .returning(List("4nineeightseven2"))

    val result = part2.result

    assert(result == "42")
  }

}
