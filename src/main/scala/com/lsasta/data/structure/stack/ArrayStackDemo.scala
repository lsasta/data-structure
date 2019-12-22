package com.lsasta.data.structure.stack

object ArrayStackDemo {

  def main(args: Array[String]): Unit = {

    val stack = new ArrayStack(10)

    for(i <- 10 to 20){
      try{
        stack.offer(i)
      }catch {
        case e: Exception => println(e.getMessage)
      }
    }

    stack.list

  }

}

class ArrayStack(maxSize: Int) {

  var head: Int = -1
  val stack = new Array[Int](maxSize)

  def isFull = head == maxSize - 1

  def isEmpty = head == -1

  def offer(cur: Int) = {
    if(isFull) throw new RuntimeException("stack is full.")
    head += 1
    stack(head) = cur
  }

  def pop = {
    if(isEmpty) throw new RuntimeException("stack is empty.")
    val value =  stack(head)
    head -= 1
    value
  }

  def get = {
    if(isEmpty) throw new RuntimeException("stack is empty")
    stack(head)
  }

  def list = {

    for(i <- 0 to head){
      println(s"arr ${i}: ${stack(i)}")
    }

  }

}
