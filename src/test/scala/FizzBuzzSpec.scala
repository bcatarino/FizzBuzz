import org.scalatest.{FlatSpec, Matchers}

class FizzBuzzSpec extends FlatSpec with Matchers {

  it should "throw IllegalArgumentException if start number in range is < 1" in {
    val ex = intercept[IllegalArgumentException] {
      FizzBuzz.fizzbuzz(0, 3)
    }
    assert(ex.getMessage === "requirement failed: " + FizzBuzz.NON_POSITIVE_NUMBER_ERROR_MSG)
  }

  it should "throw IllegalArgumentException if end number is smaller than start" in {
    val ex = intercept[IllegalArgumentException] {
      FizzBuzz.fizzbuzz(2, 1)
    }
    assert(ex.getMessage === "requirement failed: " + FizzBuzz.END_HIGHER_THAN_START_MSG)
  }

  it should "return number for non fizzbuzz number" in {
    FizzBuzz.fizzbuzz(2, 2) should equal("2")
  }

  it should "return fizz for 3" in {
    FizzBuzz.fizzbuzz(3, 3) should equal("fizz")
  }

  it should "return fizz for multiples of 3" in {
    FizzBuzz.fizzbuzz(6, 6) should equal("fizz")
  }

  it should "return buzz for 5" in {
    FizzBuzz.fizzbuzz(5, 5) should equal("buzz")
  }

  it should "return buzz for multiples of 5" in {
    FizzBuzz.fizzbuzz(10, 10) should equal("buzz")
  }

  it should "return fizzbuzz for 15" in {
    FizzBuzz.fizzbuzz(15, 15) should equal("fizzbuzz")
  }

  it should "return fizzbuzz for multiples of 15" in {
    FizzBuzz.fizzbuzz(45, 45) should equal("fizzbuzz")
  }

  it should "return 1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz for 1..20" in {
    FizzBuzz.fizzbuzz(1, 20) should equal("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz")
  }

  it should "not throw stackoverflow for huge ranges" in {
    FizzBuzz.fizzbuzz(1, 100000).length should be > 0
  }
}
