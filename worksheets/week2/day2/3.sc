import data.Data
import tc.api.Ord
import tc.consumers.Sorter
import tc.domain.Book

Sorter.sort(List(5, 2, 9, 4, 3, 8, 6))(Ord.intOrd)
Sorter.sort(List("xyz", "aac" ,"abc"))(Ord.strOrd)
Sorter.sort(List(Some(9), None, Some(5)))(Ord.intOptOrd)
Sorter.sort(Data.books)(Book.bookOrd)
