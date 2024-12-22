package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInsertPositionTest {
    private final Solution sut = new Solution();

    /*

    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.



    Example 1:

    Input: nums = [1,3,5,6], target = 5
    Output: 2
    Example 2:

    Input: nums = [1,3,5,6], target = 2
    Output: 1
    Example 3:

    Input: nums = [1,3,5,6], target = 7
    Output: 4


    Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums contains distinct values sorted in ascending order.
    -104 <= target <= 104

     */

    @Test
    public void test_searchInsert() {
        var nums = new int[]{1, 3, 5, 6};
        var target = 5;
        var actual = sut.searchInsert(nums, target);
        assertEquals(2, actual);

        nums = new int[]{1, 3, 5, 6};
        target = 2;
        actual = sut.searchInsert(nums, target);
        assertEquals(1, actual);

        nums = new int[]{1, 3, 5, 6};
        target = 7;
        actual = sut.searchInsert(nums, target);
        assertEquals(4, actual);

        nums = new int[]{1,3,5,6};
        target = 0;
        actual = sut.searchInsert(nums, target);
        assertEquals(0, actual);

        nums = new int[]{1};
        actual = sut.searchInsert(nums, target);
        assertEquals(0, actual);
    }

    private static class Solution {
        public int searchInsert(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= target) return i;
            }

            return nums.length;
        }
    }
}
