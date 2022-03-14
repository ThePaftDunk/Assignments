package com.test.FirstScala

import scala.io.Source

object Thief extends App {
    val source = Source.fromFile("src/main/conf/thief_data.txt")
    source.getLines().foreach { line =>
    var someList = line.toList
    val remoteUsed = someList.length - someList.sliding(2).filter(x => x(0) == x(1)).toList.length
    println("Number of times Remote has been used : " + remoteUsed)
  }
}

