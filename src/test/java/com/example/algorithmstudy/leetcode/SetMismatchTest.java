package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SetMismatchTest {
    private final Solution sut = new Solution();

    /*

    You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

    You are given an integer array nums representing the data status of this set after the error.

    Find the number that occurs twice and the number that is missing and return them in the form of an array.



    Example 1:

    Input: nums = [1,2,2,4]
    Output: [2,3]
    Example 2:

    Input: nums = [1,1]
    Output: [1,2]


    Constraints:

    2 <= nums.length <= 104
    1 <= nums[i] <= 104

     */

    @Test
    public void test_findErrorNums() {
        var nums = new int[]{1, 2, 2, 4};
        var actual = sut.findErrorNums(nums);
        assertArrayEquals(
                new int[]{2, 3},
                actual
        );

        nums = new int[]{1, 1};
        actual = sut.findErrorNums(nums);
        assertArrayEquals(
                new int[]{1, 2},
                actual
        );

        nums = new int[]{2, 2};
        actual = sut.findErrorNums(nums);
        assertArrayEquals(
                new int[]{2, 1},
                actual
        );

        nums = new int[]{3, 2, 2};
        actual = sut.findErrorNums(nums);
        assertArrayEquals(
                new int[]{2, 1},
                actual
        );
    }

    @Test
    public void test_findErrorNums2() {
        var nums = new int[]{1, 2, 2, 4};
        var actual = sut.findErrorNums2(nums);
        assertArrayEquals(
                new int[]{2, 3},
                actual
        );

        nums = new int[]{1, 1};
        actual = sut.findErrorNums2(nums);
        assertArrayEquals(
                new int[]{1, 2},
                actual
        );

        nums = new int[]{2, 2};
        actual = sut.findErrorNums2(nums);
        assertArrayEquals(
                new int[]{2, 1},
                actual
        );

        nums = new int[]{3, 2, 2};
        actual = sut.findErrorNums2(nums);
        assertArrayEquals(
                new int[]{2, 1},
                actual
        );
    }

    private static class Solution {
        public int[] findErrorNums(int[] nums) {
            var map = new HashMap<Integer, Integer>();

            for (int i = 0; i < nums.length; i++) {
                var idx = i + 1;
                var num = nums[i];
                map.putIfAbsent(idx, map.getOrDefault(idx, 0));
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            var repetition = map.entrySet().stream().filter((it) -> it.getValue() > 1).findFirst().get().getKey();
            var loss = map.entrySet().stream().filter((it) -> it.getValue() == 0).findFirst().get().getKey();

            return new int[]{repetition, loss};
        }

        public int[] findErrorNums2(int[] nums) {
            int[] res = new int[2];
            int[] temp = new int[nums.length];

            for (int num : nums) {
                temp[num - 1] += 1;
            }

            for (int i = 0; i < nums.length; i++) {
                if (temp[i] == 0)
                    res[1] = i + 1;
                if (temp[i] == 2)
                    res[0] = i + 1;
            }
            return res;
        }
    }
}
