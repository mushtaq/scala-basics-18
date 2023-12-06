
def squareM(x: Int): Int = x * x

val square: Function1[Int, Int] = new Function1[Int, Int] {
  override def apply(v1: Int): Int = v1 * v1
}

val square: Int => Int = new Function1[Int, Int] {
  override def apply(v1: Int): Int = v1 * v1
}

val square: Int => Int = (v1: Int) => v1 * v1

val square: Int => Int = v1 => v1 * v1

val square = (v1: Int) => v1 * v1

val square: Int => Int = squareM

val xs = List(1, 2, 3, 4)
val xs = List.apply(1, 2, 3, 4)

xs.map(x => x * x)
xs.map(x => x + 10)
xs.map(_ + 10)
xs.map { x =>
  x + 10
  x + 10
  x + 10
  x + 10
}

xs.map(squareM)

xs
xs(2)
xs.apply(2)

square(9)
square.apply(9)
