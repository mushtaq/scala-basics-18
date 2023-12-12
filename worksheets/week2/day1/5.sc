import data.Data
import tc.app.Book

val square: Int => Int = x => x * x

square(10)

val divide100: Int => Int =
  x => 100 / x

divide100(5)
divide100(25)
//divide100(0)

val divide100: PartialFunction[Int, Int] = {
  case x if x != 0 => 100 / x
}

divide100.isDefinedAt(10)
divide100.isDefinedAt(20)
divide100.isDefinedAt(5)
divide100.isDefinedAt(0)

divide100(5)
divide100.apply(5)
//divide100(0)

Data.books
  .filter(_.author == "odersky")
  .map(_.title)

Data.books
  .collect {
    case b if b.author == "odersky" => b.title
  }

val pf: PartialFunction[Book, String] = {
  case b if b.author == "odersky" => b.title
}

Data.books
  .filter(pf.isDefinedAt)
  .map(pf)
