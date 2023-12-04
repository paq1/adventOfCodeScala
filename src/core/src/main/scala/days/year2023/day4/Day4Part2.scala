package days.year2023.day4

import days.DayPartJob
import services.InputReader

class Day4Part2(inputReader: InputReader) extends DayPartJob {
  override def result: String =
    traitement(inputReader.getList).toString

  private def traitement(unformattedDeck: List[String]): Int = {
    val initialDeck = getFormattedDeck(unformattedDeck)
    countCardsAndCopiesOfCardGenerate(initialDeck, initialDeck.map(_._1))
  }

  private def countCardsAndCopiesOfCardGenerate(
      initialDeck: List[
        (CardIdentifiant, List[WinningCardResult], List[MyCardValue])
      ],
      cartes: List[CardIdentifiant]
  ): CurrentScore = {
    if (cartes.isEmpty) 0
    else {
      val maxCardIndex = initialDeck.maxBy(x => x._1)._1
      val copies: List[CardIdentifiant] = cartes
        .flatMap { currentCard =>
          cardsWin(initialDeck, currentCard)
        }
        .filter(_ <= maxCardIndex)

      cartes.length + countCardsAndCopiesOfCardGenerate(initialDeck, copies)
    }
  }

  private def cardsWin(
      initialDeck: List[
        (CardIdentifiant, List[WinningCardResult], List[MyCardValue])
      ],
      identifiantATraiter: CardIdentifiant
  ): List[CardIdentifiant] = initialDeck
    .find(_._1 == identifiantATraiter)
    .toList
    .flatMap { card =>
      val score = card._3.count(number => card._2.contains(number))
      val nouveauIds = (card._1 + 1 to card._1 + score).toList
      nouveauIds
    }

  private def getFormattedDeck(
      unformattedDeck: List[String]
  ): List[(CardIdentifiant, List[WinningCardResult], List[MyCardValue])] =
    unformattedDeck
      .map { currentCardFromUnformattedDeck =>
        val identifiant: CardIdentifiant = currentCardFromUnformattedDeck
          .split(":")
          .head
          .split(" +")
          .last
          .toInt

        val formattedWinningAndMyCard = currentCardFromUnformattedDeck
          .split(":")
          .last
          .split("\\|")
          .map { part =>
            part.strip
              .split(" +")
              .map(_.toInt)
              .toList
          }
          .toList

        (
          identifiant,
          formattedWinningAndMyCard.head,
          formattedWinningAndMyCard.last
        )
      }

}
