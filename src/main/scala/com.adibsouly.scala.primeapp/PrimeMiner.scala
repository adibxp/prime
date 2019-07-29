package com.adibsouly.scala.primeapp

object PrimeMiner {

  def primeStream(stream: Stream[Int] = Stream.from(3, 2)): Stream[Int] = {
    stream.head #:: primeStream(stream.tail.filter(_ % stream.head != 0))
  }

  def getPrimes(end: Int): List[Int] = {
    val odds = Stream.from(3, 2).takeWhile(_ <= Math.sqrt(end).toInt)
    val composites = odds.flatMap(i => Stream.from(i * i, 2 * i).takeWhile(_ <= end))
    Stream.from(3, 2).takeWhile(_ < end).diff(composites).toList
  }

}
