package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinSortColorsTest {
    /*
     * 빨간색을 0, 흰색을 1, 파란색을 2라 할 때 순서대로 인접하는 제자리 정렬을 수행하라.
     */

    @Test
    fun test_sortColors() {
        val nums = intArrayOf(2, 0, 2, 1, 1, 0)
        sortColors(nums)
        Assertions.assertArrayEquals(
            intArrayOf(0, 0, 1, 1, 2, 2),
            nums,
        )
    }

    private fun sortColors(nums: IntArray) {
        var red = 0
        var white = 0
        var blue = nums.size

        while (white < blue) {
            if (nums[white] < 1) {
                nums[white] = nums[red].also { nums[red] = nums[white] }

                red++
                white++
            } else if (nums[white] > 1) {
                blue--

                nums[white] = nums[blue].also { nums[blue] = nums[white] }
            } else {
                white++
            }
        }
    }
}
