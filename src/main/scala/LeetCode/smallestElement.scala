// 744. Find Smallest Letter Greater Than Target

package com.test.FirstScala
package com.test.LeetCode

object smallestElement extends App{
  def nextGreatestLetter(letters: Array[Char], target: Char): Char = {
    if (letters.exists(_ > target)) {
      letters.filter(_ > target).min
    } else {
      (letters.map(_.toInt).map(_.toInt + 26).filter(_ > target.toInt).min - 26).toChar
    }
  }

  println(nextGreatestLetter(Array('c','e','f'), 'c'))

}
