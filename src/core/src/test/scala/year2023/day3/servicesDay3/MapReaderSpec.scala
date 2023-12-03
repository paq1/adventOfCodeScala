package year2023.day3.servicesDay3

import days.year2023.day3.{Day3Part1, Position}
import days.year2023.day3.servicesDay3.MapReader
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import services.InputReader

class MapReaderSpec extends AnyFlatSpec with MockFactory {

  val mapReader = new MapReader(
    carte = List(
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

  it should "return 467 when 0,0" in {
    // given
    val position = Position(0, 0)

    // when
    val res = mapReader.getNumberFromPosition(position)

    // then
    assert(res.contains(467))
  }

  it should "return 467 when 1,0" in {
    // given
    val position = Position(1, 0)

    // when
    val res = mapReader.getNumberFromPosition(position)

    // then
    assert(res.contains(467))
  }

  it should "return 467 when 2,0" in {
    // given
    val position = Position(2, 0)

    // when
    val res = mapReader.getNumberFromPosition(position)

    // then
    assert(res.contains(467))
  }

  it should "return 592 when 3,6" in {
    // given
    val position = Position(3, 6)

    // when
    val res = mapReader.getNumberFromPosition(position)

    // then
    assert(res.contains(592))
  }

  it should "return None when 3,0" in {
    // given
    val position = Position(3, 0)

    // when
    val res = mapReader.getNumberFromPosition(position)

    // then
    assert(res.isEmpty)
  }

  it should "return None when 3,1 (symbol)" in {
    // given
    val position = Position(3, 1)

    // when
    val res = mapReader.getNumberFromPosition(position)

    // then
    assert(res.isEmpty)
  }

  it should "return all position symbol" in {
    // given
    val mapReaderPartOfData = new MapReader(
      List(
        "467..114..",
        "...*......",
        "..35..633.",
        "......#..."
      )
    )

    // when
    val res = mapReaderPartOfData.allSymbolPos

    // then
    assert(res == List(Position(3, 1), Position(6, 3)))
  }

}
