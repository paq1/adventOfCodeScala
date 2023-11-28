package days.day1

import days.`2019`.day1.Day1Part1
import org.scalatest.flatspec.AnyFlatSpec
import org.scalamock.scalatest.MockFactory
import services.InputReader
class Day1Part1Spec extends AnyFlatSpec with MockFactory {

  val reader: InputReader = mock[InputReader]

  val part1 = new Day1Part1(reader)

  it should "return 2 when 12" in {

    (reader.getList _)
      .expects()
      .returning(List("12"))

    val result = part1.result

    assert(result == "2")
  }

  it should "return 2 when 14" in {

    (reader.getList _)
      .expects()
      .returning(List("14"))

    val result = part1.result

    assert(result == "2")
  }

  it should "return 654 when 1969" in {

    (reader.getList _)
      .expects()
      .returning(List("1969"))

    val result = part1.result

    assert(result == "654")
  }

  it should "return 33583 when 100756" in {

    (reader.getList _)
      .expects()
      .returning(List("100756"))

    val result = part1.result

    assert(result == "33583")
  }

  it should "return sum of all" in {

    (reader.getList _)
      .expects()
      .returning(List("100756", "1969"))

    val result = part1.result

    assert(result == (33583 + 654).toString)
  }
}
