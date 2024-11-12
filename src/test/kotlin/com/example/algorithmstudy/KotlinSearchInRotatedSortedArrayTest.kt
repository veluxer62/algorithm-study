package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinSearchInRotatedSortedArrayTest {
    /*
     * 특정 피벗을 기준으로 회전하여 정렬된 배열에서 target 값의 인덱스를 출력하라.
     */

    @Test
    fun test_search() {
        val nums = intArrayOf(3, 4, 5, 6, 0, 1, 2)
        val target = 1
        val actual: Int = search(nums, target)
        assertEquals(5, actual)
    }

    private fun search(
        nums: IntArray,
        target: Int,
    ): Int {
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val mid = left + (right - left) / 2

            if (nums[mid] > nums[right]) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        val pivot = left

        left = 0
        right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            val midPivot = (mid + pivot) % nums.size

            when {
                nums[midPivot] < target -> left = mid + 1
                nums[midPivot] > target -> right = mid - 1
                else -> return midPivot
            }
        }

        return -1
    }
}
