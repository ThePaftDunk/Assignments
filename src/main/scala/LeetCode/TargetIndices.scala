//2089. Find Target Indices After Sorting Array
/**
 * You are given a 0-indexed integer array nums and a target element target.

A target index is an index i such that nums[i] == target.

Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.

 */

package com.test.FirstScala
package com.test.LeetCode

import scala.annotation.tailrec

object TargetIndices extends App {

 // def parentFindTarget(arr: Array[Int], target: Int): Int = {
   // @tailrec
   /* def findTarget(arr: Array[Int], target: Int, start: Int, end: Int): Int = {

      if (start > end) return -1
      val mid = start + (end - start) / 2
      arr(mid) match {
        case i if (i == target) => mid
        case i if (i > target ) => findTarget(arr, target, start, mid - 1)
        case _  => findTarget(arr, target, mid + 1, end)
      }
    }
      findTarget(arr, target, 0, arr.length - 1) // 3

  }*/

 // println(parentFindTarget(Array(4,7,9,9,10,15,20), 9))

}
