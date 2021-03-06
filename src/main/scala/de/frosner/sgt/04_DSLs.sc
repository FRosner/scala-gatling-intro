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

// Example 4: Gatling
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://computer-database.gatling.io")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("BasicSimulation")
    .exec(http("request_1")
    .get("/"))
    .pause(5)

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpProtocol)

}

/*
DSLs look neat but can be hard to understand, extend, debug, or use even.
If you look at the source code of such DSL it's often very complex just
to enable you to use it DSL like.
*/