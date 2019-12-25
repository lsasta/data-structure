package com.lsasta.data.structure.sort

import scala.util.Random

object AllSortTest {

  def main(args: Array[String]): Unit = {

    val nums = 80000
    val arr:Array[Int] = Array.ofDim(nums)
    for(i <- 0 until nums){
      arr(i) = Random.nextInt(nums)
    }

    var start = System.currentTimeMillis()
    BubbleSort.bubbleSort(arr.clone())
    var end = System.currentTimeMillis()
    println("bubbleSort time is :" + (end - start))

    start = System.currentTimeMillis()
    SelecSort.selectSort(arr.clone())
    end = System.currentTimeMillis()
    println("SelecSort time is :" + (end - start))

    start = System.currentTimeMillis()
    InsertSort.insertSortBubble(arr.clone())
    end = System.currentTimeMillis()
    println("insertSortBubble time is :" + (end - start))
  }

}
