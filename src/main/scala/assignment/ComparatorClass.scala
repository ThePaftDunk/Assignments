package com.test.FirstScala
package com.Assignment

class ComparatorClass[A] (implicit ord: Ordering[A]) extends Comparator[A]{

   def compare(o1: A, o2: A): Int = {
     (o1, o2) match {
      case i if ord.lt(o1 , o2) => -1
      case i if ord.gt(o1 , o2) => 1
      case _ if o1 == o2 => 0
    }
  }
}
