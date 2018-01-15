package edu.knoldus

import org.apache.log4j.Logger

object MenuLauncher {

  def main(args: Array[String]): Unit = {
    val log = Logger.getLogger(this.getClass) //in code
    val obj = new Operations
    val first = 1
    val second = 1
    val third = 2
    val fourth = 3
    val rotate = 2
    val firstchar = 'a'
    val secondchar = 'b'
    val thirdchar = 'c'
    val charlist = List(firstchar, secondchar, thirdchar)
    val list = List(first, second, third, fourth)
    val resultlist = obj.rotate(rotate, charlist)
    log.info(resultlist)
    val resdel = obj.deleteConsecutive(list)
    log.info(resdel)
    val magicno1 = 19
    val magicno2 = 20
    val happylist = List(magicno1, magicno2)
    for (happy <- happylist) {
      val bool = obj.happyNumber(happy)
      if (bool) {
        log.info(happy + "is a happy number")
      }
      else {
        log.info(happy + "is not a happy number")
      }
    }
  }

}
