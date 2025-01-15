package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IntersectionOfTwoArraysIITest {
    private final Solution sut = new Solution();

    /*

    Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.



    Example 1:

    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]
    Example 2:

    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
    Explanation: [9,4] is also accepted.


    Constraints:

    1 <= nums1.length, nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 1000


    Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

     */

    @Test
    public void test_intersect() {
        var nums1 = new int[]{1, 2, 2, 1};
        var nums2 = new int[]{2, 2};
        var actual = sut.intersect(nums1, nums2);
        assertArrayEquals(
                new int[]{2, 2},
                actual
        );

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        actual = sut.intersect(nums1, nums2);
        assertArrayEquals(
                new int[]{4, 9},
                actual
        );
    }

    private static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }

            Arrays.sort(nums1);
            Arrays.sort(nums2);

            var i = 0;
            var j = 0;

            var set = new ArrayList<Integer>();

            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                    i++;
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                }
            }

            var result = new int[set.size()];
            var index = 0;
            for (var n : set) {
                result[index++] = n;
            }

            return result;
        }
    }
}
