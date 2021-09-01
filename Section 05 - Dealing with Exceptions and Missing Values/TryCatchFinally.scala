package Section_05_Dealing_with_Exceptions_and_Missing_Values

import java.io.{FileNotFoundException, IOException}
import scala.io.Source

// Demo: Hadling Exceptions Using try-catch Blocks

object TryCatchFinally extends App {

  try {

    val sourcePath = Source.fromFile("src/main/scala/dividendStocks.csv")

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
  }

  println("-----------------End of code reached")
}


/*
object TryCatchFinally extends App {

  val sourcePath = Source.fromFile("src/main/scala/dividendStocks.csv")

  println("Reading file completed")

  val lines = sourcePath.getLines.toList
  lines.foreach(println)

  println("Displaying lines completed.")

}
*/
