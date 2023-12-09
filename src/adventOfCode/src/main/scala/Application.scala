import days.year2023.day6.{Day6Part1, Day6Part2}
import services.InputReaderFromFile

object Application extends App {
  private val inputReader = new InputReaderFromFile("data/2023/day6")
  private val part1 = new Day6Part1(inputReader).result
  private val part2 = new Day6Part2(inputReader).result

  println(s"resultat partie 1 : $part1")
  println(s"resultat partie 2 : $part2")
}
