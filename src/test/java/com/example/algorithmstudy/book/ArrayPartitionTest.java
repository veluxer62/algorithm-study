package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayPartitionTest {
    private final Solution sut = new Solution();

    /*
     * n개의 페어를 이용한 min(a,b)의 합으로 만들 수 있는 가장 큰 수를 출력하라.
     */

    @Test
    public void test_arrayPairSum() {
        int[] nums = {1, 3, 4, 2};
        var actual = record(() -> sut.arrayPairSum(nums));
        assertEquals(4, actual);
    }

    @Test
    public void test_arrayPairSum2() {
        int[] nums = {1, 3, 4, 2};
        var actual = record(() -> sut.arrayPairSum2(nums));
        assertEquals(4, actual);
    }

    private static class Solution {
        public int arrayPairSum(int[] nums) {
            var sum = 0;
            var pair = new ArrayList<Integer>();
            Arrays.sort(nums);

            for (int n : nums) {
                pair.add(n);

                if (pair.size() == 2) {
                    sum += Collections.min(pair);
                    pair.clear();
                }
            }

            return sum;
        }

        public int arrayPairSum2(int[] nums) {
            var sum = 0;
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0) {
                    sum += nums[i];
                }
            }

            return sum;
        }
    }
}
