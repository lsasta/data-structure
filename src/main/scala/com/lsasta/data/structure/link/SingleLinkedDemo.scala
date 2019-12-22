package com.lsasta.data.structure.link

object SingleLinkedDemo {

  def main(args: Array[String]): Unit = {

    val sglk = new SingleLinked
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)

    sglk.add(node1)
    sglk.add(node2)
    sglk.add(node3)

    sglk.show

    reverseNode(sglk.head)

    sglk.show
  }

  def reverseNode(head: Node) = {
    if(head.next != null && head.next.next != null){
      var tmp = head.next
      val reverseNode = Node(0)
      while (tmp != null){
        val tmpReverse = tmp
        tmp = tmp.next
        tmpReverse.next = reverseNode.next
        reverseNode.next = tmpReverse
      }
      head.next = reverseNode.next
    }
  }

}

class SingleLinked{

  val head = new Node(0);

  def add(node: Node) = {
    var tmp = head
    while (tmp.next != null){
      tmp = tmp.next
    }
    tmp.next = node
  }

  def show = {
    var tmp = head
    while (tmp.next != null){
      tmp = tmp.next
      println(tmp)
    }
  }
}

case class Node(id: Int){
  var next: Node = null
}

