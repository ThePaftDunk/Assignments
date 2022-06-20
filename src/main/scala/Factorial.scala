package com.test.FirstScala

object Factorial extends App {

  def aFunction( b: Int, m: Int = 1): Int = {
    if (b<= 0) m else aFunction(b - 1 , b * m)
  }
  println(aFunction(5))
}
