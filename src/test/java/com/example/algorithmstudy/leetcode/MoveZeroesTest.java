package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZeroesTest {
    private final Solution sut = new Solution();

    /*

    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.



    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Example 2:

    Input: nums = [0]
    Output: [0]


    Constraints:

    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1


    Follow up: Could you minimize the total number of operations done?

     */

    @Test
    public void test_moveZeroes() {
        var nums = new int[]{0, 1, 0, 3, 12};
        sut.moveZeroes(nums);
        assertArrayEquals(
                new int[]{1, 3, 12, 0, 0},
                nums
        );

        nums = new int[]{0};
        sut.moveZeroes(nums);
        assertArrayEquals(
                new int[]{0},
                nums
        );
    }

    @Test
    public void test_moveZeroes2() {
        var nums = new int[]{0, 1, 0, 3, 12};
        sut.moveZeroes2(nums);
        assertArrayEquals(
                new int[]{1, 3, 12, 0, 0},
                nums
        );

        nums = new int[]{0};
        sut.moveZeroes2(nums);
        assertArrayEquals(
                new int[]{0},
                nums
        );
    }

    private static class Solution {
        public void moveZeroes(int[] nums) {
            var i = 0;
            var j = 1;

            while (j < nums.length) {
                if (nums[i] != 0) {
                    i++;
                    j++;
                } else if (nums[i] == 0 && nums[j] != 0) {
                    var temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;

                    i++;
                    j++;
                } else if (nums[j] == 0) {
                    j++;
                }
            }
        }

        public void moveZeroes2(int[] nums) {
            int nonZeroIndex = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[nonZeroIndex] = nums[i];
                    nonZeroIndex++;
                }
            }

            for (int i = nonZeroIndex; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
}
