package com.test.FirstScala
package com.test.LeetCode

object TIFunction extends App {
    def targetIndices(num: Array[Int], target: Int) = {

        //filter((n,index) => n == target )

      println(num.sorted.zipWithIndex.filter(k => k._1 == target).map((v) => v._2 ).mkString(" , "))

      num.toList.sorted.zipWithIndex.foreach{
        case (n, index) if (target == n) => index
        case _ =>
      }
    }
  targetIndices(Array(5,7,9,2,9), 9)
  }
