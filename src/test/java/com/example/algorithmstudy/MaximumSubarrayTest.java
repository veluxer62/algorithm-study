package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubarrayTest {
    private final Solution sut = new Solution();

    /*
     * 연속된 값으로 구성된 가장 큰 서브 배열을 찾아 합을 리턴하라.
     */

    @Test
    public void test_maxSubArray() {
        var nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -6, 4};
        var actual = sut.maxSubArray(nums);
        assertEquals(6, actual);
    }

    @Test
    public void test_maxSubArray2() {
        var nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -6, 4};
        var actual = sut.maxSubArray2(nums);
        assertEquals(6, actual);
    }

    @Test
    public void test_maxSubArray3() {
        var nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -6, 4};
        var actual = sut.maxSubArray3(nums);
        assertEquals(6, actual);
    }

    private static class Solution {
        public int maxSubArray(int[] nums) {
            var sums = new ArrayList<>(List.of(nums[0]));

            for (var i = 1; i < nums.length; i++) {
                sums.add(nums[i] + (sums.get(i - 1) > 0 ? sums.get(i - 1) : 0));
            }

            return Collections.max(sums);
        }

        public int maxSubArray2(int[] nums) {
            for (var i = 1; i < nums.length; i++) {
                nums[i] += Math.max(nums[i - 1], 0);
            }

            return Arrays.stream(nums).max().getAsInt();
        }

        public int maxSubArray3(int[] nums) {
            var currentSum = 0;
            var bestSum = Integer.MIN_VALUE;

            for (var num : nums) {
                currentSum = Math.max(num, currentSum + num);
                bestSum = Math.max(bestSum, currentSum);
            }

            return bestSum;
        }
    }
}
