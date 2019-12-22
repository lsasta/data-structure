package com.lsasta.data.structure.link

object DoubleLinkedDemo {
  def main(args: Array[String]): Unit = {

    val doubleLinked = new DoubleLinked

    val dNode1 = DNode(1)
    val dNode2 = DNode(2)
    val dNode3 = DNode(3)
    val dNode4 = DNode(4)

    doubleLinked.add(dNode1)
    doubleLinked.add(dNode2)
    doubleLinked.add(dNode3)
    doubleLinked.add(dNode4)

    doubleLinked.list
    doubleLinked.del(dNode3)
    doubleLinked.list

  }
}


class DoubleLinked {

  val head: DNode = new DNode(-1)

  def add(cur: DNode) = {
    var tmpNode = head
    while(tmpNode.next != null){
      tmpNode = tmpNode.next
    }
    tmpNode.next = cur
    cur.pre = tmpNode
  }


  def list = {
    var tmp = head
    while (tmp.next != null){
      tmp = tmp.next
      println(tmp)
    }
  }

  def del(cur: DNode) = {

    var tmp = head
    while (tmp.next != null){
      tmp = tmp.next
      if(tmp.id == cur.id){
        tmp.pre.next = tmp.next
        tmp.next.pre = tmp.pre
      }
    }
  }
}

case class DNode(id: Int) {
  var pre: DNode = null
  var next: DNode = null
}