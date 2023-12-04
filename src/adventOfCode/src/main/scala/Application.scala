import days.year2023.day4.{Day4Part1, Day4Part2}
import days.year2023.day5.{Day5Part1, Day5Part2}
import services.InputReaderFromFile

object Application extends App {
  private val inputReader = new InputReaderFromFile("data/2023/day5")
  private val part1 = new Day5Part1(inputReader).result
  private val part2 = new Day5Part2(inputReader).result

  println(s"resultat partie 1 : $part1")
  println(s"resultat partie 2 : $part2")
}
