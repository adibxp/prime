package com.adibsouly.scala.primeapp

import org.scalatest.{FlatSpec, Matchers}


class PrimeMinerTest extends FlatSpec with Matchers {

  val primesUntil100 = List(3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)

  it should "calculate the first few primes" in {

    PrimeMiner.primeStream().takeWhile(_ < 100).toList should be(primesUntil100)
    PrimeMiner.getPrimes(100) should be(primesUntil100)
  }

  it should "benchmark" in {
    println("Timing to generate all primes up to 1 million:")
    val streamAvg = (1 to 10).map(_ => timed(PrimeMiner.getPrimes(1000000))).sum / 10
    println("took " + streamAvg + " ms on average over 10 runs.")
  }

  private def timed(function: => Unit): Long = {
    val s = System.currentTimeMillis()
    function
    val e = System.currentTimeMillis()
    e - s
  }

}