package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.Arrays

class KotlinBinarySearchTest {
    /*
     * 정렬된 nums를 입력받아 이진 검색으로 target에 해당하는 인덱스를 찾아라.
     */

    @Test
    fun test_search() {
        val nums = intArrayOf(-1, 0, 3, 5, 9, 12, 15)
        val target = 9
        val actual: Int = search(nums, target)
        Assertions.assertEquals(4, actual)
    }

    @Test
    fun test_search2() {
        val nums = intArrayOf(-1, 0, 3, 5, 9, 12, 15)
        val target = 9
        val actual: Int = search2(nums, target)
        Assertions.assertEquals(4, actual)
    }

    @Test
    fun test_search3() {
        val nums = intArrayOf(-1, 0, 3, 5, 9, 12, 15)
        val target = 9
        val actual: Int = search3(nums, target)
        Assertions.assertEquals(4, actual)
    }

    @Test
    fun test_search4() {
        val nums = intArrayOf(-1, 0, 3, 5, 9, 12, 15)
        val target = 9
        val actual: Int = search4(nums, target)
        Assertions.assertEquals(4, actual)
    }

    private fun search(
        nums: IntArray,
        target: Int,
    ): Int {
        fun binarySearch(
            left: Int,
            right: Int,
        ): Int {
            if (left > right) return -1

            val mid = (left + right) / 2

            return when {
                nums[mid] < target -> binarySearch(mid + 1, right)
                nums[mid] > target -> binarySearch(left, mid - 1)
                else -> mid
            }
        }

        return binarySearch(0, nums.size - 1)
    }

    private fun search2(
        nums: IntArray,
        target: Int,
    ): Int {
        fun binarySearch(
            left: Int,
            right: Int,
        ): Int {
            if (left > right) return -1

            val mid = left + (right - left) / 2
            return when {
                nums[mid] < target -> binarySearch(mid + 1, right)
                nums[mid] > target -> binarySearch(left, mid - 1)
                else -> mid
            }
        }

        return binarySearch(0, nums.size - 1)
    }

    private fun search3(
        nums: IntArray,
        target: Int,
    ): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2

            when {
                nums[mid] < target -> left = mid + 1
                nums[mid] > target -> right = mid - 1
                else -> return mid
            }
        }

        return -1
    }

    private fun search4(
        nums: IntArray,
        target: Int,
    ): Int {
        return Arrays.binarySearch(nums, target)
    }
}
