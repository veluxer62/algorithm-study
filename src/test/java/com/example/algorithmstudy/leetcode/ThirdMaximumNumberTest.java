package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThirdMaximumNumberTest {
    private final Solution sut = new Solution();

    /*

    Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.



    Example 1:

    Input: nums = [3,2,1]
    Output: 1
    Explanation:
    The first distinct maximum is 3.
    The second distinct maximum is 2.
    The third distinct maximum is 1.
    Example 2:

    Input: nums = [1,2]
    Output: 2
    Explanation:
    The first distinct maximum is 2.
    The second distinct maximum is 1.
    The third distinct maximum does not exist, so the maximum (2) is returned instead.
    Example 3:

    Input: nums = [2,2,3,1]
    Output: 1
    Explanation:
    The first distinct maximum is 3.
    The second distinct maximum is 2 (both 2's are counted together since they have the same value).
    The third distinct maximum is 1.


    Constraints:

    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1


    Follow up: Can you find an O(n) solution?

     */

    @Test
    public void test_thirdMax() {
        var nums = new int[]{3, 2, 1};
        var actual = sut.thirdMax(nums);
        assertEquals(1, actual);

        nums = new int[]{1, 2};
        actual = sut.thirdMax(nums);
        assertEquals(2, actual);

        nums = new int[]{2, 2, 3, 1};
        actual = sut.thirdMax(nums);
        assertEquals(1, actual);
    }

    @Test
    public void test_thirdMax2() {
        var nums = new int[]{3, 2, 1};
        var actual = sut.thirdMax2(nums);
        assertEquals(1, actual);

        nums = new int[]{1, 2};
        actual = sut.thirdMax2(nums);
        assertEquals(2, actual);

        nums = new int[]{2, 2, 3, 1};
        actual = sut.thirdMax2(nums);
        assertEquals(1, actual);
    }

    @Test
    public void test_thirdMax3() {
        var nums = new int[]{3, 2, 1};
        var actual = sut.thirdMax3(nums);
        assertEquals(1, actual);

        nums = new int[]{1, 2};
        actual = sut.thirdMax3(nums);
        assertEquals(2, actual);

        nums = new int[]{2, 2, 3, 1};
        actual = sut.thirdMax3(nums);
        assertEquals(1, actual);
    }

    private static class Solution {
        public int thirdMax(int[] nums) {
            var queue = new PriorityQueue<Integer>(Comparator.reverseOrder());

            for (int num : nums) {
                if (!queue.contains(num)) {
                    queue.add(num);
                }
            }

            var result = queue.poll();

            if (queue.size() > 1) {
                queue.poll();
                result = queue.poll();
            }

            return result;
        }

        public int thirdMax2(int[] nums) {
            TreeSet<Integer> distinctNumbers = new TreeSet<>();

            for (int num : nums) {
                distinctNumbers.add(num);

                if (distinctNumbers.size() > 3) {
                    distinctNumbers.pollFirst();
                }
            }

            if (distinctNumbers.size() < 3) {
                return distinctNumbers.last();
            }

            return distinctNumbers.first();
        }

        public int thirdMax3(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length, cnt = 1;

            for (int i = n - 1; i >= 1; i--) {
                if (nums[i] != nums[i - 1])
                    cnt++;
                if (cnt == 3)
                    return nums[i - 1];
            }

            return nums[n - 1];
        }
    }
}
