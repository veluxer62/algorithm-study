package com.example.algorithmstudy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinBestTimeToBuyAndSellStockTest {
    /*
     * 한 번의 거래로 낼 수 있는 최대 이익을 산출하라.
     */

    @Test
    fun test_maxProfit() {
        val arr = intArrayOf(8, 1, 5, 3, 6, 4)
        val actual = record { maxProfit(arr) }
        Assertions.assertEquals(5, actual)

        val arr2 = generateIntArray(200000)
        record { maxProfit(arr2) }
    }

    @Test
    fun test_maxProfit2() {
        val arr = intArrayOf(8, 1, 5, 3, 6, 4)
        val actual = record { maxProfit2(arr) }
        Assertions.assertEquals(5, actual)

        val arr2 = generateIntArray(200000)
        record { maxProfit2(arr2) }
    }

    private fun maxProfit(arr: IntArray): Int {
        var max = 0
        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                max = maxOf(max, arr[j] - arr[i])
            }
        }

        return max
    }

    private fun maxProfit2(arr: IntArray): Int {
        var min = arr[0]
        var max = 0

        for (item in arr) {
            min = minOf(min, item)
            max = maxOf(max, item - min)
        }

        return max
    }
}
