package year2023.day3

import days.year2023.day3.Day3Part1
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import services.InputReader

class Day3Part1Spec extends AnyFlatSpec with MockFactory {

  val reader: InputReader = mock[InputReader]

  val part1 = new Day3Part1(reader)

  it should "return 35 when * up adjacent and number is 35" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "...*......",
          "..35..633."
        )
      )

    val result = part1.result

    assert(result == "35")
  }

  it should "return 1250 when # down adjacent and number is 633" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "..35..633.",
          "......#..."
        )
      )

    val result = part1.result

    assert(result == "633")
  }

  it should "return 63 when any symbole left adjacent and number is 63" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "..35.*63.."
        )
      )

    val result = part1.result

    assert(result == "63")
  }

  it should "return 61 when any symbole right adjacent and number is 63" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "..35..61#.."
        )
      )

    val result = part1.result

    assert(result == "61")
  }

  it should "return 467 when top right" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "467..114..",
          "...*......"
        )
      )

    val result = part1.result

    assert(result == "467")
  }

  it should "return 4361 when advent exemple is compute" in {

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

    assert(result == "4361")
  }
}
