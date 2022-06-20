//804. Unique Morse Code Words


package com.test.FirstScala
package com.test.LeetCode

object morseCode extends App{

  def uniqueMorseRepresentations(strs: Array[String]): Int = {

    val mapMorse = ('a' to 'z').zip(List(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")).toMap

    val result = for (x <- strs.map(x=>x.map(mapMorse.get(_)))) yield {
      var temp = ""
      for (y <- x) {
        temp = temp.concat(y.toString)
      }
      temp
    }
    result.distinct.length
  }
  println(uniqueMorseRepresentations(Array("shubh", "abcd", "xyz")))

}
