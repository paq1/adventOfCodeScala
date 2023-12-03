package days.year2023.day3.servicesDay3

import days.year2023.day3.Position

class MapReader(carte: List[String]) {

  def fromPositionToAdjacentNumbers(
      position: Position
  ): List[(Position, Int)] = {
    val haut: List[(Position, Int)] = if (position.y != 0) {
      val hautOpt = getNumberFromPosition(position.copy(y = position.y - 1))
      if (hautOpt.isEmpty) {
        List(
          getNumberFromPosition(
            position.copy(y = position.y - 1, x = position.x - 1)
          ),
          getNumberFromPosition(
            position.copy(y = position.y - 1, x = position.x + 1)
          )
        ).flatten
      } else List(hautOpt).flatten
    } else Nil

    val bas = if (position.y != carte.length - 1) {
      val basOpt = getNumberFromPosition(position.copy(y = position.y + 1))
      if (basOpt.isEmpty) {
        List(
          getNumberFromPosition(
            position.copy(y = position.y + 1, x = position.x - 1)
          ),
          getNumberFromPosition(
            position.copy(y = position.y + 1, x = position.x + 1)
          )
        ).flatten
      } else List(basOpt).flatten
    } else None

    val droite = if (position.x != carte(position.y).length - 1) {
      getNumberFromPosition(position.copy(x = position.x + 1))
    } else None

    val gauche = if (position.x != 0) {
      getNumberFromPosition(position.copy(x = position.x - 1))
    } else None

    List(
      haut,
      droite,
      bas,
      gauche
    ).flatten
  }

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

  def sumOfproductGear = {
    allSpecificSymbolPos('*')
      .map { position =>
        fromPositionToAdjacentNumbers(position)
      }
      .filter { list => list.length == 2 }
      .map(_.map(_._2))
      .map(_.product)
      .sum
  }

  private def allSpecificSymbolPos(symbol: Char): List[Position] = {
    carte.zipWithIndex
      .flatMap { lines =>
        lines._1.toCharArray.toList.zipWithIndex
          .flatMap { currentCharTuple =>
            if (currentCharTuple._1 == symbol) {
              Some(Position(x = currentCharTuple._2, y = lines._2))
            } else {
              None
            }
          }
      }
  }

  def getNumberFromPosition(position: Position): Option[(Position, Int)] = {
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

      Some(
        (
          getIdFromPosition(position),
          s"$partLeft${carte(position.y).charAt(position.x)}$partRight".toInt
        )
      )
    }
  }

  private def getIdFromPosition(position: Position): Position = {
    val partOfLeftStringForAnalyse: String =
      carte(position.y).substring(0, position.x)
    val identifiant = partOfLeftStringForAnalyse
      .foldRight((position, true)) { (current, acc) =>
        if (acc._2) {
          if (current.isDigit) {
            (acc._1.copy(x = acc._1.x - 1), true)
          } else {
            (acc._1, false)
          }
        } else {
          acc
        }
      }
      ._1
    identifiant
  }
}
