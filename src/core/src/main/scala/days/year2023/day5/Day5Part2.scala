package days.year2023.day5

import days.DayPartJob
import days.year2023.day5.mapper.SeedMapper
import services.InputReader

// first try  : 79004095
// seconf try : 79004095

class Day5Part2(inputReader: InputReader) extends DayPartJob {
  override def result: String =
    traitement(inputReader.getList).toString

  private def traitement(chaine: List[String]): Long = {
    val inputs = reformatInput(chaine)
    val seeds = (inputs._1).grouped(2).toList

    println(seeds)

    val lowestLocation = seeds.map { seeds =>
      val startedSeed = seeds.head
      val rangeSeed = seeds.last
      var lowest = Long.MaxValue

      var currentSeed = startedSeed
      while (currentSeed < startedSeed + rangeSeed) {
        val location = fromSeedToLocation(currentSeed, inputs._2)
        if (location < lowest) lowest = location
        currentSeed += 1L
      }

      lowest
    }.min

    lowestLocation
  }

  private def fromSeedToLocation(
      seed: Long,
      mappers: Map[String, SeedMapper]
  ): Long = {
    val soil = mappers("seed-to-soil").convertir(seed)
    val fertilizer = mappers("soil-to-fertilizer").convertir(soil)
    val water = mappers("fertilizer-to-water").convertir(fertilizer)
    val light = mappers("water-to-light").convertir(water)
    val temperature = mappers("light-to-temperature").convertir(light)
    val humidity =
      mappers("temperature-to-humidity").convertir(temperature)
    val location = mappers("humidity-to-location").convertir(humidity)
    location
  }

  private def reformatInput(
      input: List[String]
  ): (List[Seed], Map[String, SeedMapper]) = {
    val firstReformatStep = input
      .mkString("\n")
      .split("\n\n")
      .toList

    val seed = firstReformatStep.head
      .replace("seeds: ", "")
      .split(" ")
      .map(_.toLong)
      .toList

    val mappers: Map[String, SeedMapper] = firstReformatStep.tail.map { group =>
      val titre = group.split(":").head.replace(" map", "")
      val infos = group
        .split(":")
        .last
        .split("\n")
        .toList
        .filter(_.nonEmpty)

      val schemas = infos.map { mappersUnformatted =>
        val formattedMapper = mappersUnformatted
          .split(" +")
          .filter(_.nonEmpty)
          .map(_.toLong)
          .toList

        val dest = formattedMapper.head
        val source = formattedMapper.lift(1).get
        val pas = formattedMapper.lift(2).get

        (dest, source, pas)
      }
      titre -> new SeedMapper(schemas)
    }.toMap

    (seed, mappers)
  }

}
