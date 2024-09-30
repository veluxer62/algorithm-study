package com.example.algorithmstudy

import org.junit.jupiter.api.Test

class KotlinThreeSumTest {
    /*
     * 배열을 입력받아 합으로 0을 만들 수 있는 3개의 엘리먼트를 출력하라
     */

    @Test
    fun test_threeSum() {
        val nums = intArrayOf(-1, 0, 1, 2, -1, -5)
        val actual = record { threeSum(nums) }

        assertContains(
            listOf(
                listOf(-1, 0, 1),
                listOf(-1, -1, 2),
            ),
            actual,
        )

        val nums2 = generateIntArray(2000)
        record { threeSum(nums2) }
    }

    @Test
    fun test_threeSum2() {
        val nums = intArrayOf(-1, 0, 1, 2, -1, -5)
        val actual = record { threeSum2(nums) }

        assertContains(
            listOf(
                listOf(-1, 0, 1),
                listOf(-1, -1, 2),
            ),
            actual,
        )

        val nums2 = generateIntArray(2000)
        record { threeSum2(nums2) }
    }

    private fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()

        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) continue

            for (j in i + 1 until nums.size - 1) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue

                for (k in j + 1 until nums.size) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(listOf(nums[i], nums[j], nums[k]))
                    }
                }
            }
        }

        return result
    }

    private fun threeSum2(nums: IntArray): List<List<Int>> {
        var left: Int
        var right: Int
        var sum: Int
        val result = mutableListOf<List<Int>>()

        for (i in 1 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) continue

            left = i + 1
            right = nums.size - 1

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right]

                if (sum < 0) {
                    left++
                } else if (sum > 0) {
                    right--
                } else {
                    result.add(listOf(nums[i], nums[left], nums[right]))

                    while (left < right && nums[left] == nums[left + 1]) left++
                    while (left < right && nums[right] == nums[right - 1]) right--

                    left++
                    right++
                }
            }
        }

        return result
    }
}
