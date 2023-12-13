package tc.consumers

import tc.api.Ord

object Sorter {
  private def insert[T](x: T, xs: List[T])(implicit ord: Ord[T]): List[T] = xs match {
    case Nil          => List(x)
    case head :: tail => if (ord.compare(x, head)) x :: xs else head :: insert(x, tail)
  }

  def sort[T](xs: List[T])(implicit ord: Ord[T]): List[T] = xs match {
    case Nil          => Nil
    case head :: tail => insert(head, sort(tail))
  }
}
