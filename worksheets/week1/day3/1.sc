import data.AliceData

val stopWords: Set[String] = AliceData
  .stopWordText
  .split(AliceData.stopWordRegex)
  .toSet

val words: List[String] = AliceData
  .bookText
  .split(AliceData.bookRegex)
  .toList

words
//  .filter(word => !stopWords.contains(word))
//  .filterNot(word => stopWords.contains(word))
//  .filterNot(word => stopWords.apply(word))
//  .filterNot(word => stopWords(word))
//  .filterNot(stopWords.contains)
  .filterNot(stopWords)

//"abc": String
//"abc": AnyRef
//"abc": Any
//"abc": Int

stopWords: Set[String]
stopWords: (String => Boolean)
//stopWords: String => Int

words: List[String]
//words: List[Int]
words: (Int => String)
words.apply(0)
words(0)

Map(1 -> "a", 2 -> "c"): Map[Int, String]
Map(1 -> "a", 2 -> "c"): (Int => String)