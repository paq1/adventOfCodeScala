package days.year2023.day2

import days.DayPartJob
import days.year2023.day2.models.{Partie, SetOfRound}
import days.year2023.day2.rules.RulesOfCubesRevealedPart1
import services.InputReader

class Day2Part1(inputReader: InputReader) extends DayPartJob {

  val rulesOfCubesRevealedPart1: RulesOfCubesRevealedPart1 =
    new RulesOfCubesRevealedPart1
  override def result: String =
    inputReader.getList
      .map(traitement)
      .sum
      .toString

  private def traitement(chaine: String): Int = {
    val partie: Partie = reformatInput(chaine)
    if (rulesOfCubesRevealedPart1.partieValid(partie)) partie.id
    else 0
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
