package com.lsasta.data.structure.stack

object Calculator {

  def main(args: Array[String]): Unit = {

    val numStack = new ArrayStack(30)
    val charStack = new ArrayStack(30)

    val symbols = Map('+' -> 1, '-' -> 1, '*' -> 0, '/' -> 0)
    val str = "3*4+18-6*3-8+3*2+5/5"
    var index = 0
    var num1 = 0
    var num2 = 0
    var res = 0
    while (index < str.length){
      val ch = str.charAt(index)
      println(ch)
      if(symbols.keys.toList.contains(ch)){
        if(charStack.isEmpty){
          charStack.offer(ch.toInt)
        } else {
          while (!charStack.isEmpty && symbols(ch) >= symbols(charStack.get.toChar)) {
            num1 = numStack.pop
            num2 = numStack.pop
            val opr = charStack.pop.toChar
            res = calc(num1, num2, opr)
            numStack.offer(res)
          }
          charStack.offer(ch.toInt)
        }
      } else {
        var tmp_index = index + 1
        var strBuilder = StringBuilder.newBuilder
        strBuilder += ch
        while(tmp_index < str.length && !symbols.keys.toList.contains(str.charAt(tmp_index))){
          strBuilder += str.charAt(tmp_index)
          tmp_index += 1
        }
        val num = strBuilder.result().toInt
        numStack.offer(num)
        index = tmp_index - 1
      }
      index += 1
    }

    while (!charStack.isEmpty){
      val ch = charStack.pop.toChar
      num1 = numStack.pop
      num2 = numStack.pop
      numStack.offer(calc(num1, num2, ch))
    }

    println("结果是： " + numStack.pop)
  }

  def calc(num1: Int, num2: Int, ch: Char) = {
    println(s"计算： ${num2} ${ch} ${num1}")
    ch match {
      case '+' => num1 + num2
      case '-' => num2 - num1
      case '*' => num1 * num2
      case '/' => num2 / num1
      case _ => throw new RuntimeException("表达式错误。")
    }
  }

}
