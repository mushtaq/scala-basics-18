
def map(xs: List[Int], f: Int => Int): List[Int] = {
  val result = collection.mutable.Buffer.empty[Int]

  val iterator = xs.iterator
  while (iterator.hasNext) {
    val elm = iterator.next()
    val updatedElm = f(elm)
    result.append(updatedElm)
  }

  result.toList
}

def map(xs: List[Int], f: Int => Int): List[Int] = {
  var result = List.empty[Int]

  val iterator = xs.iterator
  while (iterator.hasNext) {
    val elm = iterator.next()
    val updatedElm = f(elm)
    result = updatedElm :: result
  }

  result.reverse
}

def map(xs: List[Int], f: Int => Int): List[Int] = {
  ???
}

val xs = List(1, 2, 3, 4)

map(xs, x => x * x)
map(xs, x => x * 10)
map(xs, x => x + 1)
map(xs, x => x.abs)
