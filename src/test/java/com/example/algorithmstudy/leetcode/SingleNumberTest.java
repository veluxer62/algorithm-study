package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleNumberTest {
    private final Solution sut = new Solution();

    /*

    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    You must implement a solution with a linear runtime complexity and use only constant extra space.



    Example 1:

    Input: nums = [2,2,1]
    Output: 1
    Example 2:

    Input: nums = [4,1,2,1,2]
    Output: 4
    Example 3:

    Input: nums = [1]
    Output: 1


    Constraints:

    1 <= nums.length <= 3 * 104
    -3 * 104 <= nums[i] <= 3 * 104
    Each element in the array appears twice except for one element which appears only once.

     */

    @Test
    public void test_singleNumber() {
        var nums = new int[]{2, 2, 1};
        var actual = sut.singleNumber(nums);
        assertEquals(1, actual);

        nums = new int[]{4, 1, 2, 1, 2};
        actual = sut.singleNumber(nums);
        assertEquals(4, actual);

        nums = new int[]{1};
        actual = sut.singleNumber(nums);
        assertEquals(1, actual);
    }

    private static class Solution {
        public int singleNumber(int[] nums) {
            var map = new HashMap<Integer, Integer>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            return map.keySet().stream().filter(key -> map.get(key) == 1).findFirst().get();
        }
    }
}
