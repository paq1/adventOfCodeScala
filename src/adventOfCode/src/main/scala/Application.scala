import days.`2023`.day1.Day1Part2
import services.InputReaderFile

object Application extends App {
  val inputReader = new InputReaderFile("data/2023/day1")
  val resultDay1Part1 = new Day1Part2(inputReader).result

  println(resultDay1Part1)
}
