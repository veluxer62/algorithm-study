package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinSingleNumberTest {
    /*
     * 딱 하나를 제외하고 모든 엘리먼트가 2개씩 있다. 1개인 엘리먼트를 찾아라.
     */

    @Test
    fun test_singleNumber() {
        val nums = intArrayOf(1, 2, 1)
        val actual: Int = singleNumber(nums)
        Assertions.assertEquals(2, actual)
    }

    private fun singleNumber(nums: IntArray): Int {
        return nums.fold(0) { acc, num -> acc xor num }
    }
}
