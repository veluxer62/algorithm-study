package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestContinuousIncreasingSubsequenceTest {
    private final Solution sut = new Solution();

    /*

    Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.

    A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].



    Example 1:

    Input: nums = [1,3,5,4,7]
    Output: 3
    Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
    Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
    4.
    Example 2:

    Input: nums = [2,2,2,2,2]
    Output: 1
    Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
    increasing.


    Constraints:

    1 <= nums.length <= 104
    -109 <= nums[i] <= 109

     */

    @Test
    public void test_findLengthOfLCIS() {
        var nums = new int[]{1, 3, 5, 4, 7};
        var actual = sut.findLengthOfLCIS(nums);
        assertEquals(3, actual);

        nums = new int[]{2, 2, 2, 2, 2};
        actual = sut.findLengthOfLCIS(nums);
        assertEquals(1, actual);

        nums = new int[]{1, 3, 5, 7};
        actual = sut.findLengthOfLCIS(nums);
        assertEquals(4, actual);

        nums = new int[]{1};
        actual = sut.findLengthOfLCIS(nums);
        assertEquals(1, actual);
    }

    @Test
    public void test_findLengthOfLCIS2() {
        var nums = new int[]{1, 3, 5, 4, 7};
        var actual = sut.findLengthOfLCIS2(nums);
        assertEquals(3, actual);

        nums = new int[]{2, 2, 2, 2, 2};
        actual = sut.findLengthOfLCIS2(nums);
        assertEquals(1, actual);

        nums = new int[]{1, 3, 5, 7};
        actual = sut.findLengthOfLCIS2(nums);
        assertEquals(4, actual);

        nums = new int[]{1};
        actual = sut.findLengthOfLCIS2(nums);
        assertEquals(1, actual);
    }

    private static class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums.length < 2) return 1;

            var max = -1;
            var count = 1;

            for (var i = 0; i < nums.length - 1; i++) {
                var curr = nums[i];
                var next = nums[i + 1];


                if (curr < next) {
                    count++;
                } else {
                    count = 1;
                }

                max = Math.max(max, count);
            }

            return max;
        }

        public int findLengthOfLCIS2(int[] nums) {
            var max = -1;
            var count = 1;

            for (var i = 0; i < nums.length - 1; i++) {
                var curr = nums[i];
                var next = nums[i + 1];


                if (curr < next) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }

            }

            return Math.max(max, count);
        }
    }
}
