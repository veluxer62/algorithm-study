package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinBestTimeToBuyAndSellStock2Test {
    /*
     * 여러 번의 거래로 낼 수 있는 최대 이익을 산출하라.
     */

    @Test
    fun test_maxProfit() {
        val prices = intArrayOf(8, 1, 5, 3, 6, 4)
        val actual: Int = maxProfit(prices)
        Assertions.assertEquals(7, actual)
    }

    private fun maxProfit(prices: IntArray): Int {
        var result = 0

        for (i in 0 until prices.size - 1) {
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i]
            }
        }

        return result
    }
}
