package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinHouseRobberTest {
    /*
     * 당신은 전문털이범이다.
     * 어느 집에서든 돈을 훔쳐올 수 있지만 경보 시스템 때문에 바로 옆집은 훔칠 수 없고 한 칸 이상 떨어진 집만 가능한다.
     * 각 집에는 훔칠 수 있는 돈의 액수가 입력값으로 표기되어 있다.
     * 훔칠 수 있는 가장 큰 금액을 출력하라.
     */

    @Test
    fun test_rob() {
        val nums = intArrayOf(8, 7, 3, 9)
        val actual: Int = rob(nums)
        assertEquals(17, actual)
    }

    @Test
    fun test_rob2() {
        val nums = intArrayOf(8, 7, 3, 9)
        val actual: Int = rob2(nums)
        assertEquals(17, actual)
    }

    private fun rob(nums: IntArray): Int {
        fun rob(n: Int): Int {
            if (n < 0) return 0

            return maxOf(
                rob(n - 1),
                rob(n - 2) + nums[n],
            )
        }

        return rob(nums.size - 1)
    }

    private fun rob2(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = maxOf(dp[0], nums[1])

        for (i in 2 until nums.size) {
            dp[i] = maxOf(dp[i - 1], dp[i - 2] + nums[i])
        }

        return dp[nums.size - 1]
    }
}
