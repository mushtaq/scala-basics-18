import data.Data
import play.api.libs.json.{JsArray, JsBoolean, JsFalse, JsNull, JsNumber, JsObject, JsString, JsTrue, JsValue, Json}

object :: {
  def unapply(string: String): Option[(String, String)] = string.split(":") match {
    case Array(prefix, suffix) => Option((prefix, suffix))
    case _                     => None
  }
}

def transform(json: JsValue): JsValue = json match {
  case JsNull                  => JsString("I am null")
  case JsFalse                 => JsTrue
  case JsTrue                  => JsFalse
  case JsString("urn" :: post) => JsString(post)
//  case JsString(s"urn:$post")  => JsString(post)
  case JsString(value) => json
  case JsNumber(value) => JsNumber(value * value)
  case JsArray(values) => JsArray(values.map(transform))
  case JsObject(values) =>
    JsObject(
      values.map {
        case (k@("m" | "n"), v) => (k, v)
        case (k, v) => (k, transform(v))
      }
    )
}

Json.prettyPrint(transform(Data.json))
