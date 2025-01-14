package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CountingBitsTest {
    private final Solution sut = new Solution();

    /*

    Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.



    Example 1:

    Input: n = 2
    Output: [0,1,1]
    Explanation:
    0 --> 0
    1 --> 1
    2 --> 10
    Example 2:

    Input: n = 5
    Output: [0,1,1,2,1,2]
    Explanation:
    0 --> 0
    1 --> 1
    2 --> 10
    3 --> 11
    4 --> 100
    5 --> 101


    Constraints:

    0 <= n <= 105


    Follow up:

    It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
    Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?

     */

    @Test
    public void test_countBits() {
        var n = 2;
        var actual = sut.countBits(n);
        assertArrayEquals(
                new int[]{0, 1, 1},
                actual
        );

        n = 5;
        actual = sut.countBits(n);
        assertArrayEquals(
                new int[]{0, 1, 1, 2, 1, 2},
                actual
        );
    }

    private static class Solution {

        // 짝수: ans[i] = ans[i / 2]
        // 홀수: ans[i] = ans[i / 2] + 1
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                ans[i] = ans[i / 2] + (i % 2);
            }

            return ans;
        }
    }
}
