package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerOfFourTest {
    private final Solution sut = new Solution();

    /*

    Given an integer n, return true if it is a power of four. Otherwise, return false.

    An integer n is a power of four, if there exists an integer x such that n == 4x.



    Example 1:

    Input: n = 16
    Output: true
    Example 2:

    Input: n = 5
    Output: false
    Example 3:

    Input: n = 1
    Output: true


    Constraints:

    -231 <= n <= 231 - 1


    Follow up: Could you solve it without loops/recursion?

     */

    @Test
    public void test_isPowerOfFour() {
        var n = 16;
        var actual = sut.isPowerOfFour(n);
        assertTrue(actual);

        n = 5;
        actual = sut.isPowerOfFour(n);
        assertFalse(actual);

        n = 1;
        actual = sut.isPowerOfFour(n);
        assertTrue(actual);

        n = -2147483648;
        actual = sut.isPowerOfFour(n);
        assertFalse(actual);

        n = 0;
        actual = sut.isPowerOfFour(n);
        assertFalse(actual);
    }

    @Test
    public void test_isPowerOfFour2() {
        var n = 16;
        var actual = sut.isPowerOfFour2(n);
        assertTrue(actual);

        n = 5;
        actual = sut.isPowerOfFour2(n);
        assertFalse(actual);

        n = 1;
        actual = sut.isPowerOfFour2(n);
        assertTrue(actual);

        n = -2147483648;
        actual = sut.isPowerOfFour2(n);
        assertFalse(actual);

        n = 0;
        actual = sut.isPowerOfFour2(n);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean isPowerOfFour(int n) {
            if (n <= 0) return false;

            while(n > 1) {
                if (n % 4 != 0) return false;
                n /= 4;
            }

            return true;
        }

        public boolean isPowerOfFour2(int n) {
            if (n <= 0) {
                return false;
            }

            // 4의 거듭제곱은 2의 거듭제곱의 하위집합이므로 제외
            // 2의 거듭제곱 확인 (n & (n - 1) == 0)
            if ((n & (n - 1)) != 0) {
                return false;
            }

            // 4의 거듭제곱 비트 패턴: 4의 거듭제곱은 홀수 위치에서만 비트가 1이 됨.
            // 1 = 0001
            // 4 = 0100
            // 16 = 0001 0000
            // 이를 확인하기 위해 0xAAAAAAAA (짝수 비트가 모두 1인 마스크)와 AND 연산 후 결과가 0인지 확인.
            return (n & 0xAAAAAAAA) == 0;
        }
    }
}
