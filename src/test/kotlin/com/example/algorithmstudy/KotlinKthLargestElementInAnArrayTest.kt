package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.Collections
import java.util.PriorityQueue

class KotlinKthLargestElementInAnArrayTest {
    /*
     * 정렬되지 않은 배열에서 k번째 큰 엘리먼트를 추출하라.
     */

    @Test
    fun test_findKthLargest() {
        val nums = intArrayOf(1, 3, 2, 3, 1, 2, 4, 5, 5, 6)
        val k = 4
        val actual: Int = findKthLargest(nums, k)
        Assertions.assertEquals(4, actual)
    }

    private fun findKthLargest(
        nums: IntArray,
        k: Int,
    ): Int {
        var heap = PriorityQueue<Int>(Collections.reverseOrder())

        for (num in nums) {
            heap.add(num)
        }

        for (i in 0 until k - 1) {
            heap.poll()
        }

        return heap.poll()
    }
}
