import data.Data
import play.api.libs.json.{JsArray, JsBoolean, JsFalse, JsNull, JsNumber, JsObject, JsString, JsTrue, JsValue, Json}

def transform(json: JsValue): JsValue = json match {
  case JsNull                                      => JsString("I am null")
  case JsFalse                                     => JsTrue
  case JsTrue                                      => JsFalse
  case JsString(value) if value.startsWith("urn:") => JsString(value.stripPrefix("urn:"))
  case JsString(value)                             => json
  case JsNumber(value)                             => JsNumber(value * value)
  case JsArray(values)                             => JsArray(values.map(transform))
  case JsObject(values)                            => JsObject(values.view.mapValues(transform).toMap)
}

Json.prettyPrint(transform(Data.json))
