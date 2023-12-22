import data.Data
import tc.domain.Book

val book = Data.books.head

book.basePrice

def sellingPrice(book: Book) = book.basePrice * 1.1

sellingPrice(book)

{
  import example.BookExtensions.RichBook
  book.sellingPrice
  book.sellingPrice
  book.sellingPrice
  sellingPrice(book)
}

{
  import example.BookExtensions.RichBook2
  book.sellingPrice
}
