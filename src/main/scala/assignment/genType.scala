package com.test.assignment

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object genType extends App {

  class genType {
    def listSize[A] (m: List[A]): Int = m match {
      case Nil => 0
      case _ :: tail => 1 + listSize(tail)
    }
  }

  val l = List(5,7,4,6)
  val g = new genType
  println(g.listSize(l))

  trait Comparator[A] {
    def compare (o1:A, o2: A): Int
  }


  implicit class CustomSorted(val s: ArrayBuffer[Int]) {
    def customSort: ArrayBuffer[Int] = {

      @tailrec
      def insideSort(b: ArrayBuffer[Int],acc: ArrayBuffer[Int], count: Int): ArrayBuffer[Int] = {
        b match {
          case i if (s.length == count) => acc
          case i if (b.length == 1) => {
            acc.append(b.head)
          }
          case i if (b.head > b.tail.min) => {
            val minPos = b.indexOf(b.tail.min)
            acc.append(b.tail.min)
            b.insert(minPos, b.head)
            b.remove(minPos + 1)
            insideSort(b.tail, acc, count + 1)
          }
          case _ => {
            acc.append(b.head)
            insideSort(b.tail, acc, count + 1)
          }
        }
      }
      insideSort(s,ArrayBuffer[Int](), 0)
    }
  }

  println(ArrayBuffer(5,6,4,9,4,8,8,9,9).customSort)

  implicit class BinarySearch(val l: List[Int]) {
    def binarySearch(target: Int): Int = {
      @tailrec
      def searchList(list: List[Int], t: Int, min: Int, max: Int): Int = {
        if(min > max) return -1
        val mid = min + (max - min) / 2
        list(mid) match {
          case m if(m == target) => mid
          case m if(m > target) => searchList(list, t, min, mid + 1)
          case _ => searchList(list, t, mid + 1, max)
        }
      }
      searchList(l, 20, 0, l.length - 1)
    }
  }

  println(List(10,20,30,40,50).binarySearch(50))

  class ComparatorClass extends Comparator[Int]{

    override def compare(o1: Int, o2: Int): Int = {
      c match {
        case i if o1 < o2 => -1
        case i if o1 > o2 => 1
        case _ if o1 == o2 => 0
      }
    }
  }

  val c = new ComparatorClass
  println(c.compare(5,6))

}
