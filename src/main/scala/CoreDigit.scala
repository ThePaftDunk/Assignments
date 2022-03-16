package com.test.FirstScala

object CoreDigit extends App {

  val lines = io.Source.fromFile("src/main/conf/CoreDigit.txt").getLines().toList(0).split(" ")
  val digits = lines(0).toList.map(_.toString.toInt).sum
  val total = ((digits.toLong * lines(1).toLong).toLong)
  val rec (num:Long): Long = if (num == 0) 0 else if (num < 10) num else (num % 9)
  println(rec(total)) // Output is 3
}
