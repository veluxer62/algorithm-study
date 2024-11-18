package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SlidingWindowMaximumTest {
    private final Solution sut = new Solution();

    /*
     * 배열 nums가 주어졌을 때 k 크기의 슬라이딩 윈도우를 오른쪽 끝까지 이동하면서 최대 슬라이딩 윈도우를 구하라.
     */

    @Test
    public void test_maxSlidingWindow() {
        var nums = new int[]{1, 3, -1, -3, 5, 3, 6, 8};
        var k = 3;
        var actual = sut.maxSlidingWindow(nums, k);
        assertArrayEquals(
                new int[]{3, 3, 5, 5, 6, 8},
                actual
        );
    }

    @Test
    public void test_maxSlidingWindow2() {
        var nums = new int[]{1, 3, -1, -3, 5, 3, 6, 8};
        var k = 3;
        var actual = sut.maxSlidingWindow2(nums, k);
        assertArrayEquals(
                new int[]{3, 3, 5, 5, 6, 8},
                actual
        );
    }

    @Test
    public void test_maxSlidingWindow3() {
        var nums = new int[]{1, 3, -1, -3, 5, 3, 6, 8};
        var k = 3;
        var actual = sut.maxSlidingWindow3(nums, k);
        assertArrayEquals(
                new int[]{3, 3, 5, 5, 6, 8},
                actual
        );
    }

    private static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0) return new int[0];

            var result = new ArrayList<Integer>();

            for (int i = 0; i < nums.length - k + 1; i++) {
                var max = nums[i];

                for (int j = i + 1; j < i + k; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                    }
                }

                result.add(max);
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        public int[] maxSlidingWindow2(int[] nums, int k) {
            var result = new ArrayList<Integer>();
            var window = new LinkedList<Integer>();
            var currentMax = Integer.MIN_VALUE;

            for (var i = 0; i < nums.length; i++) {
                window.add(nums[i]);

                if (i < k - 1) continue;

                if (currentMax == Integer.MIN_VALUE) {
                    currentMax = window.stream().max(Integer::compareTo).get();
                } else if (currentMax < nums[i]) {
                    currentMax = nums[i];
                }

                result.add(currentMax);

                if (currentMax == window.poll()) {
                    currentMax = Integer.MIN_VALUE;
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        public int[] maxSlidingWindow3(int[] nums, int k) {
            var result = new ArrayList<Integer>();
            var dq = new ArrayDeque<Integer>();

            for (var i = 0; i < nums.length; i++) {
                if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                    dq.poll();
                }

                while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                    dq.pollLast();
                }

                dq.add(i);

                if (i >= k - 1) {
                    result.add(nums[dq.peek()]);
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
