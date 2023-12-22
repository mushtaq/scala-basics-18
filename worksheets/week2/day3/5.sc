abstract class Animal(legs: Int)
class Tiger(legs: Int) extends Animal(4)
class Human(legs: Int) extends Animal(2)

val tiger = new Tiger(4)
tiger: Tiger
tiger: Animal

val human = new Human(2)
human: Human
human: Animal

val tigers = List(tiger)
tigers: List[Tiger]
val animals: List[Animal] = tigers
//tigers(0) = tiger
//animals(0) = human

val tigers = Array(tiger)
tigers: Array[Tiger]
//val animals: Array[Animal] = tigers

tigers(0) = tiger
//animals(0) = human


1 + 1