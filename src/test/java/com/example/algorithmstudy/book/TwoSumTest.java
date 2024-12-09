package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {
    private final Solution sut = new Solution();

    /*
     * 덧셈하여 타깃을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라.
     */

    @Test
    public void test_twoSum() {
        int[] nums = {2, 6, 11, 15};
        int target = 8;
        var actual = record(() -> sut.twoSum(nums, target));
        assertArrayEquals(new int[]{0, 1}, actual);
    }

    @Test
    public void test_twoSum2() {
        int[] nums = {2, 6, 11, 15};
        int target = 8;
        var actual = record(() -> sut.twoSum2(nums, target));
        assertArrayEquals(new int[]{0, 1}, actual);
    }

    @Test
    public void test_twoSum3() {
        int[] nums = {2, 6, 11, 15};
        int target = 8;
        var actual = record(() -> sut.twoSum3(nums, target));
        assertArrayEquals(new int[]{0, 1}, actual);
    }

    @Test
    public void test_twoSum4() {
        int[] nums = {2, 6, 11, 15};
        int target = 8;
        var actual = record(() -> sut.twoSum4(nums, target));
        assertArrayEquals(new int[]{0, 1}, actual);
    }

    private static class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > target) continue;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }

            return null;
        }

        public int[] twoSum2(int[] nums, int target) {
            var map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                    return new int[]{i, map.get(target - nums[i])};
                }
            }

            return null;
        }

        public int[] twoSum3(int[] nums, int target) {
            var map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }

            return null;
        }

        public int[] twoSum4(int[] nums, int target) {
            // nums가 정렬되어있다고 가정하기 때문에 올바르지 않은 해결책

            var left = 0;
            var right = nums.length - 1;

            while (left != right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    return new int[]{left, right};
                }
            }

            return null;
        }
    }
}
