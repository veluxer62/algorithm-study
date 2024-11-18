package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import java.util.LinkedList

class KotlinSlidingWindowMaximumTest {
    /*
     * 배열 nums가 주어졌을 때 k 크기의 슬라이딩 윈도우를 오른쪽 끝까지 이동하면서 최대 슬라이딩 윈도우를 구하라.
     */

    @Test
    fun test_maxSlidingWindow() {
        val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 8)
        val k = 3
        val actual: IntArray = maxSlidingWindow(nums, k)
        assertArrayEquals(
            intArrayOf(3, 3, 5, 5, 6, 8),
            actual,
        )
    }

    @Test
    fun test_maxSlidingWindow2() {
        val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 8)
        val k = 3
        val actual: IntArray = maxSlidingWindow2(nums, k)
        assertArrayEquals(
            intArrayOf(3, 3, 5, 5, 6, 8),
            actual,
        )
    }

    @Test
    fun test_maxSlidingWindow3() {
        val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 8)
        val k = 3
        val actual: IntArray = maxSlidingWindow3(nums, k)
        assertArrayEquals(
            intArrayOf(3, 3, 5, 5, 6, 8),
            actual,
        )
    }

    private fun maxSlidingWindow(
        nums: IntArray,
        k: Int,
    ): IntArray {
        val result = mutableListOf<Int>()

        for (i in 0 until nums.size - k + 1) {
            var max = nums[i]

            for (j in i + 1 until i + k) {
                if (max < nums[j]) {
                    max = nums[j]
                }
            }

            result.add(max)
        }

        return result.toIntArray()
    }

    private fun maxSlidingWindow2(
        nums: IntArray,
        k: Int,
    ): IntArray {
        val result = mutableListOf<Int>()
        val window = LinkedList<Int>()
        var currentMax = Int.MIN_VALUE

        for (i in nums.indices) {
            window.add(nums[i])

            if (i < k - 1) continue

            when {
                currentMax == Int.MIN_VALUE -> currentMax = window.max()
                currentMax < nums[i] -> currentMax = nums[i]
            }

            result.add(currentMax)

            if (currentMax == window.poll()) {
                currentMax = Int.MIN_VALUE
            }
        }

        return result.toIntArray()
    }

    private fun maxSlidingWindow3(
        nums: IntArray,
        k: Int,
    ): IntArray {
        val result = mutableListOf<Int>()
        val dq = ArrayDeque<Int>()

        for (i in nums.indices) {
            if (dq.isNotEmpty() && dq.first() < i - k + 1) {
                dq.removeFirst()
            }

            while (dq.isNotEmpty() && nums[dq.last()] < nums[i]) {
                dq.removeLast()
            }

            dq.add(i)

            if (i >= k - 1) {
                result.add(nums[dq.first()])
            }
        }

        return result.toIntArray()
    }
}
