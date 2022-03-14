package com.test.FirstScala

import scala.io.Source

object Farming extends App {
  val harvestLines = Source.fromFile("src/main/conf/harvest.csv").getLines().drop(1)
  val pricesLines = Source.fromFile("src/main/conf/prices.csv").getLines().drop(1)
  var codeMap = List[(String, (String, Float, String))]();
  var pricesMap = List[(String, (String, Float))]();

  harvestLines.foreach { line =>
    val cols = line.split(",").map(_.trim())
    codeMap ++= Map(cols(0) -> (cols(2), cols(3).toFloat, cols(1)))
  }
  pricesLines.foreach { line =>
    val cols = line.split(",").map(_.trim())
    pricesMap ++= Map(cols(0) -> (cols(1), cols(2).toFloat))
  }

  def mergeMap[A, B](ms: List[Map[A, B]])(f: (B, B) => B): Map[A, B] =
    (Map[A, B]() /: (for (m <- ms; kv <- m) yield kv)) { (a, kv) =>
      a + (if (a.contains(kv._1)) kv._1 -> f(a(kv._1), kv._2) else kv)
    }

  val dateGatherer = codeMap.groupBy(m => (m._1, m._2._3.dropRight(3))).map(p => (p._1._2, p._1._1) -> (p._2.map(_._2._2).sum))

  val perMonth = dateGatherer.toList.sortBy(_._1).map(v => v._1._1 -> (v._1._2, v._2)).groupBy(m => m._1).view.mapValues(v => v.maxBy(_._2._2)).toList.sortBy(_._1).map(m => m._1 -> m._2._2)
  //Highest gatherer per month
  println("Below is a list of best gatherer in terms of fruits gathered every month")
  println(perMonth)

  val fruitsByDay = codeMap.groupBy(m => (m._2._3, m._2._1)).map(p => (p._1) -> (p._2.map(_._2._2).sum).toDouble).toList.sortBy(_._1).toMap
  val priceByDay = pricesMap.groupBy(m => (m._2._1, m._1)).map(p => p._1 -> (p._2.map(_._2._2).sum).toDouble).toList.sortBy(_._1._1).toMap

  val some = fruitsByDay.map { case (k, v) => k -> (v, (priceByDay.getOrElse(k, 0.0))) }
  val perDayMap = some.toList.sortBy(_._1._1)
  val some2 = perDayMap.map(m => (m._1._1.dropRight(3), m._1._2) -> (m._2._1 * m._2._2))
  val allFruits = some2.groupBy(m => m._1).view.mapValues(v => v.maxBy(_._2)).toList.sortBy(_._1).map(m => m._1._1 -> (m._1._2, m._2._2))

  //Best earning fruit every month
  println("Below is a list of best earning fruit every month")
  println(allFruits.groupBy(_._1).map(m => m._1 -> (m._2.maxBy(_._2._2))).toList.sortBy(_._1))

  //Worst earning fruit every month
  println("Below is a list of worst earning fruit every month")
  println(allFruits.groupBy(_._1).map(m => m._1 -> (m._2.minBy(_._2._2))).toList.sortBy(_._1))

  val allFruitsOverall = perDayMap.map(m => (m._1._1.dropRight(6), m._1._2) -> (m._2._1 * m._2._2)).groupBy(m => m._1).view.mapValues(v => v.maxBy(_._2)).toList.sortBy(_._1).map(m => m._1._1 -> (m._1._2, m._2._2))
  //Best earning fruit overall
  println("Below is the best earning fruit Overall")
  println(allFruitsOverall.groupBy(_._1).map(m => m._1 -> (m._2.maxBy(_._2._2))).toList.sortBy(_._1))

  //Worst earning fruit overall
  println("Below is the worst earning fruit overall")
  println(allFruitsOverall.groupBy(_._1).map(m => m._1 -> (m._2.minBy(_._2._2))).toList.sortBy(_._1))

  //Which gatherer contributed most to your income (during the whole year and month)



  val gathererByDay = codeMap.groupBy(m => (m._2._3, m._2._1)).map(p => (p._1) -> (p._2.map(_._1), p._2.map(_._2._2))).toMap
  val someCase = gathererByDay.map { case (k, v) => k -> (v, (priceByDay.getOrElse(k, 0.0))) }
  val earningPerDay = someCase.map(m => m._1._1 -> (m._2._1._1 zip m._2._1._2.map(_ * m._2._2)).toMap)
  val some4 = earningPerDay.groupBy(_._1.dropRight(3)).map(m => m._1 -> m._2.values.toList)
  println(some4)

  val allEarnersPerMonth = some4.map(m => m._1 -> mergeMap(m._2)((v1, v2) => v1 + v2))
  //Below is the list of best earners per month
  println("Below is the list of best earners per month")
  println(allEarnersPerMonth.toList.sortBy(_._1).map(v => v._1 -> (v._2.maxBy(_._2))))
  val some5 = earningPerDay.groupBy(_._1.dropRight(6)).map(m => m._1 -> m._2.values.toList)
  val allEarnersOverall = some5.map(m => m._1 -> mergeMap(m._2)((v1, v2) => v1 + v2))

  // best earners overall
  println("best earners overall is :- ")
  println(allEarnersOverall.toList.sortBy(_._1).map(v => v._1 -> (v._2.maxBy(_._2))))

}
