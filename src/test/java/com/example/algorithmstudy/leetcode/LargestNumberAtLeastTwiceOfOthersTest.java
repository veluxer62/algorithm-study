package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestNumberAtLeastTwiceOfOthersTest {
    private final Solution sut = new Solution();

    /*

    You are given an integer array nums where the largest integer is unique.

    Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.



    Example 1:

    Input: nums = [3,6,1,0]
    Output: 1
    Explanation: 6 is the largest integer.
    For every other number in the array x, 6 is at least twice as big as x.
    The index of value 6 is 1, so we return 1.
    Example 2:

    Input: nums = [1,2,3,4]
    Output: -1
    Explanation: 4 is less than twice the value of 3, so we return -1.


    Constraints:

    2 <= nums.length <= 50
    0 <= nums[i] <= 100
    The largest element in nums is unique.

     */

    @Test
    public void test_dominantIndex() {
        var nums = new int[]{3, 6, 1, 0};
        var actual = sut.dominantIndex(nums);
        assertEquals(1, actual);

        nums = new int[]{1, 2, 3, 4};
        actual = sut.dominantIndex(nums);
        assertEquals(-1, actual);

        nums = new int[]{0, 0, 0, 1};
        actual = sut.dominantIndex(nums);
        assertEquals(3, actual);
    }

    @Test
    public void test_dominantIndex2() {
        var nums = new int[]{3, 6, 1, 0};
        var actual = sut.dominantIndex2(nums);
        assertEquals(1, actual);

        nums = new int[]{1, 2, 3, 4};
        actual = sut.dominantIndex2(nums);
        assertEquals(-1, actual);

        nums = new int[]{0, 0, 0, 1};
        actual = sut.dominantIndex2(nums);
        assertEquals(3, actual);
    }

    private static class Solution {
        public int dominantIndex(int[] nums) {
            var pq = new PriorityQueue<Map<Integer, Integer>>(
                    (map1, map2) -> {
                        Integer key1 = map1.keySet().iterator().next();
                        Integer key2 = map2.keySet().iterator().next();
                        return key2.compareTo(key1);
                    }
            );

            for (var i = 0; i < nums.length; i++) {
                var num = nums[i];
                pq.add(Map.of(num, i));
            }

            var max = pq.poll().entrySet().iterator().next();
            var second = pq.poll().keySet().iterator().next();

            if (max.getKey() >= second * 2) {
                return max.getValue();
            }

            return -1;
        }

        public int dominantIndex2(int[] nums) {
            int max = -1, index = -1, second = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    second = max;
                    max = nums[i];
                    index = i;
                } else if (nums[i] > second)
                    second = nums[i];
            }
            return second * 2 <= max ? index : -1;
        }
    }
}
