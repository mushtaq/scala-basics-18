
{
  sealed trait Json
  case object JsNull extends Json
  case class JsBoolean(value: Boolean) extends Json
  case class JsNumber(value: Double) extends Json
  case class JsString(value: String) extends Json
  case class JsArray(values: List[Json]) extends Json
  case class JsObject(values: Map[String, Json]) extends Json
}

{
  sealed trait Json
  case object JsNull extends Json
  sealed abstract class JsBoolean(value: Boolean) extends Json
  case object JsTrue extends JsBoolean(true)
  case object JsFalse extends JsBoolean(false)
  case class JsNumber(value: Double) extends Json
  case class JsString(value: String) extends Json
  case class JsArray(values: List[Json]) extends Json
  case class JsObject(values: Map[String, Json]) extends Json
}
