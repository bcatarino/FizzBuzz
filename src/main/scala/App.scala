object App {

  def main(args: Array[String]) = {

    require(args.length == 2, "Needs two arguments")
    require(args(0).forall(_.isDigit), "Not an int")
    require(args(1).forall(_.isDigit), "Not an int")

    println("Welcome to FizzBuzz")
    println(FizzBuzz.fizzbuzz(args(0).toInt, args(1).toInt))
  }
}