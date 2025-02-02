package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumProductOfThreeNumbersTest {
    private final Solution sut = new Solution();

    /*

    Given an integer array nums, find three numbers whose product is maximum and return the maximum product.



    Example 1:

    Input: nums = [1,2,3]
    Output: 6
    Example 2:

    Input: nums = [1,2,3,4]
    Output: 24
    Example 3:

    Input: nums = [-1,-2,-3]
    Output: -6


    Constraints:

    3 <= nums.length <= 104
    -1000 <= nums[i] <= 1000

     */

    @Test
    public void test_maximumProduct() {
        var nums = new int[]{1, 2, 3};
        var actual = sut.maximumProduct(nums);
        assertEquals(6, actual);

        nums = new int[]{1, 2, 3, 4};
        actual = sut.maximumProduct(nums);
        assertEquals(24, actual);

        nums = new int[]{-1, -2, -3};
        actual = sut.maximumProduct(nums);
        assertEquals(-6, actual);

        nums = new int[]{-100, -98, -1, 2, 3, 4};
        actual = sut.maximumProduct(nums);
        assertEquals(39200, actual);

        nums = new int[]{-100,-2,-3,1};
        actual = sut.maximumProduct(nums);
        assertEquals(300, actual);
    }

    private static class Solution {
        public int maximumProduct(int[] nums) {
            var max1 = Integer.MIN_VALUE;
            var max2 = Integer.MIN_VALUE;
            var max3 = Integer.MIN_VALUE;

            var min1 = Integer.MAX_VALUE;
            var min2 = Integer.MAX_VALUE;

            for (int num : nums) {
                if (num > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                } else if (num > max2) {
                    max3 = max2;
                    max2 = num;
                } else if (num > max3) {
                    max3 = num;
                }

                if (num < min1) {
                    min2 = min1;
                    min1 = num;
                } else if (num < min2) {
                    min2 = num;
                }
            }

            return Math.max(max1 * min1 * min2, max1 * max2 * max3);
        }

        public int maximumProduct2(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;

            int maxProduct1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
            int maxProduct2 = nums[0] * nums[1] * nums[n - 1];

            return Math.max(maxProduct1, maxProduct2);
        }
    }
}
