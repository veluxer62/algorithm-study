package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

class KotlinGetPrimeCountTest {
    /*
     * 숫자를 k진수로 변환하고 0으로 구분했을 때 소수가 몇 개인지 출력하라.
     */

    @Test
    fun test_getPrimeCount() {
        var n = 437674
        var k = 3
        var actual: Int = getPrimeCount(n, k)
        assertEquals(3, actual)

        n = 110011
        k = 10
        actual = getPrimeCount(n, k)
        assertEquals(2, actual)
    }

    @Test
    fun test_getPrimeCount2() {
        var n = 437674
        var k = 3
        var actual: Int = getPrimeCount2(n, k)
        assertEquals(3, actual)

        n = 110011
        k = 10
        actual = getPrimeCount2(n, k)
        assertEquals(2, actual)
    }

    @Test
    fun test_getPrimeCount3() {
        var n = 437674
        var k = 3
        var actual: Int = getPrimeCount3(n, k)
        assertEquals(3, actual)

        n = 110011
        k = 10
        actual = getPrimeCount3(n, k)
        assertEquals(2, actual)
    }

    @Test
    fun test_getPrimeCount4() {
        var n = 437674
        var k = 3
        var actual: Int = getPrimeCount4(n, k)
        assertEquals(3, actual)

        n = 110011
        k = 10
        actual = getPrimeCount4(n, k)
        assertEquals(2, actual)
    }

    private fun getPrimeCount(
        n: Int,
        k: Int,
    ): Int {
        fun isPrime(num: Int): Boolean {
            if (num == 1) return false

            for (i in 3 until num) {
                if (num % i == 0) return false
            }

            return true
        }

        val stack = ArrayDeque<Int>()
        var remainder: Int
        var m = n
        while (m != 0) {
            remainder = m % k
            m /= k
            stack.addLast(remainder)
        }

        val sb = StringBuilder()
        while (stack.isNotEmpty()) {
            sb.append(stack.removeLast())
        }

        var answer = 0
        for (s in sb.toString().split("0")) {
            if (s.isEmpty()) continue

            if (isPrime(s.toInt())) {
                answer++
            }
        }

        return answer
    }

    private fun getPrimeCount2(
        n: Int,
        k: Int,
    ): Int {
        fun isPrime(num: Long): Boolean {
            if (num == 1L) return false

            for (i in 3 until num) {
                if (num % i == 0L) return false
            }

            return true
        }

        val stack = ArrayDeque<Int>()
        var remainder: Int
        var m = n

        while (m != 0) {
            remainder = m % k
            m /= k
            stack.addFirst(remainder)
        }

        val sb = StringBuilder()
        while (stack.isNotEmpty()) {
            sb.append(stack.removeFirst())
        }

        var answer = 0
        for (s in sb.toString().split("0")) {
            if (s.isEmpty()) continue
            if (isPrime(s.toLong())) {
                answer++
            }
        }

        return answer
    }

    private fun getPrimeCount3(
        n: Int,
        k: Int,
    ): Int {
        fun isPrime(num: Long): Boolean {
            if (num == 1L) return false
            if (num > 2L && num % 2L == 0L) return false

            for (i in 3 until sqrt(num.toDouble()).toInt() step 2) {
                if (num % i == 0L) return false
            }

            return true
        }

        val stack = ArrayDeque<Int>()
        var remainder: Int
        var m = n
        while (m != 0) {
            remainder = m % k
            m /= k
            stack.addFirst(remainder)
        }

        val sb = StringBuilder()
        while (stack.isNotEmpty()) {
            sb.append(stack.removeFirst())
        }

        var answer = 0
        for (s in sb.toString().split("0")) {
            if (s.isEmpty()) continue
            if (isPrime(s.toLong())) {
                answer++
            }
        }

        return answer
    }

    private fun getPrimeCount4(
        n: Int,
        k: Int,
    ): Int {
        fun isPrime(num: Long): Boolean {
            if (num == 1L) return false
            if (num > 2L && num % 2L == 0L) return false

            for (i in 3 until sqrt(num.toDouble()).toInt() step 2) {
                if (num % i == 0L) return false
            }

            return true
        }

        val str = n.toString(k)

        var answer = 0
        for (s in str.split("0")) {
            if (s.isEmpty()) continue
            if (isPrime(s.toLong())) {
                answer++
            }
        }

        return answer
    }
}
