import scala.annotation.tailrec

object FizzBuzz {

  val NON_POSITIVE_NUMBER_ERROR_MSG = "The range can only have positive numbers"
  val END_HIGHER_THAN_START_MSG = "The lower number in the range cannot be higher than the top number"

  def fizzbuzz(start: Int, end: Int): String = {
    require(start > 0, NON_POSITIVE_NUMBER_ERROR_MSG)
    require(end >= start, END_HIGHER_THAN_START_MSG)

    fizzbuzzrec(start, end, List())
  }

  @tailrec
  def fizzbuzzrec(current: Int, top: Int, result: List[String]): String = current match {
    case _ if current > top => result.reverse mkString " "
    case _ if current % 15 == 0 => fizzbuzzrec(current + 1, top, "fizzbuzz" :: result)
    case _ if current % 5 == 0 => fizzbuzzrec(current + 1, top, "buzz" :: result)
    case _ if current % 3 == 0 => fizzbuzzrec(current + 1, top, "fizz" :: result)
    case _ => fizzbuzzrec(current + 1, top, current.toString :: result)
  }
}