import data.AliceData

val stopWords: Set[String] = AliceData
  .stopWordText
  .split(AliceData.stopWordRegex)
  .toSet

val words: List[String] = AliceData
  .bookText
  .split(AliceData.bookRegex)
  .toList

val t = (1, "abc", 98.4)
t._1
t._2
t._3

(1, "abc", 98.4, "asdasd")
(1, "abc")

words
  .filterNot(word => stopWords.contains(word))
  .groupBy(word => word)
//  .map(pair => (pair._1, pair._2.length))
  .view //ignore
  .mapValues(_.length)
//  .mapValues(new Function1[List[String], Int] {
//    override def apply(v1: List[String]): Int = v1.length
//  })
  .toMap //ignore
  .toList
  .sortBy(_._2)
  .reverse
  .take(10)
  .foreach(println)
