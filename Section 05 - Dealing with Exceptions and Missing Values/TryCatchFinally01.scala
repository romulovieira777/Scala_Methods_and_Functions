package Section_05_Dealing_with_Exceptions_and_Missing_Values

// Demo: Try, Catch, and Finally

import java.io.{FileNotFoundException, IOException}
import scala.io.{BufferedSource, Source}

object TryCatchFinally01 extends App {

  def getLinesFromFile(filename: String): List[String] = {
    var sourcePath: BufferedSource = null

    try {
      sourcePath = Source.fromFile("src/main/scala/dividendStocks.csv")

      println("Reading file completed")

      sourcePath.getLines.toList
    } catch {
      case ex: FileNotFoundException => {
        println("File not found")
        List()
      }
      case ex: IOException => {
        println("Input/Output Exception")
        List()
      }
    } finally {
      println("Close file if it has been opened")
      if (sourcePath != null) {
        println("Closing file")
        sourcePath.close()
      }
    }
  }

  val lines = getLinesFromFile("src/main/scala/dividendStocks.csv")

  println("------Displaying lines")
  lines.foreach(println)
}


/*
object TryCatchFinally01 extends App {

  var sourcePath: BufferedSource = _

  try {

    sourcePath = Source.fromFile("src/main/scala/dividendStocks.csv")

    println("Reading file completed")

    val lines = sourcePath.getLines.toList
    lines.foreach(println)

    println("Displaying lines completed.")

  } catch {

    case ex:FileNotFoundException => {
      println("File not found")
    }

    case ex:IOException => {
      println("Input/Output Exception")
    }
  } finally {
    println("Close file if it has been opened")

    if (sourcePath != null) {
      println("Closing file")
      sourcePath.close()
    }
  }

  println("-----------------End of code reached")
}
/*
