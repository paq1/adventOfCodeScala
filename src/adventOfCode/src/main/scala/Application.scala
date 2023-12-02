import days.year2023.day2.Day2Part2
import services.InputReaderFile

object Application extends App {
  val inputReader = new InputReaderFile("data/2023/day2")
  val res = new Day2Part2(inputReader).result

  println(res)
}
