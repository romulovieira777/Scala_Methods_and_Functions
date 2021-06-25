// Demo var, val, lazy val, and def Using a Scala Worksheet

// Creating an immutable variable
val volume = 100
volume
println(s"Volume is: $volume")


// Creating a mutable variable
var stockPrice = 79
println(s"Stock price is: $stockPrice")

stockPrice = 78
println(s"Now stock price is: $stockPrice")


// Creating a function and defining the method
def volume: Int = 1000
def stockPrice: Int = 79
def finalValue: Int = stockPrice * volume

finalValue


// Creating a variable using lazy val that is immutable
val faceValue = 5
lazy val lazFaceValue = 5

faceValue
lazFaceValue
