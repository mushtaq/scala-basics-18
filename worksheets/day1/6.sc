
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

//@annotation.tailrec
def map(xs: List[Int], f: Int => Int): List[Int] = {
  if(xs.isEmpty) {
    xs
  } else {
    f(xs.head) :: map(xs.tail, f)
  }
}

def map(xs: List[Int], f: Int => Int): List[Int] = {
  @annotation.tailrec
  def loop(rem: List[Int], stack: List[Int]): List[Int] = {
    if(rem.isEmpty) {
      stack
    } else {
      val newStack = f(rem.head) :: stack
      loop(rem.tail, newStack)
    }
  }
  loop(xs, Nil).reverse
}

//val xs = List(1, 2, 3, 4)
val xs = (1 to 10000).toList

map(xs, x => x * x)
map(xs, x => x * 10)
map(xs, x => x + 1)
map(xs, x => x.abs)
