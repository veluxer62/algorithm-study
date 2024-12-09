package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbingStairsTest {
    private final Solution sut = new Solution();

    /*
     * 당신은 계단을 오르고 있다. 정상에 도달하기 위해 n게단을 올라야 한다.
     * 매번 각각 1계단 또는 2계단씩 오를 수 있다면 정상에 도달하기 위한 방법은 몇 가지 경로가 되는지 계산하라.
     */

    @Test
    public void test_climbStairs() {
        var n = 4;
        var actual = sut.climbStairs(n);
        assertEquals(5, actual);
    }

    @Test
    public void test_climbStairs2() {
        var n = 4;
        var actual = sut.climbStairs2(n);
        assertEquals(5, actual);
    }

    private static class Solution {
        public int climbStairs(int n) {
            if (n <= 2) return n;

            return climbStairs(n -1) + climbStairs(n - 2);
        }

        private final int[] dp = new int[46];
        public int climbStairs2(int n) {
            if (n <= 2) return n;

            if (dp[n] != 0) return dp[n];

            dp[n] = climbStairs2(n - 1) + climbStairs2(n - 2);
            return dp[n];
        }
    }
}
