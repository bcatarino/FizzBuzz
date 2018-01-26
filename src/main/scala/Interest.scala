import scala.annotation.tailrec

class Interest(interestBands: Seq[Band]) {

  def calculateInterest(value: Double): Double = {
    require(value >= 0d, Interest.AMOUNT_NEGATIVE_MSG)
    calculateInterest(value, 0d)

    interestBands.map(band => if (value < band.min) 0 else
      (band.max - band.min) * band.rate).sum
  }

  @tailrec
  private def calculateInterest(value: Double, interest: Double): Double = value match {
    case _ if value <= 1000d => interest + value * 0.01
    case _ if value > 1000d && value <= 5000d => calculateInterest(1000d, interest + (value - 1000) * 0.02)
    case _ if value > 5000d => calculateInterest(5000d, interest + (value - 5000) * 0.03)
  }
}

object Interest {

  lazy val AMOUNT_NEGATIVE_MSG = "The amount should not be negative"
}




case class Band(min: Double, max: Double, rate: Double)