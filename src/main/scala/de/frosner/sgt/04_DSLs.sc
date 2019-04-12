/*
A combination of higher order functions, curly braces,
fluent interfaces, and implicit conversions allows us to
define DSLs.
*/

// Example 1: Expectation DSL (ScalaTest)
import org.scalatest._
import Matchers._

List("a", "b", "c") should have length 3

// Example 2: Routing DSL (Akka HTTP)
import akka.http.scaladsl.server.Directives._

val route = get {
  path("ping") {
    complete("pong")
  } ~
  path("pong") {
    complete("ping")
  }
}

// Example 3: Build definition DSL (sbt)
// see build.sbt

/*
DSLs look neat but can be hard to understand, extend, debug, or use even.
If you look at the source code of such DSL it's often very complex just
to enable you to use it DSL like.
*/