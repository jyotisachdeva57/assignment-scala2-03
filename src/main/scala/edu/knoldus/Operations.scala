package edu.knoldus

class Operations {
  def length[A](list: List[A]): Int = list.foldRight(0)((_, num) => num + 1)

  def hasInnerSequence[A](list: List[A], sub: List[A], len1: Int, len2: Int): Boolean = {
    len2 match {
      case 0 => true
      case num if len1 == 0 => false
      case _ => if (list(len1 - 1) == sub(len2 - 1)) hasInnerSequence(list, sub, len1 - 1, len2 - 1) else hasInnerSequence(list, sub, len1 - 1, len2)
    }
  }


  def hasSubSequence[A](list: List[A], sub: List[A]): Boolean = {
    val listLength = list.length
    val subLength = sub.length
    if (subLength > listLength) {
      throw new Exception("Invalid length of lists")
    }
    hasInnerSequence(list, sub, listLength, subLength)
  }

  def mergeList[A](list1: List[A], list2: List[A]): List[A] = {

    def concatenateInner[A](list1: List[A], list2: List[A]): List[A] = {
      list1 match {
        case Nil => list2
        case List(_*) if list2 == Nil => list1
        case head :: tail => concatenateInner(tail, head :: list2)
      }
    }

    val result = concatenateInner(list1.reverse, list2)
    result

  }

  def splitList[A](list: List[A], func: A => Boolean): (List[A], List[A]) = {
    val list1 = List()
    val list2 = List()

    def inner(list: List[A], list1: List[A], list2: List[A]): (List[A], List[A]) = {
      list match {
        case head :: tail => if (func(head)) inner(tail, head :: list1, list2) else inner(tail, list1, head :: list2)
        case Nil => (list1, list2)
      }
    }

    inner(list, list1, list2)
  }

}
