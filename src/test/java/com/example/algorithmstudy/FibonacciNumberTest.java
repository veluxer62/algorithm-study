package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciNumberTest {
    private final Solution sut = new Solution();

    /*
     * 피보나치 수를 구하라.
     */

    @Test
    public void test_fib() {
        var n = 5;
        var actual = sut.fib(n);
        assertEquals(5, actual);
    }

    @Test
    public void test_fib2() {
        var n = 5;
        var actual = sut.fib2(n);
        assertEquals(5, actual);
    }

    @Test
    public void test_fib3() {
        var n = 5;
        var actual = sut.fib3(n);
        assertEquals(5, actual);
    }

    @Test
    public void test_fib4() {
        var n = 5;
        var actual = sut.fib4(n);
        assertEquals(5, actual);
    }

    private static class Solution {
        public int fib(int n) {
            if (n <= 1) return n;

            return fib(n - 1) + fib(n - 2);
        }

        private final int[] dp = new int[23];

        public int fib2(int n) {
            if (n <= 1) return n;

            if (dp[n] != 0) return dp[n];

            dp[n] = fib2(n - 1) + fib2(n - 2);
            return dp[n];
        }

        public int fib3(int n) {
            var dp = new int[31];

            dp[0] = 0;
            dp[1] = 1;

            for (var i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }

        public int fib4(int n) {
            int x = 0, y = 1;

            for (var i = 0; i < n; i++) {
                var z = x + y;
                x = y;
                y = z;
            }

            return x;
        }
    }
}
