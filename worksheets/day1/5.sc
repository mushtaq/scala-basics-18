def square(x: Int) = x * x
def square(x: Int): Int = x * x
def add(x: Int, y: Int): Int = x + y

//trait Function1[I1, O]
//trait Function2[I1, I2, O]
//Function1[Int, Int]
//Function1[Int, Int, Int]

val x: Function1[Int, Int] = square
new Function1[Int, Int] {
  override def apply(v1: Int): Int = square(v1)
}
new Function2[Int, Int, Int] {
  override def apply(v1: Int, v2: Int): Int = add(v1, v2)
}

val x: Int => Int = square
val x: Int => Int =
  x => square(x)
val x: Int => Int =
  x => x * x

val y: Function2[Int, Int, Int] = add
val y: (Int, Int) => Int = add
val y: (Int, Int) => Int =
  (v1, v2) => add(v1, v2)
val y: (Int, Int) => Int =
  (v1, v2) => v1 + v2

val xs = List(1, 2, 3, 4)

xs.map(square)
xs.map(new Function1[Int, Int] {
  override def apply(v1: Int): Int = square(v1)
})
xs.map((v1: Int) => square(v1))

xs.reduce(add)
xs.reduce(new Function2[Int, Int, Int] {
  override def apply(v1: Int, v2: Int): Int = add(v1, v2)
})
xs.reduce((v1: Int, v2: Int) => add(v1, v2))

List(1, 2, 3, 4).map(x => x * x)