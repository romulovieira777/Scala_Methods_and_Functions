package Section_05_Dealing_with_Exceptions_and_Missing_Values

//Demo: Try-Success-Failure

import java.io.{BufferedReader, FileReader}
import scala.io.{BufferedSource, Source}
import scala.util.{Failure, Success, Try, Using}

object TrySuccessFailure extends App {

  val lines: TRY[List[String]] =
    Using.resource(new BufferedReader(new FileReader(
      "src/main/scala/dividendStocks.csv"))) {
      reader => Iterator.continually(reader.readLine()).takeWhile(_ != null).toList
    }

  lines match {
    case Success(lines) => lines.foreach(println)
    case Failure(exception) => println(exception.getMessage)
  }
}


/*
object TrySuccessFailure extends App {

  val lines: List[String] =
    Using.resource(new BufferedReader(new FileReader(
      "src/main/scala/dividendStocks.csv"))) {
      reader => Iterator.continually(reader.readLine()).takeWhile(_ != null).toList
    }

  lines.foreach(println)
}
/*


/*
object TrySuccessFailure extends App {

  def getLinesFromFile(filename: String): Try[BufferedSource] = {
    Try(Source.fromFile(filename))
  }

  val trySourcePath: Try[BufferedSource] =
    getLinesFromFile("src/main/scala/dividendStocks.csv")

  trySourcePath match {
    case Success(sourcePath) => sourcePath.getLines.toList.foreach(println)
    case Failure(exception) => println(exception.getMessage)
  }
}
/*