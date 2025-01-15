package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IntersectionOfTwoArraysTest {
    private final Solution sut = new Solution();

    /*

    Given two integer arrays nums1 and nums2, return an array of their intersection.
    Each element in the result must be unique and you may return the result in any order.



    Example 1:

    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2]
    Example 2:

    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [9,4]
    Explanation: [4,9] is also accepted.


    Constraints:

    1 <= nums1.length, nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 1000

     */

    @Test
    public void test_intersection() {
        var nums1 = new int[]{1, 2, 2, 1};
        var nums2 = new int[]{2, 2};
        var actual = sut.intersection(nums1, nums2);
        assertArrayEquals(
                new int[]{2},
                actual
        );

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        actual = sut.intersection(nums1, nums2);
        assertArrayEquals(
                new int[]{4, 9},
                actual
        );
    }

    @Test
    public void test_intersection2() {
        var nums1 = new int[]{1, 2, 2, 1};
        var nums2 = new int[]{2, 2};
        var actual = sut.intersection2(nums1, nums2);
        assertArrayEquals(
                new int[]{2},
                actual
        );

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        actual = sut.intersection2(nums1, nums2);
        assertArrayEquals(
                new int[]{4, 9},
                actual
        );
    }

    private static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            var set = new HashSet<Integer>();
            for (var n1 : nums1) {
                for (var n2 : nums2) {
                    if (n1 == n2) {
                        set.add(n2);
                    }
                }
            }

            return set.stream().mapToInt(i -> i).toArray();
        }

        public int[] intersection2(int[] nums1, int[] nums2) {
            var set1 = new HashSet<Integer>();
            for (var n1 : nums1) {
                set1.add(n1);
            }

            var set2 = new HashSet<Integer>();
            for (var n2 : nums2) {
                if (set1.contains(n2)) {
                    set2.add(n2);
                }
            }

            int[] result = new int[set2.size()];
            int index = 0;
            for (int num : set2) {
                result[index++] = num;
            }

            return result;
        }
    }
}
