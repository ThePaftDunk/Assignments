package com.test.FirstScala

import scala.annotation.tailrec

object Recursions extends App{


  def aFunction( b: Int): BigInt = {
    if (b<= 0) 1 else b * aFunction(b - 1)
  }

  @tailrec
  def tRecursion(x: Int, a: BigInt): BigInt = 
    if (x <= 0) a
    else tRecursion(x - 1, x * a)
  println(tRecursion(5000,1))
  //println(aFunction(5000))

  def concatenateString(x: Int, s: String, a:String): String =
    if (x <= 0) a
    else concatenateString((x - 1), s, a + s)

  println(concatenateString(3, "shubham", ""))


  //Tail Recursion
  // when recursive call is evaluated, a method call is replaced with another method call without using extra stack memory
  // Key to tail recursion is to use recursive call as the LAST expression

  //when we need loops use tail recursion

}
