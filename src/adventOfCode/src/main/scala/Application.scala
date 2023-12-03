import days.year2023.day3.Day3Part1
import services.InputReaderFile

object Application extends App {
  val inputReader = new InputReaderFile("data/2023/day3")
  val res = new Day3Part1(inputReader).result

  println(res)
}
