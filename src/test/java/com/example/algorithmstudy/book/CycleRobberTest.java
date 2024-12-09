package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CycleRobberTest {
    private final Solution sut = new Solution();

    /*
     * 한 칸 이상 떨어진 집을 훔 칠 수 있는데, 원형으로 연결되어 있다. 훔칠 수 있는 가장 큰 금액을 출력하라.
     */

    @Test
    public void test_rob() {
        var nums = new int[]{8, 7, 3, 9};
        var actual = sut.rob(nums);
        assertEquals(16, actual);
    }

    private static class Solution {
        public int rob(int[] money) {
            if (money.length == 1) return money[0];

            var dp = new int[2][money.length];
            dp[0][0] = 0;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = money[1];

            for (var i = 2; i < money.length; i++) {
                dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + money[i]);
                dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + money[i]);
            }

            return Math.max(money[0] + dp[0][money.length - 2], dp[1][money.length - 1]);
        }
    }
}
