package Section_04_Understanding_and_Implementing_Methods

// Demo: Nested Methods

object NestedMethods {

  def readFinanceData(): Vector[StockRecord] = {
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

  private val data = readFinanceData()

  def printStockData(ticker: String): Unit = {

    println("Date        | Ticker |  Close")
    printRecords()

    def printRecords(): Unit = {

      val filteredRecords = data.filter(_.ticker == ticker)
      for (row <- filteredRecords) {

        println(s"${row.date} | ${row.ticker}     | ${row.close}")
      }

      printSummary()

      def printSummary(): Unit = {

        printAverage()

        def printAverage(): Unit = {

          val averageClose = filteredRecords.filter(_.ticker == ticker).
            map(_.close).sum / filteredRecords.size
          println("Average close: " + averageClose)

          printStandardDeviation()

          def printStandardDeviation(): Unit = {
            var x = 0.0

            for (record <- filteredRecords) {
              x = x + Math.pow(record.close - averageClose, 2)
            }

            val variance = x / filteredRecords.size

            println("Standard deviation close: " + Math.sqrt(variance))
          }
        }
      }
    }
  }

  printStockData("BNS")

}


/*
// Versão 01

object NestedMethods {

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

  def printRecords(ticker: String): Unit = {

    println("Date        | Ticker |  Close")

    def printRecords(): Unit = {
      for (row <- data.filter(_.ticker == ticker)) {

        println(s"${row.date} | ${row.ticker}     | ${row.close}")
      }
    }

    printRecords()
  }

  printRecords("BNS")

}
*/
