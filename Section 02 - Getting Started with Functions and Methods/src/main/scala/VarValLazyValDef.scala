// Demo: The def Keyword




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
