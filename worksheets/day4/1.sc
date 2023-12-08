case class Person(name: String, age: Int)

val p = Person("ashish", 33)

def printDetails(person: Person) = person match {
  case Person(name, age) => println(s"Hello $name, your age is $age")
//  case name Person age => println(s"Hello $name, your age is $age")
}

printDetails(p)

val xs = 1 :: 2 :: Nil

xs match {
  case Nil             => println(1)
  case ::(e1, Nil)     => println(2)
  case ::(e1, ::(e2, Nil)) => println(3)
  case _               => println("unexpected")
}
