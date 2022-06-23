package com.test.FirstScala
package com.Assignment

class ListSize {
  def listSize[A] (m: List[A]): Int = m match {
    case Nil => 0
    case _ :: tail => 1 + listSize(tail)
  }
}
