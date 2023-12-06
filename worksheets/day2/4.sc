
case class Person(name: String, age: Int) {
  def hello() = s"hello $name of age=$age"
}

val ashish = Person("ashish", 33)
val ashish2 = Person("ashish", 33)

ashish == ashish2
ashish eq ashish2

ashish.hashCode()
ashish2.hashCode()

ashish.name
ashish.age

ashish.hello()

val person = new Person(ashish.name, ashish.age + 1)
person.hello()

ashish.copy(age = ashish.age + 1)

val xs = List(1, 2, 3, 4)

val ys = 0 :: xs.tail
xs

