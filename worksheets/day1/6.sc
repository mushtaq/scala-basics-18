
def map(xs: List[Int], f: Int => Int): List[Int] = {
  // xs.iterator: hasNext, next
  // while
  // Buffer
  // convert buffer to List by .toList
  ???
}

val xs = List(1, 2, 3, 4)

map(xs, x => x * x)
map(xs, x => x * 10)
map(xs, x => x.abs)
