package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopKFrequentElementsTest {
    private final Solution sut = new Solution();

    /*
     * 빈도순으로 k개의 엘리먼트를 추출하라
     */

    @Test
    public void test_topKFrequent() {
        var nums = new int[]{1, 1, 1, 2, 2, 3, 4};
        var k = 2;
        var actual = sut.topKFrequent(nums, k);
        assertArrayEquals(
                new int[]{1, 2},
                actual
        );
    }

    @Test
    public void test_topKFrequent2() {
        var nums = new int[]{1, 1, 1, 2, 2, 3, 4};
        var k = 2;
        var actual = sut.topKFrequent2(nums, k);
        assertArrayEquals(
                new int[]{1, 2},
                actual
        );
    }

    private static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            var frequencyMap = new HashMap<Integer, Integer>();
            for (int num : nums) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }

            var buckets = new HashMap<Integer, List<Integer>>();
            for (int element : frequencyMap.keySet()) {
                int frequency = frequencyMap.get(element);
                var elements = buckets.getOrDefault(frequency, new ArrayList<>());
                elements.add(element);
                buckets.put(frequency, elements);
            }

            var result = new int[k];
            int index = 0;
            for (int frequency = nums.length; frequency >= 0 && index < k; frequency--) {
                if (buckets.get(frequency) != null) {
                    for (int element : buckets.get(frequency)) {
                        result[index] = element;
                        index++;
                    }
                }
            }

            return result;
        }

        public int[] topKFrequent2(int[] nums, int k) {
            var frequencyMap = new HashMap<Integer, Integer>();
            for (int num : nums) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }

            var pq = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
            for (int element : frequencyMap.keySet()) {
                pq.add(new int[]{element, frequencyMap.get(element)});
            }

            var result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = pq.poll()[0];
            }

            return result;
        }
    }
}
