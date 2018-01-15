package edu.knoldus

class Operations {

  def rotate(index: Int, list: List[Char]): List[Char] = {

    def rotateInner(list: List[Char], currentIndex: Int): List[Char] = {
      list match {
        case Nil => list
        case head :: tail if currentIndex == 0 => list
        case head :: tail if tail != Nil => rotateInner(tail :+ head, currentIndex - 1)
      }
    }

    rotateInner(list, index)
  }

  private def sumSquareDigits(number: Int): Int = {
    number match {
      case num => if (num < 10) num * num else (num % 10) * (num % 10) + sumSquareDigits(num / 10)
    }
  }

  private def present(seen: Set[Int], num: Int): Boolean = seen(num)

  def happyNumber(number: Int): Boolean = {

    def happyNumberInner(number: Int, seen: Set[Int]): Boolean = {
      number match {
        case 1 => true
        case _ if present(seen, number) => false
        case _ => happyNumberInner(sumSquareDigits(number), seen + number)
      }
    }

    happyNumberInner(number, Set())
  }

  def deleteConsecutive(list: List[Int]): List[Int] = {
    list match {
      case Nil => Nil
      case List(_) => list
      case head :: head1 :: tail if head == head1 => deleteConsecutive(head1 :: tail)
      case head :: tail => head :: deleteConsecutive(tail)
    }
  }

  def runencoding(list: List[Int]): List[(Int, Int)] = {
    def runInner(list: List[Int], elem: Int, result: List[(Int, Int)]): List[(Int, Int)] = {
      val (list1, list2) = list.span(_ == elem)
      val len = list1.length
      if (list2 == Nil) {
        result
      }
      else {
        runInner(list2, list(len), (elem, len) :: result)
      }
    }

    runInner(list, list(1), List())
  }

}
