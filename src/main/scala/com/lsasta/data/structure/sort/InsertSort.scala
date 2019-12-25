package com.lsasta.data.structure.sort

/**
 * 插入排序
 */
object InsertSort {

  def main(args: Array[String]): Unit = {

    val array = Array[Int](3,2,6,92,1,5,4)

    println("源数组2:" + array.mkString(","))
    insertSortBubble(arr = array)
    println("排序后数组2：" + array.mkString(","))

  }

  /**
   * 因为插入的位置后面所有的元素都要往后移位，所以通过将当前位的跟前面一位比他大的进行逆向冒泡。
   * @param arr
   */
  def insertSortBubble(arr:Array[Int]) = {
    var tempVal = 0
    for(i <- 1 until arr.length) {
      var tempIndex = i
      for(j <- i-1 to(0, -1)) {
        if(arr(tempIndex) < arr(j)){
          tempVal = arr(tempIndex)
          arr(tempIndex) = arr(j)
          arr(j) = tempVal
          tempIndex -= 1
        }
      }
    }
  }

}
