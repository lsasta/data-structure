package com.lsasta.data.structure.stack

import com.lsasta.data.structure.array.queue.ArrayQueueDemo


/**
 * 初始化两个栈：运算符栈s1和储存中间结果的栈s2；
 * 从左至右扫描中缀表达式；
 * 遇到操作数时，将其压s2；
 * 遇到运算符时，比较其与s1栈顶运算符的优先级：
 * 如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
 * 否则，若优先级比栈顶运算符的高，也将运算符压入s1；
 * 否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较；
 * 遇到括号时： (1) 如果是左括号“(”，则直接压入s1 (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
 * 重复步骤2至5，直到表达式的最右边
 * 将s1中剩余的运算符依次弹出并压入s2
 * 依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
 */
object MidSuffix2LastSuffix {

  def main(args: Array[String]): Unit = {

    val str = "1+((2+3)*4)-5"
    val priority = Map('+' -> 1, '-' -> 1, '*' -> 0, '/' -> 0)
    val symbols = Seq('+', '-', '*' , '/' , '(', ')')
    val optStack = new ArrayStack(30)
    val numQueue = new ArrayQueueDemo(30)

    var index = 0
    while (index < str.length){
      val ch = str.charAt(index)
      if(priority.keys.toList.contains(ch)){
        while(!optStack.isEmpty && !'('.equals(optStack.get.toChar) && priority(ch) >= priority(optStack.get.toChar)){
          numQueue.offer(optStack.pop)
        }
        optStack.offer(ch.toInt)
      } else if('('.equals(ch)){
        optStack.offer(ch)
      } else if(')'.equals(ch)){
        var tmpChar = optStack.pop.toChar
        while(!'('.equals(tmpChar)){
          numQueue.offer(tmpChar.toInt)
          tmpChar = optStack.pop.toChar
        }
      } else {
        var tmpIndex = index + 1
        val strBuilder = StringBuilder.newBuilder
        strBuilder += ch
        while (tmpIndex < str.length && !symbols.contains(str.charAt(tmpIndex))){
          strBuilder += str.charAt(tmpIndex)
          tmpIndex += 1
        }
        val num = strBuilder.result()
        numQueue.offer(num.toInt)
        index = tmpIndex - 1
      }
      index += 1
    }
    while (!optStack.isEmpty){
      numQueue.offer(optStack.pop)
    }

    while (!numQueue.isEmpty){
      println(numQueue.poll())
    }
  }

}
