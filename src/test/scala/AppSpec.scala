import org.scalatest.{FlatSpec, Matchers}

class AppSpec extends FlatSpec with Matchers {

  it should "throw IllegalArgumentException if no arguments are provided" in {
    intercept[IllegalArgumentException] {
      App.main(Array())
    }
  }

  it should "throw IllegalArgumentException if one argument is provided" in {
    intercept[IllegalArgumentException] {
      App.main(Array("4"))
    }
  }

  it should "throw IllegalArgumentException if arguments are not numbers" in {
    intercept[IllegalArgumentException] {
      App.main(Array("a", "gffe"))
    }
  }

  it should "throw IllegalArgumentException if arguments are doubles" in {
    intercept[IllegalArgumentException] {
      App.main(Array("3", "3.5"))
    }
  }

  it should "execute to the end if both arguments are valid numbers" in {
    try {
      App.main(Array("3", "5"))
      assert(true)
    } catch {
      case e: Exception => assert(false)
    }
  }
}
