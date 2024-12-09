package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImmigrationTest {
    private final Solution sut = new Solution();

    /*
     * 각 심사관이 한 명을 심사하는 데 걸리는 시간이 담긴 배열 times가 주어질 때, 모든 사람이 심사를 받는 데 걸리는 시간의 최솟값을 출력하라.
     */

    @Test
    public void test_migrate() {
        var n = 6;
        var times = new int[] {7, 10};
        var actual = sut.migrate(n, times);
        assertEquals(28, actual);
    }

    private static class Solution {
        public long migrate(int n, int[] times) {
            var answer = 0L;

            var left = 1L;
            var right = (long) Arrays.stream(times).max().orElse(0) * n;
            var mid = right;

            while (left <= right) {
                var calcN = 0L;
                for (var time : times) {
                    calcN += mid / time;
                }

                if (calcN >= n) {
                    answer = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

                mid = left + (right - left) / 2;
            }

            return answer;
        }
    }
}
