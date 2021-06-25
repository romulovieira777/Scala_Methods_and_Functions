// Demo: Functions and Methods II

object MethodsAndFunctions extends App {
  val data = Array("PS", "MSFT", "GOOG", "AAPL", "TSLA")

  def existsMethod(ticker: String): Boolean = data.contains(ticker)

  val exitsFunction = (ticker: String) => data.contains(ticker)

  val exists = existsMethod _

  println("Does PS exist (method): " + existsMethod("PS"))
  println("Does TM exist (function): " + exitsFunction("TM"))
  println("Does GOOG exist (function): " + exists("GOOG"))
}



// Demo: Functions and Methods I

/*
object MethodsAndFunctions extends App {
  val data = Array("PS", "MSFT", "GOOG", "AAPL", "TSLA")

  def getNumRowsMethod: Int = data.length

  val getNumRowsFunction = () => data.length

  println("Total number of row(method): " + getNumRowsMethod)
  println("Total number of row(function): " + getNumRowsFunction())
}
*/