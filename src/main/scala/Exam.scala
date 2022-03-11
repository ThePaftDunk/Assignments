package com.test.FirstScala

object Exam extends App {
  io.Source.fromFile("src/main/conf/exam_data.csv").
    getLines().map(_.split(",").map(_.trim.toInt)).map(v => (v(0) * v(1), v(2))).map(t => {if (t._1 < t._2) "YES" else "NO"}).foreach(println(_))
}
