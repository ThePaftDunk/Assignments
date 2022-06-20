// 852. Peak Index in a Mountain Array

/*Let's call an array arr a mountain if the following properties hold:

  arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
  arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
  Given an integer array arr that is guaranteed to be a mountain,
  return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].*/

package com.test.FirstScala
package com.test.LeetCode

object ArrayIntersection extends App {

  def intersection(arr: Array[Int], arr2: Array[Int]): Unit ={
    println(arr.intersect(arr2).toList.distinct)
  }

  intersection(Array(4,6,7,3,8,7,7), Array(4,5,3,6,7,7,7))
}
