package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsDuplicateIITest {
    private final Solution sut = new Solution();

    /*

    Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



    Example 1:

    Input: nums = [1,2,3,1], k = 3
    Output: true
    Example 2:

    Input: nums = [1,0,1,1], k = 1
    Output: true
    Example 3:

    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false


    Constraints:

    1 <= nums.length <= 105
    -109 <= nums[i] <= 109
    0 <= k <= 105

     */

    @Test
    public void test_containsNearbyDuplicate() {
        var nums = new int[]{1, 2, 3, 1};
        var k = 3;
        var actual = sut.containsNearbyDuplicate(nums, k);
        assertTrue(actual);

        nums = new int[]{1, 0, 1, 1};
        k = 1;
        actual = sut.containsNearbyDuplicate(nums, k);
        assertTrue(actual);

        nums = new int[]{1, 2, 3, 1, 2, 3};
        k = 2;
        actual = sut.containsNearbyDuplicate(nums, k);
        assertFalse(actual);

        nums = new int[]{99, 99};
        k = 2;
        actual = sut.containsNearbyDuplicate(nums, k);
        assertTrue(actual);
    }

    private static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            var map = new HashMap<Integer, Integer>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    if (i - map.get(nums[i]) <= k) {
                        return true;
                    }
                }
                map.put(nums[i], i);
            }

            return false;
        }
    }
}
