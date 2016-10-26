import scala.util.Properties

case class FizzBuzzReport(items: List[String]) {

  private lazy val report = {
    val replacedNumbers = items.map(item => if (item.forall(_.isDigit)) "integer" else item)
    replacedNumbers.groupBy(identity).mapValues(_.size).toList.sortBy(word => orderMap.get(word._1))
  }

  // Feels a bit unnecessary to sort results in the exact order as specified in the technical description of the
  // problem, but I wanted to be truthful to that anyway, just in case.
  private lazy val orderMap = Map("fizz" -> 1, "buzz" -> 2, "fizzbuzz" -> 3, "lucky" -> 4, "integer" -> 5)

  override def toString = (items.mkString(" ") :: report.map(entry => entry._1 + ": " + entry._2)).mkString(Properties.lineSeparator)
}