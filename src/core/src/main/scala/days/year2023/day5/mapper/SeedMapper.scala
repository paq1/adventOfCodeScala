package days.year2023.day5.mapper

class SeedMapper(schemas: List[(ToMapper, FromMapper, PasMapper)]) {

  def convertir(seed: Long): Long = {
    schemas
      .find { schema =>
        seed >= schema._2 && seed <= schema._2 + schema._3
      }
      .map { schemaTrouve =>
        seed - schemaTrouve._2 + schemaTrouve._1
      }
      .getOrElse(seed)
  }

}
