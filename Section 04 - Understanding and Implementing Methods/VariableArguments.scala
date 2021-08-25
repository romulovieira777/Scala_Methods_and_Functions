package Section_04_Understanding_and_Implementing_Methods

// Demo: Varargs

object VariableArguments {

  def financeData(): Vector[StockRecord] = {
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

  def getRecords(tickers: String*): Vector[(String, String, Float)] = {

    val filterRecords = data.filter(record => tickers.contains(record.ticker))

    filterRecords.map(record => (record.date, record.ticker, record.close))
  }

  val tickers = List("TTM", "DB", "BNS")
  val records = getRecords(tickers:_*)

  records.foreach(println)

}




/*

// Versão 01


object VariableArguments {

  def financeData(): Vector[StockRecord] = {
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

  def getRecords(tickers: String*): Vector[(String, String, Float)] = {
    println(tickers.getClass)
    for (ticker <- tickers) println(ticker)

    val filterRecords = data.filter(record => tickers.contains(record.ticker))

    filterRecords.map(record => (record.date, record.ticker, record.close))
  }

  val records = getRecords("MSFT", "GOOG", "TM")

  records.foreach(println)

}
*/
