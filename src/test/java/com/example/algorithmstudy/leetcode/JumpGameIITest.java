package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpGameIITest {
    private final Solution sut = new Solution();

    /*

    You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

    Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

    0 <= j <= nums[i] and
    i + j < n
    Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



    Example 1:

    Input: nums = [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
    Example 2:

    Input: nums = [2,3,0,1,4]
    Output: 2


    Constraints:

    1 <= nums.length <= 104
    0 <= nums[i] <= 1000
    It's guaranteed that you can reach nums[n - 1].

     */

    @Test
    public void test_jump() {
        int[] nums = {2, 3, 1, 1, 4};
        var actual = sut.jump(nums);
        assertEquals(2, actual);

        nums = new int[]{2, 3, 0, 1, 4};
        actual = sut.jump(nums);
        assertEquals(2, actual);

        nums = new int[]{0};
        actual = sut.jump(nums);
        assertEquals(0, actual);

        nums = new int[]{1, 2, 1, 1, 1};
        actual = sut.jump(nums);
        assertEquals(3, actual);

        nums = new int[]{2, 1};
        actual = sut.jump(nums);
        assertEquals(1, actual);

        nums = new int[]{1};
        actual = sut.jump(nums);
        assertEquals(0, actual);
    }

    @Test
    public void test_jump2() {
        int[] nums = {2, 3, 1, 1, 4};
        var actual = sut.jump2(nums);
        assertEquals(2, actual);

        nums = new int[]{2, 3, 0, 1, 4};
        actual = sut.jump2(nums);
        assertEquals(2, actual);

        nums = new int[]{0};
        actual = sut.jump2(nums);
        assertEquals(0, actual);

        nums = new int[]{1, 2, 1, 1, 1};
        actual = sut.jump2(nums);
        assertEquals(3, actual);

        nums = new int[]{2, 1};
        actual = sut.jump2(nums);
        assertEquals(1, actual);

        nums = new int[]{1};
        actual = sut.jump2(nums);
        assertEquals(0, actual);
    }

    private static class Solution {
        public int jump(int[] nums) {
            int near = 0, far = 0, jump = 0;

            while (far < nums.length - 1) {
                int farthest = 0;
                for (int i = near; i <= far; i++) {
                    farthest = Math.max(farthest, i + nums[i]);
                }

                near = far + 1;
                far = farthest;
                jump++;
            }

            return jump;
        }

        public int jump2(int[] nums) {
            int jump = 0, end = 0, farthest = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);

                if (i == end) {
                    jump++;
                    end = farthest;
                }
            }

            return jump;
        }
    }
}
