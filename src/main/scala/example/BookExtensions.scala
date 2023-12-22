package example

import tc.domain.Book

object BookExtensions {
  implicit class RichBook(val book: Book) extends AnyVal {

    def sellingPrice: Double = book.basePrice * 1.1

//    println("*****************")
  }

  implicit class RichBook2(book: Book) {
    def sellingPrice: Double = book.basePrice * 1.1
  }
}
