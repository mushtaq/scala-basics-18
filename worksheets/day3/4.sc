
//val xs = List(1, 2, 3, 4)
//
//xs.head
//xs.tail
//xs.tail.tail
//xs.tail.tail.tail
//xs.tail.tail.tail.tail


sealed trait List[+T]
object List {
  case class Cons[T](head: T, tail: List[T]) extends List[T]
  case object Nil extends List[Nothing]

  def length[T](xs: List[T]): Int = ???
}

import List._

Cons(1, Nil)
Cons(1, Cons(2, Nil))
Cons(1, Cons(2, Cons(3, Nil)))

length(Cons(1, Nil))
length(Cons(1, Cons(2, Cons(3, Nil))))