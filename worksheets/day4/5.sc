val map = Map(1 -> "a", 2 -> "b")

map.view
  .mapValues(x => s"Hello $x")
  .toMap

map.map { pair =>
  (pair._1, s"Hello ${pair._2}")
}

map.map { pair =>
  val (key, value) = pair
  (key, s"Hello $value")
}

map.map { pair =>
  pair match {
    case (key, value) => (key, s"Hello $value")
  }
}

map.map { case (key, value) =>
  (key, s"Hello $value")
}

map.map {
  case (1, value) => (1, s"Hello $value")
  case (2, value) => (2, s"Hello $value and more")
}

val pair   = (1, "abc")
val (x, y) = pair

pair match {
  case (k, v) =>
}
