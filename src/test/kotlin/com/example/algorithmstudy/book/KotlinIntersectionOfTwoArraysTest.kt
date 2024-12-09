package com.example.algorithmstudy.book

import com.example.algorithmstudy.generateIntArray
import com.example.algorithmstudy.record
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import java.util.Arrays

class KotlinIntersectionOfTwoArraysTest {
    /*
     * 두 배열의 교집합을 구하라
     */

    @Test
    fun test_intersection() {
        val nums1 = intArrayOf(4, 9, 5)
        val nums2 = intArrayOf(9, 4, 9, 8, 4, 6)
        val actual = record { intersection(nums1, nums2) }
        assertArrayEquals(
            intArrayOf(4, 9),
            actual,
        )

        val nums11 = generateIntArray(50000)
        val nums22 = generateIntArray(50000)
        record { intersection(nums11, nums22) }
    }

    @Test
    fun test_intersection2() {
        val nums1 = intArrayOf(4, 9, 5)
        val nums2 = intArrayOf(9, 4, 9, 8, 4, 6)
        val actual = record { intersection2(nums1, nums2) }
        assertArrayEquals(
            intArrayOf(4, 9),
            actual,
        )

        val nums11 = generateIntArray(50000)
        val nums22 = generateIntArray(50000)
        record { intersection2(nums11, nums22) }
    }

    @Test
    fun test_intersection3() {
        val nums1 = intArrayOf(4, 9, 5)
        val nums2 = intArrayOf(9, 4, 9, 8, 4, 6)
        val actual = record { intersection3(nums1, nums2) }
        assertArrayEquals(
            intArrayOf(4, 9),
            actual,
        )

        val nums11 = generateIntArray(50000)
        val nums22 = generateIntArray(50000)
        record { intersection3(nums11, nums22) }
    }

    private fun intersection(
        nums1: IntArray,
        nums2: IntArray,
    ): IntArray {
        val result = mutableSetOf<Int>()

        for (n1 in nums1) {
            for (n2 in nums2) {
                if (n1 == n2) {
                    result.add(n1)
                }
            }
        }

        return result.toIntArray()
    }

    private fun intersection2(
        nums1: IntArray,
        nums2: IntArray,
    ): IntArray {
        val result = mutableSetOf<Int>()

        nums2.sort()

        for (n1 in nums1) {
            val i2 = Arrays.binarySearch(nums2, n1)
            if (i2 >= 0) {
                result.add(n1)
            }
        }

        return result.toIntArray()
    }

    private fun intersection3(
        nums1: IntArray,
        nums2: IntArray,
    ): IntArray {
        val result = mutableSetOf<Int>()

        nums1.sort()
        nums2.sort()

        var i = 0
        var j = 0

        while (i < nums1.size && j < nums2.size) {
            when {
                nums1[i] < nums2[j] -> i++
                nums1[i] > nums2[j] -> j++
                else -> {
                    result.add(nums1[i])
                    i++
                    j++
                }
            }
        }

        return result.toIntArray()
    }
}
