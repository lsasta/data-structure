package com.lsasta.data.structure.link

object Josephu {

  def main(args: Array[String]): Unit = {

    val node1 = SingleNode(1)
    val node2 = SingleNode(2)
    val node3 = SingleNode(3)
    val node4 = SingleNode(4)
    val node5 = SingleNode(5)
    val node6 = SingleNode(6)

    val cycleLink = new CycleLink

    cycleLink.addNode(node1)
    cycleLink.addNode(node2)
    cycleLink.addNode(node3)
    cycleLink.addNode(node4)
    cycleLink.addNode(node5)
    cycleLink.addNode(node6)

    println(josephu(cycleLink, 3).mkString("=>"))

  }

  def josephu(cycleLink: CycleLink, num: Int) = {
    var index: Int = 1
    val builder = Seq.newBuilder[Int]
    while (cycleLink.head != cycleLink.tail){
      if(index == num){
        builder +=(cycleLink.head.num)
        cycleLink.tail.next = cycleLink.head.next
        cycleLink.head = cycleLink.head.next
        index = 1
      } else {
        index += 1
        cycleLink.tail = cycleLink.head
        cycleLink.head = cycleLink.head.next
      }
    }
    builder.+=(cycleLink.head.num)
    builder.result()
  }
}

class CycleLink {

  var head: SingleNode = null
  var tail: SingleNode = null

  def addNode(curr: SingleNode) = {
    if(head == null) {
      head = curr
      tail = curr
      curr.next = head
    } else {
      tail.next = curr
      curr.next = head
      tail = curr
    }
  }

}


case class SingleNode(num: Int) {

  var next: SingleNode = null;

}