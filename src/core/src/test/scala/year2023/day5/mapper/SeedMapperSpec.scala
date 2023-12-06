package year2023.day5.mapper

import days.year2023.day5.mapper.SeedMapper
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec

class SeedMapperSpec extends AnyFlatSpec with MockFactory {

  it should "return 81 when seed is 79 for seedMapperSoil example" in {

    val result = seedMapperSoil.convertir(79)

    assert(result.equals(81))
  }

  it should "return 14 when seed is 14 for seedMapperSoil example" in {

    val result = seedMapperSoil.convertir(14)

    assert(result.equals(14))
  }

  it should "return 57 when seed is 55 for seedMapperSoil example" in {

    val result = seedMapperSoil.convertir(55)

    assert(result.equals(57))
  }

  it should "return 13 when seed is 13 for seedMapperSoil example" in {

    val result = seedMapperSoil.convertir(13)

    assert(result.equals(13))
  }

  val seedMapperSoil = new SeedMapper(
    List(
      (50, 98, 1),
      (52, 50, 48)
    )
  )

}
