
import days.`2019`.day1.Day1Part1
import services.InputReaderFile

object Application extends App {
  val inputReader = new InputReaderFile("data/2019/day1")
  val resultDay1Part1 = new Day1Part1(inputReader).result

  println(resultDay1Part1)
}
