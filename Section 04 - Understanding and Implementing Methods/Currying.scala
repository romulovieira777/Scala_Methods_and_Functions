// Demo: Currying

// Versão 04
object Currying extends App {
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
      cols(2)
    )
  }

  val records = readFinanceData()

  def getPrice(date: String, ticker: String) (priceType: String): Float = {
    val recordsByDate = records.filter(_.date == date)
    val recordsByTicker = recordsByDate.filter(_.ticker == ticker)

    val price = priceType match {
      case "open" => recordsByTicker(0).open
      case "close" => recordsByTicker(0).close
      case "high" => recordsByTicker(0).high
      case "low" => recordsByTicker(0).low
    }
    price
  }


  val getPriceForDate = getPrice("12-06-2020") _

  println("------------------DB")
  println("Open: " + getPriceForDate("open"))
  println("Close: " + getPriceForDate("close"))
  println("High: " + getPriceForDate("high"))
  println("Low: " + getPriceForDate("low"))

  val getPriceForDateForToyota =  getPrice("12-06-2020")("TM") _

  println("------------------TM")
  println("Open: " + getPriceForDateForToyota("open"))
  println("Close: " + getPriceForDateForToyota("close"))
  println("High: " + getPriceForDateForToyota("high"))
  println("Low: " + getPriceForDateForToyota("low"))
}


/*
// Versão 03
object Currying extends App {
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
      cols(2)
    )
  }

  val records = readFinanceData()

  def getPrice(date: String, ticker: String) (priceType: String): Float = {
    val recordsByDate = records.filter(_.date == date)
    val recordsByTicker = recordsByDate.filter(_.ticker == ticker)

    val price = priceType match {
      case "open" => recordsByTicker(0).open
      case "close" => recordsByTicker(0).close
      case "high" => recordsByTicker(0).high
      case "low" => recordsByTicker(0).low
    }
    price
  }
  val getPriceForGoog = getPrice("12-06-2020", "GOOG") _

  println("------------------GOOG")
  println("Open: " + + getPriceForGoog("open"))
  println("Close: " + getPriceForGoog("close"))
  println("High: " + getPriceForGoog("high"))
  println("Low: " + getPriceForGoog("low"))

  val getPriceForMsft = getPrice("12-06-2020", "MSFT") _

  println("------------------MSFT")
  println("Open: " + + getPriceForGoog("open"))
  println("Close: " + getPriceForGoog("close"))
  println("High: " + getPriceForGoog("high"))
  println("Low: " + getPriceForGoog("low"))
}
*/


/*
// Versão 02
object Currying extends App {
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
      cols(2)
    )
  }

  val records = readFinanceData()

  def getPrice(date: String, ticker: String) (priceType: String): Float = {
    val recordsByDate = records.filter(_.date == date)
    val recordsByTicker = recordsByDate.filter(_.ticker == ticker)

    val price = priceType match {
      case "open" => recordsByTicker(0).open
      case "close" => recordsByTicker(0).close
      case "high" => recordsByTicker(0).high
      case "low" => recordsByTicker(0).low
    }
    price
  }
  println(getPrice("12-06-2020", "GOOG")("open"))
}
*/


/*
// Versão 01
object Currying extends App {
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
      cols(2)
    )
  }

  val records = readFinanceData()

  def getPrice(date: String, ticker: String, priceType: String): Float = {
    val recordsByDate = records.filter(_.date == date)
    val recordsByTicker = recordsByDate.filter(_.ticker == ticker)

    val price = priceType match {
      case "open" => recordsByTicker(0).open
      case "close" => recordsByTicker(0).close
      case "high" => recordsByTicker(0).high
      case "low" => recordsByTicker(0).low
    }
    price
  }
  println(getPrice("12-06-2020", "GOOG", "open"))
}
*/