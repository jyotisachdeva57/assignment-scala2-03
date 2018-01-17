package edu.knoldus

import org.apache.log4j.Logger

object MenuLauncher {

  def main(args: Array[String]): Unit = {
    val log = Logger.getLogger(this.getClass) //in code
    val obj = new Operations
    val firstList = List(1, 2, 3, 4, 5)
    val secondList = List(6, 7)
    val subList = List(2, 3)
    val subList1 = List(1, 3)
    log.info(obj.mergeList(firstList, secondList))
    log.info(obj.length(firstList))
    log.info(obj.hasSubSequence(firstList, subList))
    log.info(obj.hasSubSequence(firstList, secondList))
    log.info(obj.hasSubSequence(firstList, subList1))
    log.info(obj.splitList[Int](firstList, x => x % 2 == 0))
  }

}
