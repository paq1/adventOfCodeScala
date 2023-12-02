package days.year2023.day2.rules

import days.year2023.day2.Colour
import days.year2023.day2.models.Partie
import days.year2023.day2.rules.RulesOfCubesRevealedPart1.MaxNumberPerColor

class RulesOfCubesRevealedPart1 {

  def partieValid(partie: Partie): Boolean =
    partie.sets.forall(p => cubesRevealedAreValid(p.cubesRevealed))

  private def cubesRevealedAreValid(
      cubesRevealed: List[(Colour, Int)]
  ): Boolean = invalidCubes(
    cubesRevealed
  ).isEmpty

  private def invalidCubes(
      cubesRevealed: List[(Colour, Int)]
  ): List[(Colour, Int)] =
    cubesRevealed
      .filter(cubeReveal => MaxNumberPerColor(cubeReveal._1) < cubeReveal._2)
}
object RulesOfCubesRevealedPart1 {
  val MaxNumberPerColor: Map[Colour, Int] = Map(
    "red" -> 12,
    "green" -> 13,
    "blue" -> 14
  )
}
