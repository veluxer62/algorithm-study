package com.example.algorithmstudy.book

import com.example.algorithmstudy.record
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinTrappingRainWaterTest {
    /*
     * 높이를 입력받아 비온 후 얼마나 많은 물이 쌓일 수 있는지 계산하라.
     */

    @Test
    fun test_trap() {
        val heights = intArrayOf(1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
        val actual = record { trap(heights) }
        assertEquals(6, actual)
    }

    @Test
    fun test_trap2() {
        val heights = intArrayOf(1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
        val actual = record { trap2(heights) }
        assertEquals(6, actual)
    }

    private fun trap(heights: IntArray): Int {
        var volume = 0
        var left = 0
        var right = heights.size - 1
        var leftMax = heights[left]
        var rightMax = heights[right]

        while (left < right) {
            leftMax = maxOf(heights[left], leftMax)
            rightMax = maxOf(heights[right], rightMax)

            if (leftMax <= rightMax) {
                volume += leftMax - heights[left]
                left++
            } else {
                volume += rightMax - heights[right]
                right--
            }
        }

        return volume
    }

    private fun trap2(heights: IntArray): Int {
        val stack = ArrayDeque<Int>()
        var volume = 0

        for ((idx, item) in heights.withIndex()) {
            while (stack.isNotEmpty() && item > heights[stack.first()]) {
                val top = stack.removeFirst()

                if (stack.isEmpty()) break

                val destination = idx - stack.first() - 1
                val water = minOf(item, heights[stack.first()] - heights[top])
                volume += water * destination
            }

            stack.addFirst(idx)
        }

        return volume
    }
}
