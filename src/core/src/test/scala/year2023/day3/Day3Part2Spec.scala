package year2023.day3

import days.year2023.day3.Day3Part2
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import services.InputReader

class Day3Part2Spec extends AnyFlatSpec with MockFactory {

  val reader: InputReader = mock[InputReader]

  val part1 = new Day3Part2(reader)

  it should "return 467835 when advent exemple is compute" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "467..114..",
          "...*......",
          "..35..633.",
          "......#...",
          "617*......",
          ".....+.58.",
          "..592.....",
          "......755.",
          "...$.*....",
          ".664.598.."
        )
      )

    val result = part1.result

    assert(result == "467835")
  }
}
