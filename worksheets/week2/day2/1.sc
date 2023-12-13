import data.Data

def insert[T <: Comparable[T]](x: T, xs: List[T]): List[T] = xs match {
  case Nil          => List(x)
  case head :: tail => if (x.compareTo(head) < 0) x :: xs else head :: insert(x, tail)
}

//insert(9, List(1, 4, 6, 12, 14))

def sort[T <: Comparable[T]](xs: List[T]): List[T] = xs match {
  case Nil          => Nil
  case head :: tail => insert(head, sort(tail))
}

sort(List[Integer](5, 2, 9, 4, 3, 8, 6))
//sort(List(5, 2, 9, 4, 3, 8, 6))
sort(Data.books)