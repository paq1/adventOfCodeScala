package services

class InputReaderFile(filePath: String) extends InputReader {
  override def getList: List[String] = {
    val source = scala.io.Source.fromFile(filePath)
    val lines = source.getLines.toList
    source.close()
    lines
  }
}
