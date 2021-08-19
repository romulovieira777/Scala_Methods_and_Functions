package Section_04_Understanding_and_Implementing_Methods

// Demo: Method Evaluation Strategies

// Versão 03

object MethodEvaluationStrategies extends App {
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

  def makeMomentumBasedTradingDecision(record: => StockRecord, percentDelta: Float): Unit = {
    println(s"Calculating percentage move")

    lazy val stockRecord = record;
    
    val percentageMove = ((record.close - record.open) / record.open) * 100;

    if (percentageMove > percentDelta) {
      println(s"Buy ${record.ticker}")
    } else if (percentageMove < -percentDelta) {
      println(s"Sell ${record.ticker}")
    } else {
      println(s"No call on ${record.ticker}")
    }
  }

  def getRecord(ticker: String): StockRecord = {
    println(s"Accessing record for ${ticker}")
    val filterdRecords = records.filter(_.ticker == ticker)
    assert(filterdRecords.length == 1)

    filterdRecords(0)
  }

  println("-------------------------")
  makeMomentumBasedTradingDecision(getRecord("MSFT"), 1)

  println("-------------------------")
  makeMomentumBasedTradingDecision(getRecord("TM"), 1)
}

/*
// Versão 02

object MethodEvaluationStrategies extends App {
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

  def makeMomentumBasedTradingDecision(record: => StockRecord, percentDelta: Float): Unit = {
    println(s"Calculating percentage move")

    val percentageMove = ((record.close - record.open) / record.open) * 100;

    if (percentageMove > percentDelta) {
      println(s"Buy ${record.ticker}")
    } else if (percentageMove < -percentDelta) {
      println(s"Sell ${record.ticker}")
    } else {
      println(s"No call on ${record.ticker}")
    }
  }

  def getRecord(ticker: String): StockRecord = {
    println(s"Accessing record for ${ticker}")
    val filterdRecords = records.filter(_.ticker == ticker)
    assert(filterdRecords.length == 1)

    filterdRecords(0)
  }

  println("-------------------------")
  makeMomentumBasedTradingDecision(getRecord("MSFT"), 1)

  println("-------------------------")
  makeMomentumBasedTradingDecision(getRecord("TM"), 1)
}
*/


/*
// Versão 01

object MethodEvaluationStrategies extends App {
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
}
*/