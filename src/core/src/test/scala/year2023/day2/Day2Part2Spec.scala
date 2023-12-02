package year2023.day2

import days.year2023.day2.Day2Part2
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import services.InputReader

class Day2Part2Spec extends AnyFlatSpec with MockFactory {

  val reader: InputReader = mock[InputReader]

  val part1 = new Day2Part2(reader)

  it should "return 48 when Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green" in {

    (reader.getList _)
      .expects()
      .returning(List("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"))

    val result = part1.result

    assert(result == "48")
  }

  it should "return 12 when Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue" in {

    (reader.getList _)
      .expects()
      .returning(
        List("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue")
      )

    val result = part1.result

    assert(result == "12")
  }

  it should "return 1560 when Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"
        )
      )

    val result = part1.result

    assert(result == "1560")
  }

  it should "return 630 when Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"
        )
      )

    val result = part1.result

    assert(result == "630")
  }

  it should "return 36 when Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green" in {

    (reader.getList _)
      .expects()
      .returning(List("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"))

    val result = part1.result

    assert(result == "36")
  }

  it should "return 2286 when many inputs" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
          "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
          "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
          "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
          "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        )
      )

    val result = part1.result

    assert(result == "2286")
  }

}
