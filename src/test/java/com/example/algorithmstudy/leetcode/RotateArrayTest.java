package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateArrayTest {
    private final Solution sut = new Solution();

    /*

    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



    Example 1:

    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
    Example 2:

    Input: nums = [-1,-100,3,99], k = 2
    Output: [3,99,-1,-100]
    Explanation:
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]


    Constraints:

    1 <= nums.length <= 105
    -231 <= nums[i] <= 231 - 1
    0 <= k <= 105


    Follow up:

    Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
    Could you do it in-place with O(1) extra space?

     */

    @Test
    public void test_rotate() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        var k = 3;
        sut.rotate(nums, k);
        assertArrayEquals(
                new int[]{5, 6, 7, 1, 2, 3, 4},
                nums
        );

        nums = new int[]{-1, -100, 3, 99};
        k = 2;
        sut.rotate(nums, k);
        assertArrayEquals(
                new int[]{3, 99, -1, -100},
                nums
        );
    }

    @Test
    public void test_rotate2() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        var k = 3;
        sut.rotate2(nums, k);
        assertArrayEquals(
                new int[]{5, 6, 7, 1, 2, 3, 4},
                nums
        );

        nums = new int[]{-1, -100, 3, 99};
        k = 2;
        sut.rotate2(nums, k);
        assertArrayEquals(
                new int[]{3, 99, -1, -100},
                nums
        );
    }

    @Test
    public void test_rotate3() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        var k = 3;
        sut.rotate3(nums, k);
        assertArrayEquals(
                new int[]{5, 6, 7, 1, 2, 3, 4},
                nums
        );

        nums = new int[]{-1, -100, 3, 99};
        k = 2;
        sut.rotate3(nums, k);
        assertArrayEquals(
                new int[]{3, 99, -1, -100},
                nums
        );
    }

    private static class Solution {
        public void rotate(int[] nums, int k) {
            var rotated = new int[nums.length];
            k = k % nums.length;

            for (int i = 0; i < nums.length; i++) {
                rotated[(i + k) % nums.length] = nums[i];
            }

            System.arraycopy(rotated, 0, nums, 0, rotated.length);
        }

        /*
         * * * * * # #
        [1,2,3,4,5,6,7]
        [6,7,1,2,3,4,5]
         # # * * * * *
             k
         */
        public void rotate2(int[] nums, int k) {
            k = k % nums.length;

            if (k != 0) {
                var temp = new int[nums.length];
                System.arraycopy(nums, nums.length - k, temp, 0, k);
                System.arraycopy(nums, 0, temp, k, nums.length - k);
                System.arraycopy(temp, 0, nums, 0, temp.length);
            }
        }

        /*
             k
        [7,6,5,4,3,2,1]
         # # * * * * *
        ↓
             k
        [6,7,1,2,3,4,5]
         # # * * * * *
         */
        public void rotate3(int[] nums, int k) {
            k = k % nums.length;

            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        private void reverse(int[] nums, int left, int right) {
            while (left < right) {
                var temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        private void print(int[] nums) {
            System.out.println("====");
            for (var num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("====");
        }
    }
}
