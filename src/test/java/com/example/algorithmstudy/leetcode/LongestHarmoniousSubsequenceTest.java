package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestHarmoniousSubsequenceTest {
    private final Solution sut = new Solution();

    /*

    We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

    Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.



    Example 1:

    Input: nums = [1,3,2,2,5,2,3,7]

    Output: 5

    Explanation:

    The longest harmonious subsequence is [3,2,2,2,3].

    Example 2:

    Input: nums = [1,2,3,4]

    Output: 2

    Explanation:

    The longest harmonious subsequences are [1,2], [2,3], and [3,4], all of which have a length of 2.

    Example 3:

    Input: nums = [1,1,1,1]

    Output: 0

    Explanation:

    No harmonic subsequence exists.



    Constraints:

    1 <= nums.length <= 2 * 104
    -109 <= nums[i] <= 109

     */

    @Test
    public void test_findLHS() {
        var nums = new int[]{1,3,2,2,5,2,3,7};
        var actual = sut.findLHS(nums);
        assertEquals(5, actual);

        nums = new int[]{1,2,3,4};
        actual = sut.findLHS(nums);
        assertEquals(2, actual);

        nums = new int[]{1,1,1,1};
        actual = sut.findLHS(nums);
        assertEquals(0, actual);
    }

    private static class Solution {
        public int findLHS(int[] nums) {
            Map<Integer, Integer> freqMap = new HashMap<>();

            // 1. 각 숫자의 빈도 계산
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            int maxLength = 0;

            // 2. (num, num+1) 형태의 쌍을 찾고 최댓값 갱신
            for (int key : freqMap.keySet()) {
                if (freqMap.containsKey(key + 1)) {
                    maxLength = Math.max(maxLength, freqMap.get(key) + freqMap.get(key + 1));
                }
            }

            return maxLength;
        }
    }
}
