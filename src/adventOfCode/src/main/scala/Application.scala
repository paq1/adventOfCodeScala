import days.year2023.day3.Day3Part2
import services.InputReaderFile

object Application extends App {
  val inputReader = new InputReaderFile("data/2023/day3")
  val res = new Day3Part2(inputReader).result

  println(res)
}
