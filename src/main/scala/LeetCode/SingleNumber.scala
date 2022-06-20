//136. Single Number

package com.test.FirstScala
package com.test.LeetCode

object SingleNumber extends App{

  def singleNumber(nums: Array[Int]): Int = {

    nums.distinct.filter(x => nums.filter(_ == x).length != 2)(0)

  }

  println(singleNumber(Array(4,2,2)))

}
