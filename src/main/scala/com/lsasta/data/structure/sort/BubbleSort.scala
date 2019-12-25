package com.lsasta.data.structure.sort

import scala.util.control.Breaks

/**
 * 冒泡排序: 每次大小有差异就会导致数据的交换操作，比较耗时，而选择排序是走完一轮在交换一次，更节省时间。
 */
object BubbleSort {

  def main(args: Array[String]): Unit = {

    val array = Array[Int](3,2,6,9,1,5,4)
    println("源数组:" + array.mkString(","))
    bubbleSort(arr = array)
    println("排序后数组：" + array.mkString(","))
  }


  def bubbleSort(arr: Array[Int]) = {
    var temp:Int = 0
    var flag = false
    for(i <- arr.length - 1 to(0, -1) if !flag){
      flag = true
      for(j <- 0 until i ){
        if(arr(j) > arr(j + 1)){
          flag = false
          temp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = temp
        }
      }
    }
  }

}
