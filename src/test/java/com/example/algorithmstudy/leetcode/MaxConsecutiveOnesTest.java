package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxConsecutiveOnesTest {
    private final Solution sut = new Solution();

    /*

    Given a binary array nums, return the maximum number of consecutive 1's in the array.



    Example 1:

    Input: nums = [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
    Example 2:

    Input: nums = [1,0,1,1,0,1]
    Output: 2


    Constraints:

    1 <= nums.length <= 105
    nums[i] is either 0 or 1.

     */

    @Test
    public void test_findMaxConsecutiveOnes() {
        var nums = new int[]{1, 1, 0, 1, 1, 1};
        var actual = sut.findMaxConsecutiveOnes(nums);
        assertEquals(3, actual);

        nums = new int[]{1, 0, 1, 1, 0, 1};
        actual = sut.findMaxConsecutiveOnes(nums);
        assertEquals(2, actual);

        nums = new int[]{1};
        actual = sut.findMaxConsecutiveOnes(nums);
        assertEquals(1, actual);

        nums = new int[]{1, 0};
        actual = sut.findMaxConsecutiveOnes(nums);
        assertEquals(1, actual);
    }

    @Test
    public void test_findMaxConsecutiveOnes2() {
        var nums = new int[]{1, 1, 0, 1, 1, 1};
        var actual = sut.findMaxConsecutiveOnes2(nums);
        assertEquals(3, actual);

        nums = new int[]{1, 0, 1, 1, 0, 1};
        actual = sut.findMaxConsecutiveOnes2(nums);
        assertEquals(2, actual);

        nums = new int[]{1};
        actual = sut.findMaxConsecutiveOnes2(nums);
        assertEquals(1, actual);

        nums = new int[]{1, 0};
        actual = sut.findMaxConsecutiveOnes2(nums);
        assertEquals(1, actual);
    }

    private static class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            var result = new ArrayList<Integer>();

            var cnt = 0;
            for (int num : nums) {
                if (num == 1) {
                    cnt++;
                } else {
                    result.add(cnt);
                    cnt = 0;
                }
            }

            result.add(cnt);

            return result.stream().max(Integer::compareTo).get();
        }

        public int findMaxConsecutiveOnes2(int[] nums) {
            int maxCount = 0;
            int count = 0;

            for (int num : nums) {
                if (num == 0) {
                    count = 0;
                } else {
                    count++;
                    if (maxCount < count) {
                        maxCount = count;
                    }
                }
            }
            return maxCount;
        }
    }
}
