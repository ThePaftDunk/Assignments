package com.test.FirstScala
package com.Assignment

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object genType extends App {

  class ListSize {
    def listSize[A] (m: List[A]): Int = m match {
      case Nil => 0
      case _ :: tail => 1 + listSize(tail)
    }
  }

  implicit class CustomSorted[A](val s: ArrayBuffer[A])(implicit ord: Ordering[A]) {
    def customSort: ArrayBuffer[A] = {

      @tailrec
      def insideSort(arrBuf: ArrayBuffer[A],acc: ArrayBuffer[A], count: Int): ArrayBuffer[A] = {
        arrBuf match {
          case i if (s.length == count) => acc
          case i if (arrBuf.length == 1) => {
            acc.append(arrBuf.head)
          }
          case i if ord.gt(arrBuf.head , arrBuf.tail.min) => {
            val minPos = arrBuf.indexOf(arrBuf.tail.min)
            acc.append(arrBuf.tail.min)
            arrBuf.insert(minPos, arrBuf.head)
            arrBuf.remove(minPos + 1)
            insideSort(arrBuf.tail, acc, count + 1)
          }
          case _ => {
            acc.append(arrBuf.head)
            insideSort(arrBuf.tail, acc, count + 1)
          }
        }
      }
      insideSort(s,ArrayBuffer[A](), 0)
    }
  }

  implicit class BinarySearch[A](val values: List[A])(implicit ord: Ordering[A]) {
    def binarySearch(target: A): Int = {
      @tailrec
      def searchList(list: List[A], min: Int, max: Int): Int = {
        if(min >= max) return -1
        val mid = min + (max - min) / 2
        list(mid) match {
          case m if list(mid) == target => mid
          case m if ord.gt(list(mid), target) => searchList(list, min, mid)
          case _ => searchList(list, mid, max)
        }
      }
      searchList(values, 0, values.length - 1)
    }
  }

}
