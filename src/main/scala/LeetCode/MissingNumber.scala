//268. Missing Number

//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

package com.test.FirstScala
package com.test.LeetCode


object MissingNumber extends App {

  def missingNumber(arr: Array[Int]) = {
  println(arr.sorted.zipWithIndex.filter(m => m._1 != m._2).toList(0)._2)
  }
  missingNumber(Array(3,4,6,5,1,8,9,0,2))
}
