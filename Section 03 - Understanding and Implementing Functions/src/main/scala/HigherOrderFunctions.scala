// Demo: Higher Order Functions
object HelloApp extends App {

  val source = io.Source.fromFile("")
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

  println(records.getClass)

  for (record <- records) {
    println(record)
  }
}
