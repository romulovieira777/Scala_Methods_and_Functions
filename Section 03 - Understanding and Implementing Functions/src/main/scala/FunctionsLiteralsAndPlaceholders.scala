// Demo: Placeholders


object FunctionsLiteralsAndPlaceholders extends App {
  val sayHello = () => println("Hello function literal!")

  val multiplyBy100 = (x: Int) => x * 100

  val addTwoNumbers = (x: Int, y: Int) => x + y

  val addThreeNumbers = (x: Int, y: Int, z: Int) => x + y + z

  sayHello()
  println(multiplyBy100.apply(7))
  println(addTwoNumbers.apply(7, 10))
  println(addThreeNumbers.apply(7, 10, 3))

  println("------------------------------------------------")

  println("sayHello.isInstanceOf[Function0[_]]: " + sayHello.isInstanceOf[Function0[_]])
  print("multiplyBy100.isInstanceOf[Function1[_,_]]" + multiplyBy100.isInstanceOf[Function1[_,_]])
  println("addTwoNumbers.isInstanceOf[Function2[_,_,_,_]]: " +
    addTwoNumbers.isInstanceOf[Function2[_,_,_]])
  println("addThreeNumbers.isInstanceOf[Function2[_,_,_,_]]: " +
    addThreeNumbers.isInstanceOf[Function3[_,_,_,_]])

}


/*
object FunctionsLiteralsAndPlaceholders extends App {
  val stockTickersInLowerCase = List("goog", "ps", "tsla", "aapl", "msft")
  val stockTickers = stockTickersInLowerCase.map(_.toUpperCase)
  println(stockTickers)
}
*/


/*
object FunctionsLiteralsAndPlaceholders extends App {
  val googStockPrices = List(1367.36, 1360.66, 1394.20, 1393.33,
    1404.31, 1419,82, 1429.73)

  val googStockPricesGreaterThan1400 = googStockPrices.filter(_ > 1400)

  println(googStockPricesGreaterThan1400)
}
*/

// Demo: Functions Literals

/*
object FunctionsLiteralsAndPlaceholders extends App {
  var calculateResult = (x: Int, y: Int) => {
    val sum = x + y
    val diff = x - y
    val product = x * y
    val quotient = x / y

    (sum, diff, product, quotient)
  }
  println("---------- 10 and 5")
  println(calculateResult(10, 5))

  println("---------- 40 and 8")
  println(calculateResult(40, 8))
}
*/

/*
object FunctionsLiteralsAndPlaceholders extends App {
  var multiplyBy = (x: Int) => x * 100

  println(multiplyBy(3))

  multiplyBy = (x: Int) => x * 1000

  println(multiplyBy(3))
}
*/