package com.test.FirstScala
package com.test.LeetCode

object BuySellStock extends App {

  def maxProfit(prices: Array[Int]): Int = {

    if (prices.length == 0){
      return 0
    }

    var current_min = prices(0)
    var profit = 0

    for (i <- 1 until prices.length){
      if (prices(i) < current_min){
        current_min = prices(i)
      } else {
        if(prices(i) - current_min > profit){
          profit = prices(i) - current_min
        }
      }
    }

    profit
  }

  println(maxProfit(Array(3,6,8,9,5)))

}
