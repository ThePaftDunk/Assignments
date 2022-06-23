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

  implicit class CustomSorted(val s: ArrayBuffer[Int]) {
    def customSort: ArrayBuffer[Int] = {

      @tailrec
      def insideSort(arrBuf: ArrayBuffer[Int],acc: ArrayBuffer[Int], count: Int): ArrayBuffer[Int] = {
        arrBuf match {
          case i if (s.length == count) => acc
          case i if (arrBuf.length == 1) => {
            acc.append(arrBuf.head)
          }
          case i if (arrBuf.head > arrBuf.tail.min) => {
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
      insideSort(s,ArrayBuffer[Int](), 0)
    }
  }

  implicit class BinarySearch(val values: List[Int]) {
    def binarySearch(target: Int): Int = {
      @tailrec
      def searchList(list: List[Int], target: Int, min: Int, max: Int): Int = {
        if(min >= max) return -1
        val mid = min + (max - min) / 2
        list(mid) match {
          case m if(m == target) => mid
          case m if(m > target) => searchList(list, target, min, mid)
          case _ => searchList(list, target, mid, max)
        }
      }
      searchList(values, target, 0, values.length - 1)
    }
  }

}
