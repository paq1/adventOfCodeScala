package year2023.day2

import days.year2023.day2.Day2Part1
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import services.InputReader

class Day2Part1Spec extends AnyFlatSpec with MockFactory {

  val reader: InputReader = mock[InputReader]

  val part1 = new Day2Part1(reader)

  it should "return 1 when Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green" in {

    (reader.getList _)
      .expects()
      .returning(List("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"))

    val result = part1.result

    assert(result == "1")
  }

  it should "return 2 when Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue" in {

    (reader.getList _)
      .expects()
      .returning(
        List("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue")
      )

    val result = part1.result

    assert(result == "2")
  }

  it should "return 0 when Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"
        )
      )

    val result = part1.result

    assert(result == "0")
  }

  it should "return 0 when Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red" in {

    (reader.getList _)
      .expects()
      .returning(
        List(
          "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"
        )
      )

    val result = part1.result

    assert(result == "0")
  }

  it should "return 5 when Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green" in {

    (reader.getList _)
      .expects()
      .returning(List("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"))

    val result = part1.result

    assert(result == "5")
  }

}
