package com.lsasta.data.structure.recursion

object Queue8Demo {

  var num: Int = 0
  var recu: Int = 0

  def main(args: Array[String]): Unit = {

    val arr = new Array[Int](8)

    check(arr, 0, 8)

    println("num succ: " + num)
    println("num recu: " + recu)
  }

  def check(arr: Array[Int], n: Int, max: Int): Unit = {
    if(n > 7){
      num += 1
      printArr(arr)
    } else {
      for(i <- 0 until max){
        if(judge(arr, n, i)){
          recu += 1
          arr(n) = i
          check(arr, n + 1, max)
        }
      }
    }
  }

  /**
   * 从斜率的角度来理解是否在一条斜线上
   * @param arr
   * @param i
   * @param j
   * @return
   */
  def judge(arr: Array[Int], i: Int, j: Int):Boolean = {
    var res: Boolean = true
    arr.zipWithIndex.foreach{ case (value, index) =>{
//      if (index < i) println(s"index: $index, i: $i, value: $value, j: $j")
      if(index < i && (value == j || Math.abs(i - index) == Math.abs(j - value))){
        res = false
      }
    }}
    res
  }

  def printArr(arr: Array[Int]) = {
    arr.foreach(print)
    println("")
  }

}
