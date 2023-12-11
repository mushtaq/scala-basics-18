sealed trait Day
object Day {
  case object Weekday extends Day
  case object Weekend extends Day
}

sealed trait Customer
object Customer {
  case object Rewards extends Customer
  case object Regular extends Customer
}

case class BookingItem(customer: Customer, day: Day)

case class Hotel(name: String, rating: Int, rateCard: Map[BookingItem, Int]) {
  def totalCost(bookingItems: List[BookingItem]): Int =
    bookingItems.map(bookingItem => rateCard(bookingItem)).sum
}

class BookingService(hotels: List[Hotel]) {
  def find(customer: Customer, days: List[Day]): Hotel = {
    val bookingItems = days.map(day => BookingItem(customer, day))
    hotels.minBy(h => (h.totalCost(bookingItems), -h.rating))
  }
}

object Data {
  val hotels: List[Hotel] = List(
    Hotel("Lakewood", 3, Map(
      BookingItem(Customer.Regular, Day.Weekday) -> 110,
      BookingItem(Customer.Rewards, Day.Weekday) -> 80,
      BookingItem(Customer.Regular, Day.Weekend) -> 90,
      BookingItem(Customer.Rewards, Day.Weekend) -> 80
    )),
    Hotel("Bridgewood", 4, Map(
      BookingItem(Customer.Regular, Day.Weekday) -> 160,
      BookingItem(Customer.Rewards, Day.Weekday) -> 110,
      BookingItem(Customer.Regular, Day.Weekend) -> 60,
      BookingItem(Customer.Rewards, Day.Weekend) -> 50
    )),
    Hotel("Ridgewood", 5, Map(
      BookingItem(Customer.Regular, Day.Weekday) -> 220,
      BookingItem(Customer.Rewards, Day.Weekday) -> 100,
      BookingItem(Customer.Regular, Day.Weekend) -> 150,
      BookingItem(Customer.Rewards, Day.Weekend) -> 40
    )),
  )
}

val service = new BookingService(Data.hotels)
service.find(Customer.Regular, List(Day.Weekday, Day.Weekday, Day.Weekday))
service.find(Customer.Regular, List(Day.Weekday, Day.Weekend, Day.Weekend))
service.find(Customer.Rewards, List(Day.Weekday, Day.Weekday, Day.Weekend))