
// Demo: Function InvocationWith Expression Blocks

object FunctionInvocationWithExpressionBlocks extends App {
  val source = io.Source.fromFile("src/main/resources/stockMarketData")
  for {
    line <- source.getLines().drop(1).toVector
    cols = line.split(",").map(_.trim)
  } yield StockRecord(cols(0). cols(1).toFloat
    , cols(2).toFloat
    , cols(3).toFloat
    , cols(4).toFloat
    , cols(5)
  )

  val records = readFinanceData()
  val getStocksDetails = (ticker: String) => records.filter(_.ticker == ticker)
  val ttmStockDetails = getStocksDetails("TTM")
  println("----------------TTM")
  println(ttmStockDetails)

  val randomStockDetails = getStocksDetails {
    val list = List("MSFT", "GOOG", "TM", "TTM", "DB", "BNS")
    val randomNumber = util.Random.nextInt(list.length)
    list(randomNumber)
  }
  println("------------------random stock")
  println(randomStockDetails)
}
