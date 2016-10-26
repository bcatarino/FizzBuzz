import scala.annotation.tailrec

object FizzBuzz {

  val NON_POSITIVE_NUMBER_ERROR_MSG = "The range can only have positive numbers"
  val END_HIGHER_THAN_START_MSG = "The lower number in the range cannot be higher than the top number"

  def fizzbuzz(start: Int, end: Int): String = {
    require(start > 0, NON_POSITIVE_NUMBER_ERROR_MSG)
    require(end >= start, END_HIGHER_THAN_START_MSG)

    val result = fizzbuzzrec(start, end, List())
    FizzBuzzReport(result).toString
  }

  // It's not clear if it should return lucky only if it's only one 3 or if there's at least one 3, so I assumed the later.
  @tailrec
  private def fizzbuzzrec(current: Int, top: Int, result: List[String]): List[String] = current match {
    case _ if current > top => result.reverse
    case _ if current.toString.contains("3") => fizzbuzzrec(current + 1, top, "lucky" :: result)
    case _ if current % 15 == 0 => fizzbuzzrec(current + 1, top, "fizzbuzz" :: result)
    case _ if current % 5 == 0 => fizzbuzzrec(current + 1, top, "buzz" :: result)
    case _ if current % 3 == 0 => fizzbuzzrec(current + 1, top, "fizz" :: result)
    case _ => fizzbuzzrec(current + 1, top, current.toString :: result)
  }
}