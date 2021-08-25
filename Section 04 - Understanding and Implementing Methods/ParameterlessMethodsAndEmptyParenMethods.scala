package Section_04_Understanding_and_Implementing_Methods

// Demo: Parameterless And Empty ParenMethods


object ParameterlessMethodsAndEmptyParenMethods extends App {

  val financeData(): Vector[StockRecord] = {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0),
      cols(1).toFloat,
      cols(2).toFloat,
      cols(3).toFloat,
      cols(4).toFloat,
      cols(5)
    )
  }

  private val data = financeData()

  def numberOfRows: Int = data.size

  def minimumCloseValue: Double = data.map(_.close).min

  def maximumCloseValue: Double = data.map(_.close).max

  def averageCloseValue: Double = data.map(_.close).sum / data.size

  println(s"Number of rows: " + numberOfRows)
  println(s"Minimum close value: " + minimumCloseValue)
  println(s"Maximum close value: " + maximumCloseValue)
  println(s"Average close value " + averageCloseValue)

}


/*

Versão 02

object ParameterlessMethodsAndEmptyParenMethods extends App {

  val financeData(): Vector[StockRecord] = {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0),
      cols(1).toFloat,
      cols(2).toFloat,
      cols(3).toFloat,
      cols(4).toFloat,
      cols(5)
    )
  }

  private val data = financeData

  def numberOfRows(): Int = data.size

  def minimumCloseValue(): Double = data.map(_.close).min

  def maximumCloseValue(): Double = data.map(_.close).max

  def averageCloseValue(): Double = data.map(_.close).sum / data.size

  println(s"Number of rows: " + numberOfRows())
  println(s"Minimum close value: " + minimumCloseValue())
  println(s"Maximum close value: " + maximumCloseValue())
  println(s"Average close value " + averageCloseValue())

}
*/

/*
// Versão 01

object ParameterlessMethodsAndEmptyParenMethods extends App {

  val financeData: Vector[StockRecord] = {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0),
      cols(1).toFloat,
      cols(2).toFloat,
      cols(3).toFloat,
      cols(4).toFloat,
      cols(5)
    )
  }

  private val data = financeData

  def numberOfRows: Int = data.size

  def minimumCloseValue: Double = data.map(_.close).min

  def maximumCloseValue: Double = data.map(_.close).max

  def averageCloseValue: Double = data.map(_.close).sum / data.size

  println(s"Number of rows: " + numberOfRows)
  println(s"Minimum close value: " + minimumCloseValue)
  println(s"Maximum close value: " + maximumCloseValue)
  println(s"Average close value " + averageCloseValue)

}
*/