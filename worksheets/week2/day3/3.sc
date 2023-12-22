
val maybeInt: Option[Int] = Some(10)
val maybeInt2: Option[Int] = None

maybeInt.getOrElse(throw new RuntimeException())
maybeInt2.getOrElse(99999)

val _val = {
  println("*****  _val")
  10
}

lazy val _lazy_val = {
  println("*****  _lazy_val")
  20
}

def _def = {
  println("*****  _def")
  30
}
//////////////////////////

def square(x: Int) = {
  x * x
}

def square2(x: () => Int) = {
  x() * x()
}

def square3(x: => Int) = {
  x * x
}

def square4(x: => Int) = {
  lazy val y = x
  y * y
}

//square(_val)
//square(_val)
//
//square(_lazy_val)
//square(_lazy_val)

square(_def)

square2(() => _def)

square3(_def)

square4(_def)
