// Functions are values
val add = (a: Int, b: Int) => a + b
add(5, 3)

// Currying possible
val addC = (a: Int) => (b: Int) => a + b
addC(5)(3)

object Math {
  // Methods can be converted to functions using partial application
  def addDef(a: Int, b: Int) = a + b
  val addVal = addDef _

  // The other way around is not possible
  val subVal = (a: Int, b: Int) => a - b
  def subDef = subVal
}
Math.addDef(5, 3)
Math.addVal(5, 3)

// Functions can be passed as parameters
val modify = (i: Int) => (f: Int => Int) => f(i)
modify(5)(addC(3))

// This can be used to "decorate" functions
object Utils {
  def measure[T](operation: String)(f: => T) = {
    val start = System.nanoTime()
    val res = f
    println(s"$operation took ${System.nanoTime() - start} ns")
    res
  }
}
Utils.measure("Adding two numbers")(add(5, 3))

// Curly braces can replace normal ones, allowing arbitrary code within
Utils.measure("Assigning and printing a value") {
  val x = 5
  println(x)
}
