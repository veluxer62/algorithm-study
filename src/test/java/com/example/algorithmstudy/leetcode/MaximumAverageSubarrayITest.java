package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumAverageSubarrayITest {
    private final Solution sut = new Solution();

    /*

    You are given an integer array nums consisting of n elements, and an integer k.

    Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.



    Example 1:

    Input: nums = [1,12,-5,-6,50,3], k = 4
    Output: 12.75000
    Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
    Example 2:

    Input: nums = [5], k = 1
    Output: 5.00000


    Constraints:

    n == nums.length
    1 <= k <= n <= 105
    -104 <= nums[i] <= 104

     */

    @Test
    public void test_findMaxAverage() {
        var nums = new int[]{1, 12, -5, -6, 50, 3};
        var k = 4;
        var actual = sut.findMaxAverage(nums, k);
        assertEquals(12.75d, actual);

        nums = new int[]{5};
        k = 1;
        actual = sut.findMaxAverage(nums, k);
        assertEquals(5d, actual);

        nums = new int[]{-1};
        k = 1;
        actual = sut.findMaxAverage(nums, k);
        assertEquals(-1d, actual);

        nums = new int[]{8860, -853, 6534, 4477, -4589, 8646, -6155, -5577, -1656, -5779, -2619, -8604, -1358, -8009, 4983, 7063, 3104, -1560, 4080, 2763, 5616, -2375, 2848, 1394, -7173, -5225, -8244, -809, 8025, -4072, -4391, -9579, 1407, 6700, 2421, -6685, 5481, -1732, -8892, -6645, 3077, 3287, -4149, 8701, -4393, -9070, -1777, 2237, -3253, -506, -4931, -7366, -8132, 5406, -6300, -275, -1908, 67, 3569, 1433, -7262, -437, 8303, 4498, -379, 3054, -6285, 4203, 6908, 4433, 3077, 2288, 9733, -8067, 3007, 9725, 9669, 1362, -2561, -4225, 5442, -9006, -429, 160, -9234, -4444, 3586, -5711, -9506, -79, -4418, -4348, -5891};
        k = 93;
        actual = sut.findMaxAverage(nums, k);
        assertEquals(-594.5806451612904, actual);
    }

    @Test
    public void test_findMaxAverage2() {
        var nums = new int[]{1, 12, -5, -6, 50, 3};
        var k = 4;
        var actual = sut.findMaxAverage2(nums, k);
        assertEquals(12.75d, actual);

        nums = new int[]{5};
        k = 1;
        actual = sut.findMaxAverage2(nums, k);
        assertEquals(5d, actual);

        nums = new int[]{-1};
        k = 1;
        actual = sut.findMaxAverage2(nums, k);
        assertEquals(-1d, actual);

        nums = new int[]{8860, -853, 6534, 4477, -4589, 8646, -6155, -5577, -1656, -5779, -2619, -8604, -1358, -8009, 4983, 7063, 3104, -1560, 4080, 2763, 5616, -2375, 2848, 1394, -7173, -5225, -8244, -809, 8025, -4072, -4391, -9579, 1407, 6700, 2421, -6685, 5481, -1732, -8892, -6645, 3077, 3287, -4149, 8701, -4393, -9070, -1777, 2237, -3253, -506, -4931, -7366, -8132, 5406, -6300, -275, -1908, 67, 3569, 1433, -7262, -437, 8303, 4498, -379, 3054, -6285, 4203, 6908, 4433, 3077, 2288, 9733, -8067, 3007, 9725, 9669, 1362, -2561, -4225, 5442, -9006, -429, 160, -9234, -4444, 3586, -5711, -9506, -79, -4418, -4348, -5891};
        k = 93;
        actual = sut.findMaxAverage2(nums, k);
        assertEquals(-594.5806451612904, actual);
    }

    private static class Solution {
        // O(n2)
        public double findMaxAverage(int[] nums, int k) {
            double max = Double.NEGATIVE_INFINITY;

            for (var i = 0; i < nums.length - k + 1; i++) {
                double sum = nums[i];
                for (int j = i + 1; j < i + k; j++) {
                    sum += nums[j];
                }
                max = Math.max(max, sum);
            }

            return max / k;
        }

        // O(n)
        public double findMaxAverage2(int[] nums, int k) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }

            int maxSum = sum;
            for (int i = k; i < nums.length; i++) {
                sum += nums[i] - nums[i - k];
                maxSum = Math.max(maxSum, sum);
            }
            return (double) maxSum / k;
        }
    }
}
