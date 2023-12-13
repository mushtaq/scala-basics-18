import data.Data

import java.util.Comparator

def insert[T](x: T, xs: List[T])(comp: Comparator[T]): List[T] = xs match {
  case Nil          => List(x)
  case head :: tail => if (comp.compare(x, head) < 0) x :: xs else head :: insert(x, tail)(comp)
}

//insert(9, List(1, 4, 6, 12, 14))

def sort[T](xs: List[T])(comp: Comparator[T]): List[T] = xs match {
  case Nil          => Nil
  case head :: tail => insert(head, sort(tail)(comp))(comp)
}

sort(List(5, 2, 9, 4, 3, 8, 6))(???)
sort(Data.books)(???)
