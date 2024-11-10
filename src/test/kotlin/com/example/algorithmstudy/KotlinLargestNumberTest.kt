package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KotlinLargestNumberTest {
    /*
     * 엘리먼트를 조합해 만들 수 있는 가장 큰 수를 출력하라.
     */

    @Test
    fun test_largestNumber() {
        val nums = intArrayOf(3, 30, 34, 8, 9)
        val actual: String = largestNumber(nums)
        assertEquals(
            "9834330",
            actual,
        )
    }

    private fun largestNumber(nums: IntArray): String {
        var i = 1

        while (i < nums.size) {
            var j = i
            while (j > 0 && toSwap(nums[j - 1], nums[j])) {
                nums[j] = nums[j - 1].also { nums[j - 1] = nums[j] }
                j--
            }
            i++
        }

        return if (nums.first() == 0) {
            "0"
        } else {
            nums.joinToString(separator = "")
        }
    }

    private fun toSwap(
        n1: Int,
        n2: Int,
    ): Boolean {
        return (n1.toString() + n2).toLong() < (n2.toString() + n1).toLong()
    }
}
