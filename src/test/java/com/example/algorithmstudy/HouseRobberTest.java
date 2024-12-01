package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseRobberTest {
    private final Solution sut = new Solution();

    /*
     * 당신은 전문털이범이다.
     * 어느 집에서든 돈을 훔쳐올 수 있지만 경보 시스템 때문에 바로 옆집은 훔칠 수 없고 한 칸 이상 떨어진 집만 가능한다.
     * 각 집에는 훔칠 수 있는 돈의 액수가 입력값으로 표기되어 있다.
     * 훔칠 수 있는 가장 큰 금액을 출력하라.
     */

    @Test
    public void test_rob() {
        var nums = new int[]{8, 7, 3, 9};
        var actual = sut.rob(nums);
        assertEquals(17, actual);
    }

    @Test
    public void test_rob2() {
        var nums = new int[]{8, 7, 3, 9};
        var actual = sut.rob2(nums);
        assertEquals(17, actual);
    }

    private static class Solution {
        public int rob(int[] nums) {
            return rob(nums, nums.length - 1);
        }

        private int rob(int[] nums, int n) {
            if (n < 0) return 0;

            return Math.max(rob(nums, n - 1), rob(nums, n - 2) + nums[n]);
        }

        public int rob2(int[] nums) {
            if (nums.length == 1) return nums[0];

            var dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(dp[0], nums[1]);

            for (var i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }

            return dp[nums.length - 1];
        }
    }
}
