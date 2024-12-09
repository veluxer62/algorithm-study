package com.example.algorithmstudy.book

import com.example.algorithmstudy.record
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KotlinTwoSumTest {
    /*
     * 덧셈하여 타깃을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라.
     */

    @Test
    fun test_twoSum() {
        val nums = intArrayOf(2, 6, 11, 15)
        val target = 8
        val actual =
            record {
                twoSum(nums, target)
            }
        assertArrayEquals(intArrayOf(0, 1), actual)
    }

    @Test
    fun test_twoSum2() {
        val nums = intArrayOf(2, 6, 11, 15)
        val target = 8
        val actual =
            record {
                twoSum2(nums, target)
            }
        assertArrayEquals(intArrayOf(0, 1), actual)
    }

    @Test
    fun test_twoSum3() {
        val nums = intArrayOf(2, 6, 11, 15)
        val target = 8
        val actual =
            record {
                twoSum3(nums, target)
            }
        assertArrayEquals(intArrayOf(0, 1), actual)
    }

    @Test
    fun test_twoSum4() {
        val nums = intArrayOf(2, 6, 11, 15)
        val target = 8
        val actual =
            record {
                twoSum4(nums, target)
            }
        assertArrayEquals(intArrayOf(0, 1), actual)
    }

    private fun twoSum(
        nums: IntArray,
        target: Int,
    ): IntArray {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }

        return intArrayOf()
    }

    private fun twoSum2(
        nums: IntArray,
        target: Int,
    ): IntArray {
        val map = mutableMapOf<Int, Int>()

        for ((idx, num) in nums.withIndex()) {
            map[num] = idx
        }

        for ((idx, num) in nums.withIndex()) {
            val key = target - num
            if (map.contains(key) && map[key] != idx) {
                return intArrayOf(idx, map[key]!!)
            }
        }

        return intArrayOf()
    }

    private fun twoSum3(
        nums: IntArray,
        target: Int,
    ): IntArray {
        val map = mutableMapOf<Int, Int>()

        for ((idx, num) in nums.withIndex()) {
            val key = target - num
            if (map.contains(key)) {
                return intArrayOf(map[key]!!, idx)
            }
            map[num] = idx
        }

        return intArrayOf()
    }

    private fun twoSum4(
        nums: IntArray,
        target: Int,
    ): IntArray {
        var left = 0
        var right = nums.size - 1

        while (left != right) {
            when {
                nums[left] + nums[right] < target -> left++
                nums[left] + nums[right] > target -> right--
                else -> return intArrayOf(left, right)
            }
        }

        return intArrayOf()
    }
}
