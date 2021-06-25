// Demo: The lazy val Type Modifier

object VarValLazyValDef extends App {
  lazy val data = {
    println("Array is initialized");
    Array("MSFT", "GOOG", "TM")
  }

  println("Before accessing data")
  data.foreach(println)

  println("------------------------")
  data.foreach(println)
}


/*
object VarValLazyValDef extends App {
  var stockPrice = 14
  lazy val volume = {println("Assigning val"); 100}

  println("Calculating final value")

  var finalValue = stockPrice * volume

  println(s"Final value is: $finalValue")
}
*/


/*
object VarValLazyValDef extends App {
  var stockPrice = 14
  val volume = {println("Assigning val"); 100}

  println("Calculating final value")

  var finalValue = stockPrice * volume

  println(s"Final value is: $finalValue")
}
*/


/*
object VarValLazyValDef extends App {
  var stockPrice = 14
  lazy val volume = 100

  var finalValue = stockPrice * volume

  println(s"Final value is: $finalValue")
}
*/


// Demo: The def Keyword

/*
object VarValLazyValDef extends App {
  def data: Array[String] = {
    println("Array is initialized");
    Array("MSFT", "GOOG", "TM")
  }

  println("Before accessing data")
  data.foreach(println)

  println("------------------------")
  data.foreach(println)
}
*/


/*
object VarValLazyValDef extends App {
  def stockPrice: Int = {
    println("Returning stock price")
    14
  }

  def volume: Int = {
    println("Returning volume")
    100
  }

  def finalValue: Int = stockPrice * volume
  println(s"The final value is: $finalValue")

  println("------------------------")

  def finalValueAgain: Int = stockPrice * volume
  println(s"The final value is: $finalValueAgain")
}
*/


/*
object VarValLazyValDef extends App {
  def stockPrice: Int = 14
  def volume: Int = 100

  //def finalValue: Int = stockPrice * volume

  // To convert an Int value to a String
  def finalValue: String = (stockPrice * volume).toString

  println(s"The final value is: $finalValue")
}
*/


// Demo: The val Type Modifier

/*
object VarValLazyValDef extends App {
  val data = {println("Array is initialized"); Array("MSFT", "GOOG", "TM")}

  println("Before accessing data")
  data.foreach(println)

  println("---------------------")
  data(0) = "AAPL"
  data(2) = "TSLA"

  data.foreach(println)
}
*/


/*
object VarValLazyValDef extends App {
  val data = {println("Array is initialized"); Array("MSFT", "GOOG", "TM")}

  println("Before accessing data")
  data.foreach(println)

  println("---------------------")
  data.foreach(println)

  println("---------------------")
  // we can not reassign val. So this will be error
  data = {println("New Array is initialized"); Array("AAPL")}
  data.foreach(println)
}
*/


/*
object VarValLazyValDef extends App {
  var stockPrice = 14
  val volume = 100

  // we can not reassign val. So this will be error
  volume = 1500

  var finalValue = stockPrice * volume

  println(s"Final value is: $finalValue")
}
*/


// Demo: The var Type Modifier
/*
object VarValLazyValDef extends App {
  var data = {println("Array is initialized"); Array("MSFT", "GOOG", "TM")}

  println("Before accessing data")
  data.foreach(println)

  println("---------------------")
  data = {println("New Array is initialized"); Array("AAPL")}
  data.foreach(println)
}
*/


/*
object VarValLazyValDef extends App {
  var stockPrice = 14
  var volume = 100

  volume = 1000

  var finalValue = stockPrice * volume

  println(s"Final value is: $finalValue")
}
 */
