package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinClimbingStairsTest {
    /*
     * 당신은 계단을 오르고 있다. 정상에 도달하기 위해 n게단을 올라야 한다.
     * 매번 각각 1계단 또는 2계단씩 오를 수 있다면 정상에 도달하기 위한 방법은 몇 가지 경로가 되는지 계산하라.
     */

    @Test
    fun test_climbStairs() {
        val n = 4
        val actual: Int = climbStairs(n)
        assertEquals(5, actual)
    }

    @Test
    fun test_climbStairs2() {
        val n = 4
        val actual: Int = climbStairs2(n)
        assertEquals(5, actual)
    }

    private fun climbStairs(n: Int): Int {
        if (n <= 2) return n

        return climbStairs(n - 1) + climbStairs(n - 2)
    }

    private val dp = IntArray(46)

    private fun climbStairs2(n: Int): Int {
        if (n <= 2) return n

        if (dp[n] != 0) return dp[n]

        dp[n] = climbStairs2(n - 1) + climbStairs2(n - 2)
        return dp[n]
    }
}
