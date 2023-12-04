package days.year2023.day4

import days.DayPartJob
import services.InputReader

class Day4Part2(inputReader: InputReader) extends DayPartJob {
  override def result: String =
    traitement(inputReader.getList).toString

  private def traitement(unformattedDeck: List[String]): Int = {
    val initialDeck = getFormattedDeck(unformattedDeck)
    traitementRec(initialDeck, initialDeck.map(_._1))
  }

  private def traitementRec(
      initialDeck: List[
        (CardIdentifiant, List[WinningCardResult], List[MyCardValue])
      ],
      cartes: List[CardIdentifiant]
  ): CurrentScore = {
    if (cartes.isEmpty) 0
    else {
      val mainTraitement = cartes
        .map { currentCard =>
          traitementDesIdentifiants(initialDeck, currentCard)
        }

      val maxCardIndex = initialDeck.maxBy(x => x._1)._1

      val restes: List[CardIdentifiant] = mainTraitement
        .flatMap(_._2)
        .filter(_ <= maxCardIndex)

      mainTraitement.map(_._1).sum + traitementRec(initialDeck, restes)
    }
  }

  private def traitementDesIdentifiants(
      initialDeck: List[
        (CardIdentifiant, List[WinningCardResult], List[MyCardValue])
      ],
      identifiantATraiter: CardIdentifiant
  ): (CurrentScore, List[CardIdentifiant]) = {

    val cardOpt = initialDeck.find(_._1 == identifiantATraiter)

    cardOpt match {
      case Some(card) =>
        val score = card._3.count(number => card._2.contains(number))
        val nouveauIds = (card._1 + 1 to card._1 + score).toList
        (1, nouveauIds)

      case None => (0, Nil)
    }
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
