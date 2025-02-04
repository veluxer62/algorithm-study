package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryNumberWithAlternatingBitsTest {
    private final Solution sut = new Solution();

    /*

    Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.



    Example 1:

    Input: n = 5
    Output: true
    Explanation: The binary representation of 5 is: 101
    Example 2:

    Input: n = 7
    Output: false
    Explanation: The binary representation of 7 is: 111.
    Example 3:

    Input: n = 11
    Output: false
    Explanation: The binary representation of 11 is: 1011.


    Constraints:

    1 <= n <= 231 - 1

     */

    @Test
    public void test_hasAlternatingBits() {
        var n = 5;
        var actual = sut.hasAlternatingBits(n);
        assertTrue(actual);

        n = 7;
        actual = sut.hasAlternatingBits(n);
        assertFalse(actual);

        n = 11;
        actual = sut.hasAlternatingBits(n);
        assertFalse(actual);
    }

    @Test
    public void test_hasAlternatingBits2() {
        var n = 5;
        var actual = sut.hasAlternatingBits2(n);
        assertTrue(actual);

        n = 7;
        actual = sut.hasAlternatingBits2(n);
        assertFalse(actual);

        n = 11;
        actual = sut.hasAlternatingBits2(n);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean hasAlternatingBits(int n) {
            var s = Integer.toBinaryString(n);

            for (var i = 0; i < s.length() - 1; i++) {
                var b = s.charAt(i);

                if (i > 0 && s.charAt(i - 1) == b || s.charAt(i + 1) == b) {
                    return false;
                }
            }

            return true;
        }

        boolean hasAlternatingBits2(int n) {
            /*
            n =         1 0 1 0 1 0 1 0
            n >> 1      0 1 0 1 0 1 0 1
            n ^ n>>1    1 1 1 1 1 1 1 1
            n           1 1 1 1 1 1 1 1
            n + 1     1 0 0 0 0 0 0 0 0
            n & (n+1)   0 0 0 0 0 0 0 0
            */

            n = n ^ (n>>1);
            return (n & n+1) == 0;
        }
    }
}
