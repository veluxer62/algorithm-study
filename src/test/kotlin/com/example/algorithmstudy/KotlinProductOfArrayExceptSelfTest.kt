package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinProductOfArrayExceptSelfTest {
    /*
     * 배열을 입력받아 output[i]가 자신을 제외한 나머지 모든 엘리먼트의 곱셈 결과가 되도록 출력하다.
     */

    @Test
    fun test_productExceptSelf() {
        val arr = intArrayOf(1, 3, 5, 7)
        val actual = record { productExceptSelf(arr) }
        Assertions.assertArrayEquals(intArrayOf(105, 35, 21, 15), actual)

        val arr2 = generateIntArray(50000)
        record { productExceptSelf(arr2) }
    }

    @Test
    fun test_productExceptSelf2() {
        val arr = intArrayOf(1, 3, 5, 7)
        val actual = record { productExceptSelf2(arr) }
        Assertions.assertArrayEquals(intArrayOf(105, 35, 21, 15), actual)

        val arr2 = generateIntArray(50000)
        record { productExceptSelf2(arr2) }
    }

    private fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)

        for (i in nums.indices) {
            var multiply = 1
            for (num in nums) {
                multiply *= num
            }
            result[i] = (multiply / nums[i])
        }

        return result
    }

    private fun productExceptSelf2(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var p = 1

        for ((i, num) in nums.withIndex()) {
            result[i] = p
            p *= num
        }

        p = 1
        for ((i, num) in nums.withIndex().reversed()) {
            result[i] *= p
            p *= num
        }

        return result
    }
}
