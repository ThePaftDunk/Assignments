package com.test.FirstScala
package com.test.LeetCode

object SpecialArray extends App {

  def specialArray(arr: Array[Int]) = {

    val eq = arr.filter(m => m >= 1)
    println(eq.filter(m => m >= eq.length).toList)

  }

  specialArray(Array(3,5,0,0,0))

}
