package com.test.FirstScala
package com.Assignment

class ComparatorClass extends Comparator[Int]{

  def compare(o1: Int, o2: Int): Int = {
    (o1, o2) match {
      case i if o1 < o2 => -1
      case i if o1 > o2 => 1
      case _ if o1 == o2 => 0
    }
  }
}
