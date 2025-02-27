package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TowSumTest {
    private final Solution sut = new Solution();

    /*

    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]


    Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.

     */

    @Test
    public void test_towSum() {
        var nums = new int[]{2, 7, 11, 15};
        var target = 9;
        var actual = sut.twoSum(nums, target);
        assertArrayEquals(
                new int[]{0, 1},
                actual
        );

        nums = new int[]{3, 2, 4};
        target = 6;
        actual = sut.twoSum(nums, target);
        assertArrayEquals(
                new int[]{1, 2},
                actual
        );

        nums = new int[]{3, 3};
        target = 6;
        actual = sut.twoSum(nums, target);
        assertArrayEquals(
                new int[]{0, 1},
                actual
        );
    }

    private static class Solution {
        public int[] twoSum(int[] nums, int target) {
            var results = new ArrayList<Integer>();

            for (var i = 0; i < nums.length; i++) {
                for (var j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        results.add(i);
                        results.add(j);
                    }
                }
            }

            return results.stream().mapToInt(i -> i).toArray();
        }
    }
}
