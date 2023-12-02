package days.year2023.day1

import days.DayPartJob
import services.InputReader

class Day1Part2(inputReader: InputReader) extends DayPartJob {
  override def result: String =
    inputReader.getList
      .map(traitement)
      .sum
      .toString

  private def traitement(chaine: String): Int = {
    val left = traitementFromSens("left", chaine)
    val right = traitementFromSens("right", chaine)
    s"${left.getOrElse("")}${right.getOrElse("")}".toInt
  }

  private def traitementFromSens(
      sens: String,
      chaine: String
  ): Either[String, Int] =
    sens match {
      case "left" =>
        chaine
          .foldLeft[Either[String, Int]](Left("")) { (acc, current) =>
            if (acc.isLeft) {
              val newAcc = acc.left.getOrElse("") + current
              fromNewAcc(acc, newAcc)
            } else acc
          }
      case "right" =>
        chaine
          .foldRight[Either[String, Int]](Left("")) { (current, acc) =>
            if (acc.isLeft) {
              val newAcc = current + acc.left.getOrElse("")
              fromNewAcc(acc, newAcc)
            } else acc
          }
    }

  import Day1Part2._
  private def fromNewAcc(
      previousResult: Either[String, Int],
      nouvelleChaineATraiter: String
  ): Either[String, Int] = {

    val lettersFind: List[String] = MapNumbers
      .keys.toList
      .flatMap(Some(_).filter(nouvelleChaineATraiter.contains))

    val letterFind = lettersFind.nonEmpty

    if (letterFind && previousResult.isLeft) {
      Right(MapNumbers(lettersFind.head))
    } else if (nouvelleChaineATraiter.last.isDigit && previousResult.isLeft) {
      Right(nouvelleChaineATraiter.last.toString.toInt)
    } else {
      Left(nouvelleChaineATraiter)
    }
  }
}
object Day1Part2 {
  val MapNumbers = Map(
    "zero" -> 0,
    "one" -> 1,
    "two" -> 2,
    "three" -> 3,
    "four" -> 4,
    "five" -> 5,
    "six" -> 6,
    "seven" -> 7,
    "eight" -> 8,
    "nine" -> 9
  )
}
