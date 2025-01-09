package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsDuplicateTest {
    private final Solution sut = new Solution();

    /*

    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



    Example 1:

    Input: nums = [1,2,3,1]

    Output: true

    Explanation:

    The element 1 occurs at the indices 0 and 3.

    Example 2:

    Input: nums = [1,2,3,4]

    Output: false

    Explanation:

    All elements are distinct.

    Example 3:

    Input: nums = [1,1,1,3,3,4,3,2,4,2]

    Output: true



    Constraints:

    1 <= nums.length <= 105
    -109 <= nums[i] <= 109

     */

    @Test
    public void test_containsDuplicate() {
        var nums = new int[]{1, 2, 3, 1};
        var actual = sut.containsDuplicate(nums);
        assertTrue(actual);

        nums = new int[]{1, 2, 3, 4};
        actual = sut.containsDuplicate(nums);
        assertFalse(actual);

        nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        actual = sut.containsDuplicate(nums);
        assertTrue(actual);
    }

    private static class Solution {
        public boolean containsDuplicate(int[] nums) {
            var set = new HashSet<Integer>();
            for (int num : nums) {
                if (set.contains(num)) {
                    return true;
                }

                set.add(num);
            }

            return false;
        }
    }
}
