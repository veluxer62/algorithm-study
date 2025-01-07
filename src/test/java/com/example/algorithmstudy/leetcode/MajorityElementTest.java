package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MajorityElementTest {
    private final Solution sut = new Solution();

    /*

    Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



    Example 1:

    Input: nums = [3,2,3]
    Output: 3
    Example 2:

    Input: nums = [2,2,1,1,1,2,2]
    Output: 2


    Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109


    Follow-up: Could you solve the problem in linear time and in O(1) space?

     */

    @Test
    public void test_majorityElement() {
        var nums = new int[]{3, 2, 3};
        var actual = sut.majorityElement(nums);
        assertEquals(3, actual);

        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        actual = sut.majorityElement(nums);
        assertEquals(2, actual);
    }

    @Test
    public void test_majorityElement2() {
        var nums = new int[]{3, 2, 3};
        var actual = sut.majorityElement2(nums);
        assertEquals(3, actual);

        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        actual = sut.majorityElement2(nums);
        assertEquals(2, actual);
    }

    private static class Solution {
        public int majorityElement(int[] nums) {
            var map = new HashMap<Integer, Integer>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        }

        // 보이어-무어 다수결 투표 알고리즘(Boyer-Moore Majority Vote Algorithm)
        public int majorityElement2(int[] nums) {
            var candidate = 0;
            var count = 0;

            for (var num : nums) {
                if (count == 0) {
                    candidate = num;
                }

                count += (candidate == num) ? 1 : -1;
            }

            return candidate;
        }
    }
}
