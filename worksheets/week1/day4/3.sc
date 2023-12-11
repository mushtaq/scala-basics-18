class Person(val name: String, val age: Int)

object Blah {
  def apply(name: String, age: Int) = new Person(name, age)
  def unapply(person: Person): Option[(String, Int)] = Option((person.name, person.age))
}

val p = new Person("ashish", 33)
val p = Blah.apply("ashish", 33)

val p = Blah("ashish", 33)
val Blah(name, age) = p
