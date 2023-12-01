package year2023.day1

import days.`2023`.day1.Day1Part1
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import services.InputReader

class Day1Part1Spec extends AnyFlatSpec with MockFactory {

  val reader: InputReader = mock[InputReader]

  val part1 = new Day1Part1(reader)

  it should "return 12 when 1abc2" in {

    (reader.getList _)
      .expects()
      .returning(List("1abc2"))

    val result = part1.result

    assert(result == "12")
  }

  it should "return 38 when pqr3stu8vwx" in {

    (reader.getList _)
      .expects()
      .returning(List("pqr3stu8vwx"))

    val result = part1.result

    assert(result == "38")
  }

  it should "return 15 when a1b2c3d4e5f" in {

    (reader.getList _)
      .expects()
      .returning(List("a1b2c3d4e5f"))

    val result = part1.result

    assert(result == "15")
  }

  it should "return 77 when treb7uchet" in {

    (reader.getList _)
      .expects()
      .returning(List("treb7uchet"))

    val result = part1.result

    assert(result == "77")
  }

}
