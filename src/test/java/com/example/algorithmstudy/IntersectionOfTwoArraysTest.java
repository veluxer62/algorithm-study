package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static com.example.algorithmstudy.FunctionsKt.generateIntArray;
import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IntersectionOfTwoArraysTest {
    private final Solution sut = new Solution();

    /*
     * 두 배열의 교집합을 구하라
     */

    @Test
    public void test_intersection() {
        var nums1 = new int[]{4, 9, 5};
        var nums2 = new int[]{9, 4, 9, 8, 4, 6};
        var actual = record(() -> sut.intersection(nums1, nums2));
        assertArrayEquals(
                new int[]{4, 9},
                actual
        );

        var nums11 = generateIntArray(50000);
        var nums22 = generateIntArray(50000);
        record(() -> sut.intersection(nums11, nums22));
    }

    @Test
    public void test_intersection2() {
        var nums1 = new int[]{4, 9, 5};
        var nums2 = new int[]{9, 4, 9, 8, 4, 6};
        var actual = record(() -> sut.intersection2(nums1, nums2));
        assertArrayEquals(
                new int[]{4, 9},
                actual
        );

        var nums11 = generateIntArray(50000);
        var nums22 = generateIntArray(50000);
        record(() -> sut.intersection2(nums11, nums22));
    }

    @Test
    public void test_intersection3() {
        var nums1 = new int[]{4, 9, 5};
        var nums2 = new int[]{9, 4, 9, 8, 4, 6};
        var actual = record(() -> sut.intersection3(nums1, nums2));
        assertArrayEquals(
                new int[]{4, 9},
                actual
        );

        var nums11 = generateIntArray(50000);
        var nums22 = generateIntArray(50000);
        record(() -> sut.intersection3(nums11, nums22));
    }

    private static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            var result = new HashSet<Integer>();

            for (var n1 : nums1) {
                for (var n2 : nums2) {
                    if (n1 == n2) {
                        result.add(n2);
                    }
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        public int[] intersection2(int[] nums1, int[] nums2) {
            var result = new HashSet<Integer>();

            Arrays.sort(nums2);

            for (var n1 : nums1) {
                var i2 = Arrays.binarySearch(nums2, n1);
                if (i2 >= 0)
                    result.add(n1);
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        public int[] intersection3(int[] nums1, int[] nums2) {
            var result = new HashSet<Integer>();

            Arrays.sort(nums1);
            Arrays.sort(nums2);

            var i = 0;
            var j = 0;

            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] > nums2[j])
                    j++;
                else if (nums1[i] < nums2[j])
                    i++;
                else {
                    result.add(nums1[i]);
                    i++;
                    j++;
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
