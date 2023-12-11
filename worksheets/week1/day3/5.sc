
case class Person(name: String, age: Int)

//val p = Person("ashish", 33)
//val Person(name, age) = p


//val Person(nm, ag) = p

val Person(name, age) = Person("ashish", 33)

val t = (1, "abc", 9.8)
val (a, b, c) = t

val (a, b, c) = (1, "abc", 9.8)

val xs = 1 :: 2 :: Nil
val e1 :: e2 :: Nil = xs


val hello = s"Hello $name, your age is $age"
val s"Hello $name1, your age is $age1" = hello
