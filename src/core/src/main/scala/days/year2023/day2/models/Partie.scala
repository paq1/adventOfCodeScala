package days.year2023.day2.models

import days.year2023.day2.{Colour, Identifiant}

case class Partie(id: Identifiant, sets: List[SetOfRound]) {

  def getMultiple: Int = keepMaxColour.sets
    .map(_.cubesRevealed.map(_._2).product)
    .headOption
    .get

  private def keepMaxColour: Partie = {
    val cubes: Set[(Colour, Identifiant)] = sets
      .foldLeft[Set[(Colour, Identifiant)]](Set.empty) { (acc, current) =>
        current.cubesRevealed.map { couleur =>
          val colorInSetOpt = acc.find(x => x._1 == couleur._1)

          colorInSetOpt match {
            case Some(colorInSet) =>
              if (couleur._2 > colorInSet._2) {
                couleur
              } else {
                colorInSet
              }
            case None => couleur
          }
        }.toSet ++ acc.filter(x =>
          !current.cubesRevealed.map(_._1).contains(x._1)
        )
      }

    copy(sets = List(SetOfRound(cubes.toList)))
  }
}
case class SetOfRound(cubesRevealed: List[(Colour, Int)])
