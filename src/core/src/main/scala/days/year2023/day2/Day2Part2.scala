package days.year2023.day2

import days.DayPartJob
import days.year2023.day2.models.{Partie, SetOfRound}
import services.InputReader

class Day2Part2(inputReader: InputReader) extends DayPartJob {
  override def result: String =
    inputReader.getList
      .map(traitement)
      .sum
      .toString

  private def traitement(chaine: String): Int = {
    val partie: Partie = reformatInput(chaine)
    partie.getMultiple
  }

  private def reformatInput(inputDeDepart: String): Partie = {
    val identifiant: Identifiant = inputDeDepart
      .split(":")
      .headOption
      .getOrElse("")
      .split(" ")
      .lastOption
      .getOrElse("")
      .toInt

    val sets = inputDeDepart
      .split(":")
      .lastOption
      .getOrElse("")
      .split(";")
      .map(_.trim)
      .map { setMalformatter =>
        val cubesRevealed = setMalformatter
          .split(",")
          .map(_.trim)
          .map { coupMalFormatter =>
            val tupleValueCouleur = coupMalFormatter
              .split(" ")
            (
              tupleValueCouleur.lastOption.getOrElse(""),
              tupleValueCouleur.headOption.getOrElse("").toInt
            )
          }
          .toList
        SetOfRound(cubesRevealed = cubesRevealed)
      }
      .toList

    Partie(identifiant, sets)
  }
}
