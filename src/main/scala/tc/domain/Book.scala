package tc.domain

import tc.api.Ord

case class Book(
    author: String,
    title: String,
    basePrice: Double
)

object Book {
  implicit val bookOrd: Ord[Book] = new Ord[Book] {
    override def compare(a: Book, b: Book): Boolean = a.basePrice <= b.basePrice
  }
}
