import data.Data
import tc.api.Ord
import tc.consumers.Sorter
import tc.domain.Book

object A {
  implicit val intOrdAsc: Ord[Int] = new Ord[Int] {
    override def compare(a: Int, b: Int): Boolean = a > b
  }
}

Sorter.sort(List(5, 2, 9, 4, 3, 8, 6))
Sorter.sort(List("xyz", "aac" ,"abc"))
Sorter.sort(List(Some(9), None, Some(5)))
Sorter.sort(List(Some("xyz"), None, Some("abc")))

{
//  import A.intOrdAsc
  import Ord.intOrd
  Sorter.sort(List((10, "a"), (10, "z"), (1, "z")))
}

Sorter.sort(List(("a", 10), ("z", 10), ("z", 1)))
Sorter.sort(List((Some(10), "a"), (Some(10), "z"), (None, "z")))
Sorter.sort(Data.books)


