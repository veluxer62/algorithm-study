package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbingStairsTest {
    private final Solution sut = new Solution();

    /*

    You are climbing a staircase. It takes n steps to reach the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



    Example 1:

    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
    Example 2:

    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step


    Constraints:

    1 <= n <= 45

     */

    @Test
    public void test_climbStairs() {
        var n = 2;
        var actual = sut.climbStairs(n);
        assertEquals(2, actual);

        n = 3;
        actual = sut.climbStairs(n);
        assertEquals(3, actual);

        n = 4;
        actual = sut.climbStairs(n);
        assertEquals(5, actual);
    }

    private static class Solution {
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }

            int prev1 = 1;
            int prev2 = 2;

            for (int i = 3; i <= n; i++) {
                int current = prev1 + prev2;
                prev1 = prev2;
                prev2 = current;
            }

            return prev2;
        }

        public static int climbStairs2(int n) {
            if (n <= 2) {
                return n;
            }

            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }
    }
}
