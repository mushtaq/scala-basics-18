// Algebraic Data Types or ADTs
sealed trait List[+T]
case class Cons[T](head: T, tail: List[T]) extends List[T]
case object Nil                            extends List[Nothing]

Cons(1, Nil)
Cons(1, Cons(2, Nil))
Cons(1, Cons(2, Cons(3, Nil)))

def length[T](xs: List[T]): Int = {
  if (xs == Nil) {
    0
  }
  else {
    1 + length(xs.asInstanceOf[Cons[T]].tail)
  }
}

def length[T](xs: List[T]): Int = xs match {
  case Nil           => 0
  case Cons(_, tail) => 1 + length(tail)
}

def length[T](xs: List[T]): Int = xs match {
  case Nil           => 0
  case Cons(0, tail) => 1 + length(tail)
  case Cons(1, tail) => 1 + length(tail)
}

//length(Cons(1, Nil))
//length(Cons(1, Cons(2, Cons(3, Nil))))
