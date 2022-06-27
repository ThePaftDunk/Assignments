package com.test.FirstScala

import org.scalatest.funsuite.AnyFunSuite
import com.Assignment._
import scala.collection.mutable.ArrayBuffer

class genTypeTest extends AnyFunSuite{

  val inputList = List((List(4,6,8,10),8, 2, 4), (List(10,20,30,40,50),40,3,5), (List(-12,-8,24,26,28),26,3,5),
    (List(15,25,26,27,28,29,35,45),35,6,8), (List(4,5,6,7,8,9),2,-1,6))

  val inputArrBuf = List(ArrayBuffer(-3,-4,4,6,8,9), ArrayBuffer(10,8,4,6,3,7,4), ArrayBuffer(3,4,6,7,8,10))

  test("genTypeTest.BinarySearch.binarySearch") {
    inputList.foreach( list =>
    assert(com.Assignment.genType.BinarySearch(list._1).binarySearch(list._2) === list._3))

    assert(com.Assignment.genType.BinarySearch(List("abc", "efg", "jkl", "mno")).binarySearch("efg") === 1)
  }

  test("genTypeTest.CustomSorted") {
    inputArrBuf.foreach(aBuf =>
      assert(aBuf.toList.sorted === com.Assignment.genType.CustomSorted(aBuf).customSort.toList)
    )
  }

  test(testName = "listSizeTest"){
    val listSizeTest = new ListSize
    inputList.foreach(
      list =>
        assert(listSizeTest.listSize(list._1) === list._4)
    )
  }

    test("compareTest"){
    val compareTestInts = new ComparatorClass[Int]
    assert(compareTestInts.compare(4,5) === -1)
    assert(compareTestInts.compare(10,8) === 1)


    val compareTestStrings = new ComparatorClass[String]
    assert(compareTestStrings.compare("abc", "xyz") === -1)
    assert(compareTestStrings.compare("xyz", "aaa") === 1)
  }

}
