package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import static com.example.algorithmstudy.FunctionsKt.generateIntArray;
import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStockTest {
    private final Solution sut = new Solution();

    /*
     * 한 번의 거래로 낼 수 있는 최대 이익을 산출하라.
     */

    @Test
    public void test_maxProfit() {
        var arr = new int[]{8, 1, 5, 3, 6, 4};
        var actual = record(() -> sut.maxProfit(arr));
        assertEquals(5, actual);

        var arr2 = generateIntArray(200000);
        record(() -> sut.maxProfit(arr2));
    }

    @Test
    public void test_maxProfit2() {
        var arr = new int[]{8, 1, 5, 3, 6, 4};
        var actual = record(() -> sut.maxProfit2(arr));
        assertEquals(5, actual);

        var arr2 = generateIntArray(200000);
        record(() -> sut.maxProfit2(arr2));
    }

    @Test
    public void test_maxProfit3() {
        var arr = new int[]{8, 1, 5, 3, 6, 4};
        var actual = record(() -> sut.maxProfit3(arr));
        assertEquals(5, actual);

        var arr2 = generateIntArray(200000);
        record(() -> sut.maxProfit3(arr2));
    }

    private static class Solution {
        public int maxProfit(int[] arr) {
            var minIndex = 0;
            var minValue = Integer.MAX_VALUE;
            var maxValue = 0;

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < minValue) {
                    minValue = arr[i];
                    minIndex = i;
                }
            }

            for (int i = minIndex + 1; i < arr.length; i++) {
                if (arr[i] > maxValue) {
                    maxValue = arr[i];
                }
            }

            return maxValue - minValue;
        }

        public int maxProfit2(int[] arr) {
            var max = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    max = Math.max(max, arr[j] - arr[i]);
                }
            }

            return max;
        }

        public int maxProfit3(int[] arr) {
            var max = 0;
            var min = arr[0];

            for (int it : arr) {
                min = Math.min(min, it);
                max = Math.max(max, it - min);
            }

            return max;
        }
    }
}
