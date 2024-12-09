package com.example.algorithmstudy.book

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import java.util.Arrays

class KotlinTwoSum2InputArrayIsSortedTest {
    /*
     * 정렬된 배열을 받아 덧셈하여 타깃을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라.
     */

    @Test
    fun test_twoSum() {
        val numbers = intArrayOf(2, 6, 11, 15)
        val target = 8
        val actual = twoSum(numbers, target)
        assertArrayEquals(
            intArrayOf(1, 2),
            actual,
        )
    }

    @Test
    fun test_twoSum2() {
        val numbers = intArrayOf(2, 6, 11, 15)
        val target = 8
        val actual = twoSum2(numbers, target)
        assertArrayEquals(
            intArrayOf(1, 2),
            actual,
        )
    }

    @Test
    fun test_twoSum3() {
        val numbers = intArrayOf(2, 6, 11, 15)
        val target = 8
        val actual = twoSum3(numbers, target)
        assertArrayEquals(
            intArrayOf(1, 2),
            actual,
        )
    }

    private fun twoSum(
        numbers: IntArray,
        target: Int,
    ): IntArray? {
        var left = 0
        var right = numbers.size - 1

        while (left != right) {
            when {
                numbers[left] + numbers[right] < target -> left++
                numbers[left] + numbers[right] > target -> right--
                else -> return intArrayOf(left + 1, right + 1)
            }
        }

        return null
    }

    private fun twoSum2(
        numbers: IntArray,
        target: Int,
    ): IntArray? {
        for (i in numbers.indices) {
            var left = i + 1
            var right = numbers.size - 1
            val expected = numbers[i] - target

            while (left <= right) {
                val mid = left + (right - left) / 2

                when {
                    numbers[mid] < expected -> left = mid + 1
                    numbers[mid] > target -> right = mid - 1
                    else -> return intArrayOf(i + 1, mid + 1)
                }
            }
        }

        return null
    }

    private fun twoSum3(
        numbers: IntArray,
        target: Int,
    ): IntArray? {
        for (i in numbers.indices) {
            val expected = target - numbers[i]
            val idx = Arrays.binarySearch(numbers, i + 1, numbers.size, expected)
            if (idx >= 0) {
                return intArrayOf(i + 1, idx + 1)
            }
        }

        return null
    }
}
