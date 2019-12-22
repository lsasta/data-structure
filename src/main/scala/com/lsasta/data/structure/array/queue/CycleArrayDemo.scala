package com.lsasta.data.structure.array.queue

import scala.io.StdIn

/**
 * 对于环形数组所有的操作都基于 对maxsize取模来完成
 * 这个算法需要空一个，所以只能存maxsize -1 个数。
 * @param maxSize
 */
class CycleArrayDemo(maxSize: Int) {

  var real = 0;
  var front = 0;
  val array = new Array[Int](maxSize)

  def isEmpty: Boolean = front % maxSize == real

  def isFull: Boolean = (real + 1) % maxSize == front

  def offer(value: Int) = {
    if(isFull) throw new IllegalArgumentException("queue is full")
    array(real) = value
    real = (real + 1) % maxSize
  }

  def poll() = {
    if (isEmpty) throw new IllegalArgumentException("queue is empty")
    val res = array(front)
    front = (front + 1) % maxSize
    res
  }

  def totalNum = {
    (real + maxSize - front) % maxSize
  }

  def show() = {
    if(isEmpty) throw new IllegalArgumentException("queue is empty")
    for(i <- 0 until totalNum) {
      println(s"the ${i} value is ${array((front + i) % maxSize)}")
    }
  }

  def get={
    if(isEmpty) throw new IllegalArgumentException("queue is empty")
    array(front)
  }

  def showIndex = {
    println(s"front is ${front}")
    println(s"real is ${real}")
  }

}

object CycleArrayDemo {
  def main(args: Array[String]): Unit = {
    val cycleArray = new CycleArrayDemo(4);

    var loop = true
    while (loop){
      try {
        val op = StdIn.readLine()
        op match {
          case "s" => cycleArray.show()
          case "e" => loop = false
          case "a" => println("输入需要添加的整数。")
            cycleArray.offer(StdIn.readInt())
          case "p" => println(cycleArray.poll())
          case "h" => println(cycleArray.get)
          case "si" => cycleArray.showIndex
          case _ => throw new IllegalArgumentException("invalid param")
        }
      } catch {
        case ex:Exception => println(ex.getMessage)
      }
    }
  }
}