package com.lsasta.data.structure.array.queue

import scala.io.StdIn

object ArrayQueueDemo {

  def main(args: Array[String]): Unit = {
    val arrayQueueDemo = new ArrayQueueDemo(10);

    var loop = true
    while (loop){
      try {
        println("s(show)显示队列")
        println("e(exit)退出循环")
        println("a(add)添加数据")
        println("p(poll)获取队列元素")
        println("h(head)查看队列首元素")
        val op = StdIn.readLine()
        op match {
          case "s" => arrayQueueDemo.show()
          case "e" => loop = false
          case "a" => println("输入需要添加的整数。")
            arrayQueueDemo.offer(StdIn.readInt())
          case "p" => println(arrayQueueDemo.poll())
          case "h" => println(arrayQueueDemo.get())
          case _ => throw new IllegalArgumentException("invalid param")
        }
      } catch {
        case ex:Exception => println(ex.getMessage)
      }
    }
  }

}

class ArrayQueueDemo(maxsize: Int) {

  var front: Int = 0;
  var real: Int = 0;
  var array: Array[Int] = new Array[Int](maxsize);

  def isFull = real == maxsize - 1

  def isEmpty = real == front

  def offer(value: Int) = {
    if(isFull) throw new IllegalArgumentException("queue is full")
    array(real) = value
    real += 1
  }

  def poll(): Int ={
    if(isEmpty) throw new IllegalArgumentException("queue is empty")
    val frontTmp = front
    front += 1
    array(frontTmp)
  }

  def get(): Int = {
    if(isEmpty) throw new IllegalArgumentException("queue is empty")
    array(front)
  }

  def show(): Unit = {
    if(isEmpty) throw new IllegalArgumentException("queue is empty")
    for ((i, value) <- array.zipWithIndex) {
      println(s"the ${i} value is ${value}")
    }
  }

}
