package com.lsasta.data.structure.sort

/**
 * 选择排序：跑完一轮才交换一次，更节省时间。
 */
object SelecSort {

  def main(args: Array[String]): Unit = {

    val array = Array[Int](3,2,7,9,1,5,4)

    println("源数组1:" + array.mkString(","))
    selectSort(array)
    println("排序后数组1：" + array.mkString(","))
  }

  def selectSort(array: Array[Int]) = {
    var tempIndex = 0
    var tempVal = 0
    for(i <- 0 until array.length - 1){
      tempIndex = i
      for (j <- i until array.length){
        if(array(tempIndex) > array(j)){
          tempIndex = j
        }
      }
      if(tempIndex != i){
        tempVal = array(i)
        array(i) = array(tempIndex)
        array(tempIndex) = tempVal
      }
    }

  }
}
