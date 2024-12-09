package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinCycleRobberTest {
    /*
     * 한 칸 이상 떨어진 집을 훔 칠 수 있는데, 원형으로 연결되어 있다. 훔칠 수 있는 가장 큰 금액을 출력하라.
     */

    @Test
    fun test_rob() {
        val nums = intArrayOf(8, 7, 3, 9)
        val actual: Int = rob(nums)
        Assertions.assertEquals(16, actual)
    }

    private fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        val dp = Array(2) { IntArray(nums.size) }
        dp[0][0] = 0
        dp[0][1] = 0
        dp[1][0] = 0
        dp[1][1] = nums[1]

        for (i in 2 until nums.size) {
            dp[0][i] = maxOf(dp[0][i - 1], dp[0][i - 2] + nums[i])
            dp[1][i] = maxOf(dp[1][i - 1], dp[1][i - 2] + nums[i])
        }

        return maxOf(nums[0] + dp[0][nums.size - 2], dp[1][nums.size - 1])
    }
}
