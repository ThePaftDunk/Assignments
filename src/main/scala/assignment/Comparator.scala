package com.test.FirstScala
package com.Assignment

trait Comparator[A] {
  def compare (o1:A, o2: A): Int
}