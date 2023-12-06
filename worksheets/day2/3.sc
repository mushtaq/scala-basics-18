
class Person(val name: String, val age: Int)

val ashish = new Person("ashish", 33)
val ashish2 = new Person("ashish", 33)

ashish == ashish2
ashish eq ashish2

ashish.hashCode()
ashish2.hashCode()

ashish.name
ashish.age

new Person(ashish.name, ashish.age + 1)

val xs = List(1, 2, 3, 4)

val ys = 0 :: xs.tail
xs

