package days.year2023.day3.servicesDay3

import days.year2023.day3.Position

class MapReader(carte: List[String]) {

  def allSymbolPos: List[Position] = {
    carte.zipWithIndex
      .flatMap { lines =>
        lines._1.toCharArray.toList.zipWithIndex
          .flatMap { currentCharTuple =>
            if (currentCharTuple._1.isDigit || currentCharTuple._1 == '.') {
              None
            } else {
              Some(Position(x = currentCharTuple._2, y = lines._2))
            }
          }
      }
  }

  def getNumberFromPosition(position: Position): Option[Int] = {
    if (!carte(position.y).charAt(position.x).isDigit) {
      None
    } else {
      val maxX = carte(position.y).length

      // construire la gauche du nombre
      val partOfLeftStringForAnalyse: String =
        carte(position.y).substring(0, position.x)
      val partLeft = partOfLeftStringForAnalyse
        .foldRight(("", true)) { (current, acc) =>
          if (acc._2) {
            if (current.isDigit) {
              (current.toString + acc._1, true)
            } else {
              (acc._1, false)
            }
          } else {
            acc
          }
        }
        ._1

      // construire la droite du nombre
      val partOfRightStringForAnalyse: String =
        carte(position.y).substring(position.x + 1, maxX)
      val partRight = partOfRightStringForAnalyse
        .foldLeft(("", true)) { (acc, current) =>
          if (acc._2) {
            if (current.isDigit) {
              (acc._1.appended(current), true)
            } else {
              (acc._1, false)
            }
          } else {
            acc
          }
        }
        ._1

      Some(s"$partLeft${carte(position.y).charAt(position.x)}$partRight".toInt)
    }
  }
}
