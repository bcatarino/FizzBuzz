import org.scalatest.{FlatSpec, Matchers}

class InterestSpec extends FlatSpec with Matchers {

  val bands = Seq(Band(0, 1000, 0.01), Band(1000, 5000, 0.02), Band(5000, Double.MaxValue, 0.03))

  it should "throw IllegalArgumentException if amount is negative" in {
    val ex = intercept[IllegalArgumentException] {
      new Interest(bands).calculateInterest(-1)
    }
    assert(ex.getMessage === "requirement failed: " + Interest.AMOUNT_NEGATIVE_MSG)
  }

  it should "return 10 if amount is 1000" in {
    new Interest(bands).calculateInterest(1000d) should equal(10d)
  }

  it should "return 90 if amount is 5000" in {
    new Interest(bands).calculateInterest(5000d) should equal(90d)
  }

  it should "return 0 if amount is 0" in {
    new Interest(bands).calculateInterest(0d) should equal(0d)
  }

  it should "return 5 if amount is 500" in {
    new Interest(bands).calculateInterest(500d) should equal(5d)
  }

  it should "return 20 if amount is 1500" in {
    new Interest(bands).calculateInterest(1500d) should equal(20d)
  }

  it should "return 120 if amount is 6000" in {
    new Interest(bands).calculateInterest(6000d) should equal(120d)
  }

  it should "return 1200 if amount is 6000" in {
    val value = new Interest(bands).calculateInterest(Double.MaxValue)
    println(value)
    value should equal(120d)
  }
}
