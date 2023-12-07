package days.year2023.day5

import days.DayPartJob
import days.year2023.day5.mapper.SeedMapper
import services.InputReader

class Day5Part2(inputReader: InputReader) extends DayPartJob {
  override def result: String =
    traitement(inputReader.getList).toString

  private def traitement(chaine: List[String]): Long = {

    val inputs = reformatInput(chaine)

    val seeds = (inputs._1).grouped(2).toList

    val allSeeds = seeds
      .flatMap { list =>
        val depart = list.head
        val iteration = list.last

        (depart to (depart + iteration)).toList
      }

    println(seeds)
    println(allSeeds)

    val locations = allSeeds.map { seed =>
      val soil = inputs._2("seed-to-soil").convertir(seed)
      val fertilizer = inputs._2("soil-to-fertilizer").convertir(soil)
      val water = inputs._2("fertilizer-to-water").convertir(fertilizer)
      val light = inputs._2("water-to-light").convertir(water)
      val temperature = inputs._2("light-to-temperature").convertir(light)
      val humidity =
        inputs._2("temperature-to-humidity").convertir(temperature)
      val location = inputs._2("humidity-to-location").convertir(humidity)

      location
    }

    locations.min
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
