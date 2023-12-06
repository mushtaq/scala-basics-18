
trait Color

object Color {
  case object Red extends Color
  case object Green extends Color
  case object Blue extends Color
}


def m(color: Color) = ()

m(Color.Red)
m(Color.Green)


class A extends Object {
  def m = 10
}

val a1 = new A()
val A = new A()
object a2 extends A

a1.m
a2.m

object B extends Object


new A()
new A()
new A()
new A()

B
B
B
B
B
