import java.util.concurrent.TimeUnit

import scala.concurrent.duration.FiniteDuration

// Methods can be used as operators
case class MyInt(value: Int) {
  def +(j: MyInt) = MyInt(this.value + j.value)
}
MyInt(5) + MyInt(3)

// This also works for pre- or postfix operators
// However I find that difficult to understand if someone does that and it raises feature warnings
case class MyLong(value: Long) {
  def seconds: FiniteDuration = FiniteDuration(value, TimeUnit.SECONDS)
  def unary_! : MyLong = MyLong(-value)
}
!MyLong(3)
MyLong(5) seconds

// Implicit conversions can be used to extend an existing class
// Use implicits with caution as they can produce unreadable code
implicit def Long2MyLong(value: Long) = MyLong(value)
5 seconds

// There are predefined implicit conversions
5 to 10

// And ones you can import like scala.concurrent.duration.DurationLong
import scala.concurrent.duration.DurationLong
5 minutes