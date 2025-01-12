package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UglyNumberTest {
    private final Solution sut = new Solution();

    /*

    An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.

    Given an integer n, return true if n is an ugly number.



    Example 1:

    Input: n = 6
    Output: true
    Explanation: 6 = 2 × 3
    Example 2:

    Input: n = 1
    Output: true
    Explanation: 1 has no prime factors.
    Example 3:

    Input: n = 14
    Output: false
    Explanation: 14 is not ugly since it includes the prime factor 7.


    Constraints:

    -231 <= n <= 231 - 1

     */

    @Test
    public void test_isUgly() {
        var n = 6;
        var actual = sut.isUgly(n);
        assertTrue(actual);

        n = 1;
        actual = sut.isUgly(n);
        assertTrue(actual);

        n = 14;
        actual = sut.isUgly(n);
        assertFalse(actual);
    }


    private static class Solution {
        public boolean isUgly(int n) {
            if (n <= 0) return false;

            while (n % 2 == 0) n /= 2;
            while (n % 3 == 0) n /= 3;
            while (n % 5 == 0) n /= 5;

            return n == 1;
        }
    }
}
