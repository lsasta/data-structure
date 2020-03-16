package com.lsasta.data.structure.sort

object ShellSort {

  def main(args: Array[String]): Unit = {

    var array = Array(8,9,1,7,2,3,5,4,6,0)

//    shellSort(array)
    shellSort2(array)
    println(array.mkString(","))
  }


  /**
   * 交换法
   * @param array
   */
  def shellSort(array: Array[Int]) = {

    var gap = array.length / 2

    while(gap >=1){
      // 这儿是从高位向低位进行遍历
      for(i <- gap until array.length){
        for(j <- i - gap to(0, -gap)){
          if(array(j) > array(j + gap)){
            var tmp = array(j)
            array(j) = array(j + gap)
            array(j + gap) = tmp
          }
        }
      }
      gap = gap / 2
    }

  }

  /**
   * 移位法
   * @param array
   */
  //这种方式理论上并不能提高多少的速度。移位法并不会减少多少步骤
  def shellSort2(array: Array[Int]): Unit ={

    var gap = array.length / 2

    while (gap >= 1){
      for(i <- gap until array.length){
        var j = i;
        var temp = array(j)
        if(array(j) < array(j - gap)){
          while(j - gap >= 0 && temp < array(j-gap)){
            array(j) = array(j-gap)
            j -= gap
          }
          array(j) = temp
        }
      }

      gap /= 2
    }

  }
}
