//821. Shortest Distance to a Character
package com.test.FirstScala
package com.test.LeetCode

object ShortestDistance extends App {

  def shortestToChar(S: String = "loveleetcode", C: Char= 'e'): List[Int] = {
    val locations_of_C = (0 until S.length).filter(i => S(i) == C)

    val result = (0 until S.length).map(i => (locations_of_C.map(_ - i).map(_.abs) ++ locations_of_C.map(i - _).map(_.abs)).min)

    result.toArray.toList
  }

  println(shortestToChar())

}
