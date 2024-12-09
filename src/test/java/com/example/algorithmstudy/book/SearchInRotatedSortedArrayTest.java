package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInRotatedSortedArrayTest {
    private final Solution sut = new Solution();

    /*
     * 특정 피벗을 기준으로 회전하여 정렬된 배열에서 target 값의 인덱스를 출력하라.
     */

    @Test
    public void test_search() {
        var nums = new int[]{3, 4, 5, 6, 0, 1, 2};
        var target = 1;
        var actual = sut.search(nums, target);
        assertEquals(5, actual);
    }

    private static class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left < right) {
                var mid = left + (right - left) / 2;

                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            var pivot = left;

            left = 0;
            right = nums.length - 1;

            while (left <= right) {
                var mid = left + (right - left) / 2;
                var midPivot = (mid + pivot) % nums.length;

                if (nums[midPivot] < target) {
                    left = mid + 1;
                } else if (nums[midPivot] > target) {
                    right = mid - 1;
                } else {
                    return midPivot;
                }
            }

            return -1;
        }
    }
}
