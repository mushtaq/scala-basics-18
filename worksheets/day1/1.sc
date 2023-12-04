
// JS: const
val x = 10

// int x1 = 10
val x1: Int = 10

def square(x: Int) = x * x
def square2(x: Int): Int = x * x

// JS: let
var y = "abc"
var y: String = "abc"

y
y = "xyz"
y
///////////////////

var xs = List(1, 2, 3, 4)
val xs2: List[Int] = List(1, 2, 3, 4)

// prefix operation, also called as cons or consing
val ys = 0 :: xs
xs

xs = 0 :: xs
xs
////////////////////////////

val as = collection.mutable.Buffer(1, 2, 3, 4)

as.append(5)
as