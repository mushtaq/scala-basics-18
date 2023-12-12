object :: {
  def unapply(string: String): Option[(String, String)] = string.split(":") match {
    case Array(prefix, suffix) => Option((prefix, suffix))
    case _                     => None
  }
}

"urn:abc" match {
  case prefix :: suffix => println(s"Hello prefix=$prefix and suffix=$suffix")
  case _                => println("pattern failed")
}
