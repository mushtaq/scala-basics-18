val map = Map(1 -> "a", 2 -> "b")

map: Map[Int, String]
map: (Int => String)

map(1)
map(2)

map.get(1)
map.get(2)
map.get(5)

// design of Option[+T]
// hint: like List[+T]

{
  sealed trait Option[+T]
  case object None             extends Option[Nothing]
  case class Some[T](value: T) extends Option[T]
}

def m() = {
  map.get(4) match {
    case Some(value) => println(value)
    case None        => println("missing value")
    case Some(value) => println(value)
  }
}
