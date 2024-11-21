package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStock2Test {
    private final Solution sut = new Solution();

    /*
     * 여러 번의 거래로 낼 수 있는 최대 이익을 산출하라.
     */

    @Test
    public void test_maxProfit() {
        var prices = new int[] {8, 1, 5, 3, 6, 4};
        var actual = sut.maxProfit(prices);
        assertEquals(7, actual);
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            var result = 0;

            for (var i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    result += prices[i + 1] - prices[i];
                }
            }

            return result;
        }
    }
}
