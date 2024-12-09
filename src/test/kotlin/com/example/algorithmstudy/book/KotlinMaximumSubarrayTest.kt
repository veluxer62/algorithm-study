package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinMaximumSubarrayTest {
    /*
     * 연속된 값으로 구성된 가장 큰 서브 배열을 찾아 합을 리턴하라.
     */

    @Test
    fun test_maxSubArray() {
        val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -6, 4)
        val actual: Int = maxSubArray(nums)
        assertEquals(6, actual)
    }

    @Test
    fun test_maxSubArray2() {
        val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -6, 4)
        val actual: Int = maxSubArray2(nums)
        assertEquals(6, actual)
    }

    private fun maxSubArray(nums: IntArray): Int {
        val sums = mutableListOf(nums[0])

        for (i in 1 until nums.size) {
            sums.add(nums[i] + maxOf(sums[i - 1], 0))
        }

        return sums.max()
    }

    private fun maxSubArray2(nums: IntArray): Int {
        var currentSum = 0
        var bestSum = Int.MIN_VALUE

        for (num in nums) {
            currentSum = maxOf(num, currentSum + num)
            bestSum = maxOf(bestSum, currentSum)
        }

        return bestSum
    }
}
