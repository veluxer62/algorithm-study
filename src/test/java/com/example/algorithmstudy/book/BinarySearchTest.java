package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
    private final Solution sut = new Solution();

    /*
     * 정렬된 nums를 입력받아 이진 검색으로 target에 해당하는 인덱스를 찾아라.
     */

    @Test
    public void test_search() {
        var nums = new int[]{-1, 0, 3, 5, 9, 12, 15};
        var target = 9;
        var actual = sut.search(nums, target);
        assertEquals(4, actual);
    }

    @Test
    public void test_search2() {
        var nums = new int[]{-1, 0, 3, 5, 9, 12, 15};
        var target = 9;
        var actual = sut.search2(nums, target);
        assertEquals(4, actual);
    }

    @Test
    public void test_search3() {
        var nums = new int[]{-1, 0, 3, 5, 9, 12, 15};
        var target = 9;
        var actual = sut.search3(nums, target);
        assertEquals(4, actual);
    }

    @Test
    public void test_search4() {
        var nums = new int[]{-1, 0, 3, 5, 9, 12, 15};
        var target = 9;
        var actual = sut.search4(nums, target);
        assertEquals(4, actual);
    }

    private static class Solution {
        public int search(int[] nums, int target) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        private int binarySearch(int[] nums, int target, int left, int right) {
            if (left <= right) {
                int mid = (left + right) / 2;

                if (nums[mid] < target) {
                    return binarySearch(nums, target, mid + 1, right);
                } else if (nums[mid] > target) {
                    return binarySearch(nums, target, left, mid - 1);
                } else {
                    return mid;
                }
            } else {
                return -1;
            }
        }

        public int search2(int[] nums, int target) {
            return binarySearch2(nums, target, 0, nums.length - 1);
        }

        private int binarySearch2(int[] nums, int target, int left, int right) {
            if (left <= right) {
                var mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    return binarySearch2(nums, target, mid + 1, right);
                } else if (nums[mid] > target) {
                    return binarySearch2(nums, target, left, mid - 1);
                } else {
                    return mid;
                }
            } else {
                return -1;
            }
        }

        public int search3(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                var mid = left + (right - left) / 2;

                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }

            return -1;
        }

        public int search4(int[] nums, int target) {
            return Arrays.binarySearch(nums, target);
        }
    }
}
