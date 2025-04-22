package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductOfArrayExceptSelfTest {
    private final Solution sut = new Solution();

    /*

    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    You must write an algorithm that runs in O(n) time and without using the division operation.



    Example 1:

    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]
    Example 2:

    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]


    Constraints:

    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.


    Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

     */

    @Test
    public void test_productExceptSelf() {
        int[] nums = {1, 2, 3, 4};
        var actual = sut.productExceptSelf(nums);
        assertArrayEquals(
                new int[]{24, 12, 8, 6},
                actual
        );

        nums = new int[]{-1, 1, 0, -3, 3};
        actual = sut.productExceptSelf(nums);
        assertArrayEquals(
                new int[]{0, 0, 9, 0, 0},
                actual
        );
    }

    private static class Solution {
        public int[] productExceptSelf(int[] nums) {
            var n = nums.length;
            int[] res = new int[n];
            Arrays.fill(res, 1);

            var curr = 1;
            for (int i = 0; i < n; i++) {
                res[i] *= curr;
                curr *= nums[i];
            }

            curr = 1;
            for (int i = n - 1; i >= 0; i--) {
                res[i] *= curr;
                curr *= nums[i];
            }

            return res;
        }
    }
}
