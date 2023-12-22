
Nil: List[Nothing]
Nil: List[Int]
Nil: List[String]

None: Option[Nothing]
None: Option[Int]
None: Option[String]

def x(): Unit = while (true) {
  ()
}

(): Unit

{

  10
}: Unit

10: Int
10: AnyVal
10: Any

"abc": String
"abc": AnyRef
"abc": Any

10: Unit


def x(): Int = if(true) 10 else 20

def x(): AnyVal = if(true) 10 else ()
def x(): AnyRef = if(true) "abc" else List(1)
def x(): Any = if(true) 10 else "abc"


"abc": String
"abc": AnyRef


def x(): String = if(true) null else "abc"
def x(): Any  = if(true) null else 10

null

def x(): String = if(true) "abc" else throw new RuntimeException()
def x(): Int = if(true) 10 else throw new RuntimeException()

def x(): Nothing = throw new RuntimeException()


