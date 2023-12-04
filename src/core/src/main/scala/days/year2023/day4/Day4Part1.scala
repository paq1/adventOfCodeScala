package days.year2023.day4

import days.DayPartJob
import services.InputReader

import scala.annotation.tailrec

class Day4Part1(inputReader: InputReader) extends DayPartJob {
  override def result: String =
    inputReader.getList
      .map(traitement)
      .sum
      .toString

  private def traitement(chaine: String): Int = {

    val partsOfGame = chaine
      .split(":")

    val cardRound = partsOfGame(1).strip

    val roundGoodCardAndMyCards: List[List[Int]] = cardRound
      .split("\\|")
      .map(_.strip.split(" +").map(_.toInt).toList)
      .toList

    val goodPart = roundGoodCardAndMyCards.head
    val myPart = roundGoodCardAndMyCards(1)

    val nombreDeVictoire = myPart
      .count(number => goodPart.contains(number))

    calculScore(nombreDeVictoire)

  }

  private def calculScore(n: Int): Int =
    if (n == 0) 0
    else if (n == 1) 1
    else calculScore(n - 1) * 2
}
