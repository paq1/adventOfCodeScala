package services

import scala.io.Source

class InputReaderFromFile(filePath: String) extends InputReader {
  override def getList: List[String] = {
    val source = Source.fromFile(filePath)
    val lines = source.getLines.toList
    source.close()
    lines
  }
}
