package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
    private final Solution sut = new Solution();

    /*

    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

    You must write an algorithm with O(log n) runtime complexity.



    Example 1:

    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4
    Example 2:

    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
    Explanation: 2 does not exist in nums so return -1


    Constraints:

    1 <= nums.length <= 104
    -104 < nums[i], target < 104
    All the integers in nums are unique.
    nums is sorted in ascending order.

     */

    @Test
    public void test_search() {
        var nums = new int[]{-1, 0, 3, 5, 9, 12};
        var actual = sut.search(nums, 9);
        assertEquals(4, actual);

        nums = new int[]{-1, 0, 3, 5, 9, 12};
        actual = sut.search(nums, 2);
        assertEquals(-1, actual);

        nums = new int[]{5};
        actual = sut.search(nums, 5);
        assertEquals(0, actual);
    }

    private static class Solution {
        public int search(int[] nums, int target) {
            var left = 0;
            var right = nums.length - 1;

            while (left <= right) {
                var mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }

            return -1;
        }
    }
}
