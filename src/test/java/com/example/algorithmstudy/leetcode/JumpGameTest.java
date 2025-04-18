package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JumpGameTest {
    private final Solution sut = new Solution();

    /*

    You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

    Return true if you can reach the last index, or false otherwise.



    Example 1:

    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    Example 2:

    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


    Constraints:

    1 <= nums.length <= 104
    0 <= nums[i] <= 105

     */

    @Test
    public void test_canJump() {
        int[] nums = {2, 3, 1, 1, 4};
        var actual = sut.canJump(nums);
        assertTrue(actual);

        nums = new int[]{3, 2, 1, 0, 4};
        actual = sut.canJump(nums);
        assertFalse(actual);

        nums = new int[]{0};
        actual = sut.canJump(nums);
        assertTrue(actual);

        nums = new int[]{2, 0, 0};
        actual = sut.canJump(nums);
        assertTrue(actual);

        nums = new int[]{2, 5, 0, 0};
        actual = sut.canJump(nums);
        assertTrue(actual);

        nums = new int[]{3, 0, 8, 2, 0, 0, 1};
        actual = sut.canJump(nums);
        assertTrue(actual);
    }

    @Test
    public void test_canJump2() {
        int[] nums = {2, 3, 1, 1, 4};
        var actual = sut.canJump2(nums);
        assertTrue(actual);

        nums = new int[]{3, 2, 1, 0, 4};
        actual = sut.canJump2(nums);
        assertFalse(actual);

        nums = new int[]{0};
        actual = sut.canJump2(nums);
        assertTrue(actual);

        nums = new int[]{2, 0, 0};
        actual = sut.canJump2(nums);
        assertTrue(actual);

        nums = new int[]{2, 5, 0, 0};
        actual = sut.canJump2(nums);
        assertTrue(actual);

        nums = new int[]{3, 0, 8, 2, 0, 0, 1};
        actual = sut.canJump2(nums);
        assertTrue(actual);
    }

    @Test
    public void test_canJump3() {
        int[] nums = {2, 3, 1, 1, 4};
        var actual = sut.canJump3(nums);
        assertTrue(actual);

        nums = new int[]{3, 2, 1, 0, 4};
        actual = sut.canJump3(nums);
        assertFalse(actual);

        nums = new int[]{0};
        actual = sut.canJump3(nums);
        assertTrue(actual);

        nums = new int[]{2, 0, 0};
        actual = sut.canJump3(nums);
        assertTrue(actual);

        nums = new int[]{2, 5, 0, 0};
        actual = sut.canJump3(nums);
        assertTrue(actual);

        nums = new int[]{3, 0, 8, 2, 0, 0, 1};
        actual = sut.canJump3(nums);
        assertTrue(actual);
    }

    private static class Solution {
        public boolean canJump(int[] nums) {
            var gas = 0;
            for (var num : nums) {
                if (gas < 0)
                    return false;
                else if (num > gas)
                    gas = num;

                gas--;
            }

            return true;
        }

        public boolean canJump2(int[] nums) {
            var goal = nums.length - 1;

            for (int i = nums.length - 2; i >= 0; i--) {
                if (i + nums[i] >= goal) {
                    goal = i;
                }
            }

            return goal == 0;
        }

        public boolean canJump3(int[] nums) {
            var reachable = 0;

            for (int i = 0; i < nums.length; i++) {
                if (i > reachable) return false;
                reachable = Math.max(reachable, i + nums[i]);
            }

            return true;
        }
    }
}
