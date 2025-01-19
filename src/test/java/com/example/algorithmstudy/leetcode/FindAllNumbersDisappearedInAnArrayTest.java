package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllNumbersDisappearedInAnArrayTest {
    private final Solution sut = new Solution();

    /*

    Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.



    Example 1:

    Input: nums = [4,3,2,7,8,2,3,1]
    Output: [5,6]
    Example 2:

    Input: nums = [1,1]
    Output: [2]


    Constraints:

    n == nums.length
    1 <= n <= 105
    1 <= nums[i] <= n


    Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

     */

    @Test
    public void test_findDisappearedNumbers() {
        var nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        var actual = sut.findDisappearedNumbers(nums);
        assertEquals(
                List.of(5, 6),
                actual
        );

        nums = new int[]{1,1};
        actual = sut.findDisappearedNumbers(nums);
        assertEquals(
                List.of(2),
                actual
        );
    }

    @Test
    public void test_findDisappearedNumbers2() {
        var nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        var actual = sut.findDisappearedNumbers2(nums);
        assertEquals(
                List.of(5, 6),
                actual
        );

        nums = new int[]{1,1};
        actual = sut.findDisappearedNumbers2(nums);
        assertEquals(
                List.of(2),
                actual
        );
    }

    private static class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            var result = new ArrayList<Integer>();

            Arrays.sort(nums);

            var p = 0;

            for (var i = 1; i <= nums.length; i++) {
                var num = nums[p];

                while (num < i && p < nums.length - 1) {
                    num = nums[++p];
                }

                if (num != i) {
                    result.add(i);
                }
            }

            return result;
        }

        public List<Integer> findDisappearedNumbers2(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] > 0) {
                    nums[index] = -nums[index];
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    result.add(i + 1);
                }
            }

            return result;
        }
    }
}
