package com.lsasta.data.structure.recursion

object MazeDemo {

  /**
   * 0: 没走过的点
   * 1：不能走的点
   * 2：能走过的点
   * 3：走不通的点
   * @param args
   */
  def main(args: Array[String]): Unit = {

    val row = 8
    val col = 7

    val matrix = Array.ofDim[Int](row,col)

    for(i <- 0 until row){
      matrix(i)(0) = 1
      matrix(i)(6) = 1
    }

    for(i <- 0 until col) {
      matrix(0)(i) = 1
      matrix(7)(i) = 1
    }
    matrix(3)(1) = 1
    matrix(3)(2) = 1

    step(matrix, 1, 1)

    printMatix(matrix)

  }

  def step(matrix: Array[Array[Int]], i: Int, j: Int): Boolean = {
    if(matrix(6)(5) != 2){
      if(matrix(i)(j) == 0){
        matrix(i)(j) = 2
        if(step(matrix, i + 1, j)){
          true
        }else if(step(matrix, i, j + 1)){
          true
        }else if(step(matrix, i - 1, j)){
          true
        }else if(step(matrix, i, j - 1)){
          true
        }else{
          matrix(i)(j) = 3
          false
        }
      } else {
        false
      }
    } else true
  }

  def printMatix(matrix: Array[Array[Int]]) = {

    matrix.foreach(arr => {
      arr.foreach(v => print(v + " "))
      println()
    })

  }

}
