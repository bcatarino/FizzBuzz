import org.scalatest.{FlatSpec, Matchers}

import scala.util.Properties

class FizzBuzzReportSpec extends FlatSpec with Matchers {

  private def getMatchString(strings: List[String]) = strings mkString Properties.lineSeparator

  it should "throw NullPointerException if null is given" in {
    intercept[NullPointerException] {
      FizzBuzzReport(null.asInstanceOf[List[String]]).toString should equal("")
    }
  }

  it should "return empty string if no string or list is provided" in {
    FizzBuzzReport(List()).toString should equal("")
  }

  it should "group with a count" in {
    FizzBuzzReport(List("fizz", "buzz", "fizz")).toString should equal(getMatchString(List("fizz buzz fizz", "fizz: 2", "buzz: 1")))
  }

  it should "change number to integer" in {
    FizzBuzzReport(List("2")).toString should equal(getMatchString(List("2", "integer: 1")))
  }

  it should "group numbers together" in {
    FizzBuzzReport(List("2", "4")).toString should equal(getMatchString(List("2 4", "integer: 2")))
  }

  it should "sort reports" in {
    FizzBuzzReport(List("2", "lucky", "fizz", "4")).toString should equal(getMatchString(List("2 lucky fizz 4", "fizz: 1", "lucky: 1", "integer: 2")))
  }
}
