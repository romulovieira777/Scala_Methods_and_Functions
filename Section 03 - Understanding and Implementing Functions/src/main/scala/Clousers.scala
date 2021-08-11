// Demo: Clousers

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date

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

  val getDecisionMakerFunction = (records: Vector[StockRecord], date: String) => {

    val currDate = date
    val currRecords = records

    val makeDecision = (percentDelta: Float) => {
      val filterRecords = records.filter(_.date == date)
      assert(filterRecords.length == 1)

      val record = filterRecords.head
      val percentageMove = ((record.close - record.open) / record.open) * 100

      if (percentageMove > percentDelta) {
        println(s"Buy nased on date ${record.date}, " +
          s"percentage move ${percentageMove}")
      } else if (percentageMove < -percentDelta) {
        println(s"Sell based on date ${record.date}, " +
        s"percentage move ${percentageMove}")
      } else {
        println(s"No call based on date ${record.date}, " +
        s"percentage move ${percentageMove}")
      }
    }

    makeDecision
  }

  var date = "2020-05-15"
  println("--------------------------------------")
  val decisionMaker1 = getDecisionMakerFunction(readFinanceData())
  decisionMaker1(2)
}
