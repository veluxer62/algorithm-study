package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinFibonacciNumberTest {
    /*
     * 피보나치 수를 구하라.
     */

    @Test
    fun test_fib() {
        val n = 5
        val actual: Int = fib(n)
        assertEquals(5, actual)
    }

    @Test
    fun test_fib2() {
        val n = 5
        val actual: Int = fib2(n)
        assertEquals(5, actual)
    }

    @Test
    fun test_fib3() {
        val n = 5
        val actual: Int = fib3(n)
        assertEquals(5, actual)
    }

    @Test
    fun test_fib4() {
        val n = 5
        val actual: Int = fib4(n)
        assertEquals(5, actual)
    }

    private fun fib(n: Int): Int {
        if (n <= 1) return n

        return fib(n - 1) + fib(n - 2)
    }

    val memo = IntArray(31)

    private fun fib2(n: Int): Int {
        if (n <= 1) return n
        if (memo[n] != 0) return memo[n]

        memo[n] = fib(n - 1) + fib(n - 2)
        return memo[n]
    }

    private fun fib3(n: Int): Int {
        val dp = IntArray(31)

        dp[0] = 0
        dp[1] = 1

        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n]
    }

    private fun fib4(n: Int): Int {
        var x = 0
        var y = 1

        for (i in 0 until n) {
            val z = x + y
            x = y
            y = z
        }

        return x
    }
}
