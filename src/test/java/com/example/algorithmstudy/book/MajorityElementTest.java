package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static java.util.Map.Entry.comparingByValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MajorityElementTest {
    private final Solution sut = new Solution();

    /*
     * 과반수를 차지하는(절반을 초과하는) 엘리먼트를 출력하라.
     */

    @Test
    public void test_majorityElement() {
        var nums = new int[]{2, 2, 1, 1, 3, 2, 2};
        var actual = sut.majorityElement(nums);
        assertEquals(2, actual);
    }

    @Test
    public void test_majorityElement2() {
        var nums = new int[]{2, 2, 1, 1, 3, 2, 2};
        var actual = sut.majorityElement2(nums);
        assertEquals(2, actual);
    }

    @Test
    public void test_majorityElement3() {
        var nums = new int[]{2, 2, 1, 1, 3, 2, 2};
        var actual = sut.majorityElement3(nums);
        assertEquals(2, actual);
    }

    private static class Solution {
        public int majorityElement(int[] nums) {
            var countsMap = new HashMap<Integer, Integer>();
            for (var num : nums) {
                countsMap.put(num, countsMap.getOrDefault(num, 0) + 1);
            }

            var reverseSortedMap = new LinkedHashMap<Integer, Integer>();

            countsMap.entrySet()
                    .stream()
                    .sorted(comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

            var entry = reverseSortedMap.entrySet().iterator().next();

            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }

            return -1;
        }

        public int majorityElement2(int[] nums) {
            return majorityElement(0, nums.length - 1, nums);
        }

        private int majorityElement(int left, int right, int[] nums) {
            if (left == right) return nums[left];

            var mid = left + (right - left) / 2;
            var a = majorityElement(left, mid, nums);
            var b = majorityElement(mid + 1, right, nums);

            var countA = 0;
            for (var i = left; i <= right; i++) {
                if (nums[i] == a) {
                    countA++;
                }
            }

            return countA > (right - left + 1) / 2 ? a : b;
        }

        public int majorityElement3(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
}
