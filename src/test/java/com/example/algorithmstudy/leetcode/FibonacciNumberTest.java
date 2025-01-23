package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciNumberTest {
    private final Solution sut = new Solution();

    /*

    The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

    F(0) = 0, F(1) = 1
    F(n) = F(n - 1) + F(n - 2), for n > 1.
    Given n, calculate F(n).



    Example 1:

    Input: n = 2
    Output: 1
    Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
    Example 2:

    Input: n = 3
    Output: 2
    Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
    Example 3:

    Input: n = 4
    Output: 3
    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.


    Constraints:

    0 <= n <= 30

     */

    @Test
    public void test_fib() {
        var n = 2;
        var actual = sut.fib(n);
        assertEquals(1, actual);

        n = 3;
        actual = sut.fib(n);
        assertEquals(2, actual);

        n = 4;
        actual = sut.fib(n);
        assertEquals(3, actual);
    }

    private static class Solution {
        public int fib(int n) {
            if (n <= 1) {
                return n;
            }

            int prev1 = 1;
            int prev2 = 0;
            int result = 0;

            for (int i = 2; i <= n; i++) {
                result = prev1 + prev2;
                prev2 = prev1;
                prev1 = result;
            }

            return result;
        }
    }
}
