import days.year2023.day4.{Day4Part1, Day4Part2}
import services.InputReaderFile

object Application extends App {
  private val inputReader = new InputReaderFile("data/2023/day4")
  private val part1 = new Day4Part1(inputReader).result
  private val part2 = new Day4Part2(inputReader).result

  println(s"resultat partie 1 : $part1")
  println(s"resultat partie 2 : $part2")
}
