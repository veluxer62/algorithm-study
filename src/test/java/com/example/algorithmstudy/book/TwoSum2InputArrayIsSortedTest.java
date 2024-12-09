package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSum2InputArrayIsSortedTest {
    private final Solution sut = new Solution();

    /*
     * 정렬된 배열을 받아 덧셈하여 타깃을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라.
     */

    @Test
    public void test_twoSum() {
        var numbers = new int[]{2, 6, 11, 15};
        var target = 8;
        var actual = sut.twoSum(numbers, target);
        assertArrayEquals(
                new int[]{1, 2},
                actual
        );
    }

    @Test
    public void test_twoSum2() {
        var numbers = new int[]{2, 6, 11, 15};
        var target = 8;
        var actual = sut.twoSum2(numbers, target);
        assertArrayEquals(
                new int[]{1, 2},
                actual
        );
    }

    @Test
    public void test_twoSum3() {
        var numbers = new int[]{2, 6, 11, 15};
        var target = 8;
        var actual = sut.twoSum3(numbers, target);
        assertArrayEquals(
                new int[]{1, 2},
                actual
        );
    }

    private static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            var left = 0;
            var right = numbers.length - 1;

            while (left != right) {
                if (numbers[left] + numbers[right] < target) {
                    left++;
                } else if (numbers[left] + numbers[right] > target) {
                    right--;
                } else {
                    return new int[]{left + 1, right + 1};
                }
            }

            return null;
        }

        public int[] twoSum2(int[] numbers, int target) {
            for (int i = 0; i < numbers.length - 1; i++) {
                var left = i + 1;
                var right = numbers.length - 1;
                var expected = target - numbers[i];

                while (left <= right) {
                    var mid = left + (right - left) / 2;
                    if (numbers[mid] < expected) {
                        left = mid + 1;
                    } else if (numbers[mid] > expected) {
                        right = mid - 1;
                    } else {
                        return new int[]{i + 1, mid + 1};
                    }
                }
            }

            return null;
        }

        public int[] twoSum3(int[] numbers, int target) {
            for (int i = 0; i < numbers.length - 1; i++) {
                var expected = target - numbers[i];
                var idx = Arrays.binarySearch(numbers, i + 1, numbers.length, expected);
                if (idx >= 0) {
                    return new int[]{i + 1, idx + 1};
                }
            }

            return null;
        }
    }
}
