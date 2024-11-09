package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeIntervalsTest {
    private final Solution sut = new Solution();

    /*
     * 겹치는 구간을 병합하라.
     */

    @Test
    public void test_merge() {
        var intervals = new int[][]{{1, 3}, {8, 11}, {2, 6}, {15, 18}};
        var actual = sut.merge(intervals);
        assertArrayEquals(
                new int[][]{{1, 6}, {8, 11}, {15, 18}},
                actual
        );
    }

    private static class Solution {
        public int[][] merge(int[][] intervals) {
            var merged = new ArrayList<int[]>();

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            for (int[] interval : intervals) {
                if (!merged.isEmpty() && interval[0] <= merged.get(merged.size() - 1)[1]) {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
                } else {
                    merged.add(interval);
                }
            }

            return merged.toArray(new int[merged.size()][]);
        }
    }
}
