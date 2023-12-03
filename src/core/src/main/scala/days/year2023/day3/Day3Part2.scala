package days.year2023.day3

import days.DayPartJob
import days.year2023.day3.servicesDay3.MapReader
import services.InputReader

class Day3Part2(inputReader: InputReader) extends DayPartJob {

  override def result: String = traitement(inputReader.getList).toString

  private def traitement(
      carte: List[String]
  ): Int = {
    val mapReaderService = new MapReader(carte)
    mapReaderService.sumOfproductGear
  }
}
