package com.test.FirstScala

import java.util.Date
import scala.io.Source
import scala.math.Ordering.Implicits.seqOrdering

object Farming extends App {
  val harvestLines = Source.fromFile("src/main/conf/harvest.csv").getLines().drop(1)
  val pricesLines = Source.fromFile("src/main/conf/prices.csv").getLines().drop(1)
  var codeMap=List[(String, (String, Float, String))]();
  var pricesMap=List[(String, (String, Float))]();
  harvestLines.foreach
    {
      line =>
      val cols=line.split(",").map(_.trim())
      codeMap ++= Map(cols(0) -> (cols(2), cols(3).toFloat, cols(1)))
    }
  pricesLines.foreach
  {
    line =>
      val cols=line.split(",").map(_.trim())
      pricesMap ++= Map(cols(0) -> (cols(1), cols(2).toFloat))
  }
  val dateGatherer = codeMap.groupBy(m => (m._1, m._2._3.dropRight(3))).map(p => (p._1._2, p._1._1) -> (p._2.map(_._2._2).sum))
  val perMonth = dateGatherer.toList.sortBy(_._1).map( v => v._1._1 -> (v._1._2, v._2)).groupBy(m => m._1).view.mapValues(v => v.maxBy(_._2._2)).toList.sortBy(_._1).map(m => m._1 -> m._2._2)
  //Highest gatherer per month
  //println(perMonth)
  //val specificFruit = codeMap.groupBy(m => (m._1, m._2._3.dropRight(3))).map(p => (p._1._2, p._1._1) -> (p._2.map(_._2._1),p._2.map(_._2._2)))
  //println(specificFruit.toList.sortBy(_._1))
  val fruitsByDay = codeMap.groupBy(m => (m._2._3, m._2._1)).map(p => (p._1) -> (p._2.map(_._2._2).sum).toDouble).toList.sortBy(_._1).toMap
  //println(fruitsByDay)
  val priceByDay = pricesMap.groupBy(m => (m._2._1, m._1)).map(p => p._1 -> (p._2.map(_._2._2).sum).toDouble).toList.sortBy(_._1._1).toMap
  //println(priceByDay)
  val some =  fruitsByDay.map { case (k, v) => k -> (v , (priceByDay.getOrElse(k, 1.0))) }
    //.map(m => m._1._1.dropRight(3) -> (m._1._2 ,(m._2._1 * m._2._2)))
  val perDayMap = some.toList.sortBy(_._1._1
  val some2 = perDayMap.map(m=> (m._1._1.dropRight(3), m._1._2) -> (m._2._1 * m._2._2))
 // println(some2)
  val allFruits = some2.groupBy(m => m._1).view.mapValues(v => v.maxBy(_._2)).toList.sortBy(_._1).map(m => m._1 -> m._2._2)
  println(allFruits.toList.groupBy(v => v._1._1 -> v._2))
  println(allFruits.maxBy(_._2))
  //val some = fruitsByDay.groupBy(m => (m._1,m._2.map(_._2._1))).map(p => (p._1, p._2 ))

  val bestGatherer = codeMap.groupBy(m => (m._1)).map(p => p._1 -> p._2.map(_._2._2).sum).maxBy(_._2)
  //val bestGatherer = codeMap.groupBy(_._1).map(p => p._1 -> p._2.map(_._2).sum).toMap.maxBy(_._2)
  //println(bestGatherer)

  //val gathererTotalFruitsMap = codeMap.groupBy(_._1).map(p => p._1 -> (p._2.map(_._2._2).sum))
  //val specFruitGatherer = codeMap.groupBy(_._2._1).map(p => p._1 -> p._2.map(_._2._2).sum)
}
