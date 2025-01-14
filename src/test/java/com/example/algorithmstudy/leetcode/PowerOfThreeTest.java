package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerOfThreeTest {
    private final Solution sut = new Solution();

    /*

    Given an integer n, return true if it is a power of three. Otherwise, return false.

    An integer n is a power of three, if there exists an integer x such that n == 3x.



    Example 1:

    Input: n = 27
    Output: true
    Explanation: 27 = 33
    Example 2:

    Input: n = 0
    Output: false
    Explanation: There is no x where 3x = 0.
    Example 3:

    Input: n = -1
    Output: false
    Explanation: There is no x where 3x = (-1).


    Constraints:

    -231 <= n <= 231 - 1


    Follow up: Could you solve it without loops/recursion?

     */

    @Test
    public void test_isPowerOfThree() {
        var n = 27;
        var actual = sut.isPowerOfThree(n);
        assertTrue(actual);

        n = 0;
        actual = sut.isPowerOfThree(n);
        assertFalse(actual);

        n = -1;
        actual = sut.isPowerOfThree(n);
        assertFalse(actual);

        n = 45;
        actual = sut.isPowerOfThree(n);
        assertFalse(actual);
    }

    @Test
    public void test_isPowerOfThree2() {
        var n = 27;
        var actual = sut.isPowerOfThree2(n);
        assertTrue(actual);

        n = 0;
        actual = sut.isPowerOfThree2(n);
        assertFalse(actual);

        n = -1;
        actual = sut.isPowerOfThree2(n);
        assertFalse(actual);

        n = 45;
        actual = sut.isPowerOfThree2(n);
        assertFalse(actual);
    }

    private static class Solution {
        // O(log3n)
        public boolean isPowerOfThree(int n) {
            if (n <= 0) return false;

            while (n > 1) {
                if (n % 3 != 0) return false;
                n /= 3;
            }

            return true;
        }

        // O(1)
        public boolean isPowerOfThree2(int n) {
            var max = 1162261467; // 32-bit integer에서 가장 큰 3의 거듭제곱 3^19
            return n > 0 && max % n == 0;
        }
    }
}
