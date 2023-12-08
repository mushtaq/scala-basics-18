
//val xs = List(1, 2, 3, 4)
//
//xs.head
//xs.tail
//xs.tail.tail
//xs.tail.tail.tail
//xs.tail.tail.tail.tail


sealed trait List[+T]
case class Cons[T](head: T, tail: List[T]) extends List[T]
case object Nil extends List[Nothing]

def length[T](xs: List[T]): Int = {
  if(xs == Nil) {
    0
  } else {
    1 + length(xs.asInstanceOf[Cons[T]].tail)
  }
}

def reverse[T](xs: List[T]): List[T] = {
  def loop(rem: List[T], stack: List[T]): List[T] = {
    if (rem == Nil) {
      stack
    } else {
      val cons = rem.asInstanceOf[Cons[T]]
      loop(cons.tail, Cons(cons.head, stack))
    }
  }
  loop(xs, Nil)
}


Cons(1, Nil)
Cons(1, Cons(2, Nil))
Cons(1, Cons(2, Cons(3, Nil)))

length(Cons(1, Nil))
length(Cons(1, Cons(2, Cons(3, Nil))))

reverse(Cons(1, Nil))
reverse(Cons(1, Cons(2, Cons(3, Nil))))