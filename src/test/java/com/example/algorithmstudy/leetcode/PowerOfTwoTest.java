package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerOfTwoTest {
    private final Solution sut = new Solution();

    /*

    Given an integer n, return true if it is a power of two. Otherwise, return false.

    An integer n is a power of two, if there exists an integer x such that n == 2x.



    Example 1:

    Input: n = 1
    Output: true
    Explanation: 20 = 1
    Example 2:

    Input: n = 16
    Output: true
    Explanation: 24 = 16
    Example 3:

    Input: n = 3
    Output: false


    Constraints:

    -231 <= n <= 231 - 1


    Follow up: Could you solve it without loops/recursion?

     */

    @Test
    public void test_isPowerOfTwo() {
        var n = 1;
        var actual = sut.isPowerOfTwo(n);
        assertTrue(actual);

        n = 16;
        actual = sut.isPowerOfTwo(n);
        assertTrue(actual);

        n = 3;
        actual = sut.isPowerOfTwo(n);
        assertFalse(actual);

        n = 6;
        actual = sut.isPowerOfTwo(n);
        assertFalse(actual);

        n = 0;
        actual = sut.isPowerOfTwo(n);
        assertFalse(actual);

        n = -16;
        actual = sut.isPowerOfTwo(n);
        assertFalse(actual);
    }

    @Test
    public void test_isPowerOfTwo2() {
        var n = 1;
        var actual = sut.isPowerOfTwo2(n);
        assertTrue(actual);

        n = 16;
        actual = sut.isPowerOfTwo2(n);
        assertTrue(actual);

        n = 3;
        actual = sut.isPowerOfTwo2(n);
        assertFalse(actual);

        n = 6;
        actual = sut.isPowerOfTwo2(n);
        assertFalse(actual);

        n = 0;
        actual = sut.isPowerOfTwo2(n);
        assertFalse(actual);

        n = -16;
        actual = sut.isPowerOfTwo2(n);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) return false;

            while (n > 1) {
                if (n % 2 != 0) return false;
                n = n / 2;
            }

            return true;
        }

        // n = 16 (10000), n - 1 = 15 (01111), n & (n - 1) = 0.
        // n = 3 (11), n - 1 = 2 (10), n & (n - 1) = 2.
        public boolean isPowerOfTwo2(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
}
