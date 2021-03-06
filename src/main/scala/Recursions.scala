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

  @tailrec
  def concatenateString(x: Int, s: String, a:String): String =
    if (x <= 0) a
    else concatenateString((x - 1), s, a + s)

  println(concatenateString(3, "shubham", ""))

  @tailrec
  def fibonacii(x: Int, acc: Int, acc2: Int): Int = {
    //println(x, x + (x - 1))
    if (x == 0) acc
    else fibonacii((x-1), acc + x, acc2 + (x-1))
  }

  var counter = 0
  def fibonaciiNormal(x: Int): Int = {
    //var x = x +
    counter += 1

    println(counter)
    if (x == 0) x
    else if (x == 1) x
    else fibonaciiNormal(x - 1) + fibonaciiNormal(x - 2)
  }

  println(fibonaciiNormal(10))
  //print(fibonacii(20, 0, 0))

  //Tail Recursion
  // when recursive call is evaluated, a method call is replaced with another method call without using extra stack memory
  // Key to tail recursion is to use recursive call as the LAST expression

  //when we need loops use tail recursion

  //assignments
  //
}
