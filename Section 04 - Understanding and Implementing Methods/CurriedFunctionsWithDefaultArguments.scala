package Section_04_Understanding_and_Implementing_Methods

// Demo: Curried Functions With Default Arguments

object CurriedFunctionsWithDefaultArguments extends App {
  val readFinanceData = () => {
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

  val records = readFinanceData()

  def getStockPriceDetails(date: String = "11-06-2020")(ticker: String = "GOOG")(priceType: String):
  (String, String, Float) = {
    println(s"Accessing records for ${date}")
    var filterdRecords = records.filter(_.date == date)

    println(s"Accessing records for ${ticker}")
    filterdRecords = filterdRecords.filter(_.ticker == ticker)

    val record = filterdRecords(0)

    println(s"Accessing price type ${priceType}")

    val price = priceType match {
      case "open" => record.open
      case "close" => record.close
      case "high" => record.high
      case "low" => record.low
    }

    (record.date, record.ticker, price)
  }

  println(getStockPriceDetails()()(priceType = "high"))
  println(getStockPriceDetails()(ticker = "MSFT")(priceType = "high"))
  println(getStockPriceDetails(date = "12-06-2020")()(priceType = "high"))

}
