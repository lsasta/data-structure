package com.lsasta.data.structure.sort

import scala.util.Random

object QuickSort {

  def main(args: Array[String]): Unit = {

    val array = Array(-9,78,0,23,-567,70, -20, 9, 31, -32, -56, 45)

//    val nums = 20
//    val arr:Array[Int] = Array.ofDim(nums)
//    for(i <- 0 until 20){
//      arr(i) = Random.nextInt(nums)
//    }
//    println(arr.mkString(","))
//
//    val array = arr.clone()
    com.lsasta.java.test.stack.QuickSort.quickSort(array,0 ,array.length - 1)
//    quickSort2(array, 0, array.length-1)
    println(array.mkString(","))

  }

  def quickSort(array: Array[Int], left: Int, right: Int): Unit ={

    var middle = left
    for(i <- left + 1 to(right, 1)){
      if(array(i) < array(middle)){
        val temp = array(i)
        for(j <- i until (middle, -1)){
          array(j) = array(j-1)
        }
        array(middle) = temp
        middle += 1
      }
    }
    if(middle > left){
      quickSort(array, left, middle - 1)
    }
    if(middle < right){
      quickSort(array, middle + 1, right)
    }

  }

  def quickSort2(array: Array[Int], left: Int, right: Int): Unit ={
    var l = left //左下标
    var r = right //右下标
    //pivot 中轴值
    val pivot = array((left + right) / 2)
    var temp = 0 //临时变量，作为交换时使用
    //while循环的目的是让比pivot 值小放到左边
    //比pivot 值大放到右边
    while ( {
      l < r
    }) { //在pivot的左边一直找,找到大于等于pivot值,才退出
      while ( {
        array(l) < pivot
      }) l += 1
      //在pivot的右边一直找,找到小于等于pivot值,才退出
      while ( {
        array(r) > pivot
      }) r -= 1
      //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
      //小于等于pivot值，右边全部是大于等于pivot值
      if (l >= r) return //todo: break is not supported
      //交换
      temp = array(l)
      array(l) = array(r)
      array(r) = temp
      //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
      //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
      if (array(r) == pivot) l += 1
    }

    // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
    if (l == r) {
      l += 1
      r -= 1
    }
    //向左递归
    if (left < r) quickSort(array, left, r)
    //向右递归
    if (right > l) quickSort(array, l, right)
  }

}
