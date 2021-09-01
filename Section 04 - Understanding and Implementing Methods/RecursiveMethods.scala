package Section_04_Understanding_and_Implementing_Methods

// Demo: Recursive

object RecursiveMethods extends App {

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

  def rollingAverage(records: Vector[StockRecord], numDays: Int): Unit = {

    if (records.length >= numDays) {
      println("Execution Completed!")
    } else {

      val averageClose = records.map(_.close).take(numDays).sum / numDays
      println(s"Rolling average close for $numDays days " +
        s"date ${records.head.date}: $averageClose")

      val updatesRecords = records.drop(1)

      rollingAverage(updatesRecords, numDays)

    }
  }

  rollingAverage(readFinanceData(), 7)
}


/*
object RecursiveMethods extends App {

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

  def rollingAverage(numDays: Int): Unit = {

    var records = readFinanceData();
    while (records.length >= numDays) {
      val averageClose = records.map(_.close).take(numDays).sum / numDays
      println(s"Rolling average close for $numDays days " +
      s"date ${records.head.date}: $averageClose")

      records = records.drop(1)
    }

    println("Execution Completed!")
  }

  rollingAverage(7)
}
*/