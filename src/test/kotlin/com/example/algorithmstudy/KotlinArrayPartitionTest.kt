package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinArrayPartitionTest {
    /*
     * n개의 페어를 이용한 min(a,b)의 합으로 만들 수 있는 가장 큰 수를 출력하라.
     */

    @Test
    fun test_arrayPairSum() {
        val nums = intArrayOf(1, 3, 4, 2)
        val actual = record { arrayPairSum(nums) }
        assertEquals(4, actual)
    }

    @Test
    fun test_arrayPairSum2() {
        val nums = intArrayOf(1, 3, 4, 2)
        val actual = record { arrayPairSum2(nums) }
        assertEquals(4, actual)
    }

    private fun arrayPairSum(nums: IntArray): Int {
        val pair = mutableListOf<Int>()
        var sum = 0

        nums.sort()

        for (num in nums) {
            pair.add(num)
            if (pair.size == 2) {
                sum += pair.min()
                pair.clear()
            }
        }

        return sum
    }

    private fun arrayPairSum2(nums: IntArray): Int {
        var sum = 0
        nums.sort()

        for ((i, num) in nums.withIndex()) {
            if (i % 2 == 0) {
                sum += num
            }
        }

        return sum
    }
}
