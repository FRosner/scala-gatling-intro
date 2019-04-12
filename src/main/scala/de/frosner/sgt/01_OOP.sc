// traits are similar to interfaces
trait Vehicle {
  def startEngine(): Boolean
  def drive(miles: Int): Boolean
}

// classes can inherit from other classes or traits
class Car(make: String, model: String) extends Vehicle {
  override def startEngine(): Boolean = {
    println("Engine started")
    return true
  }

  /*
  - Return type can be inferred (not recommended for public methods)
  - Braces for methods without parameters are optional, but have different semantics
  - Return statement is optional as everything is treated as an expression (see FP later)
   */
  def drive(miles: Int) = {
    println(s"Drove $miles miles")
    true
  }
}

// named parameters are possible
val myCar = new Car(make = "3", model = "Mazda")
myCar.startEngine()