package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.example.algorithmstudy.FunctionsKt.*;

public class ThreeSumTest {
    private final Solution sut = new Solution();

    /*
     * 배열을 입력받아 합으로 0을 만들 수 있는 3개의 엘리먼트를 출력하라
     */

    @Test
    public void test_threeSum() {
        var nums = new int[]{-1, 0, 1, 2, -1, -5};
        var actual = record(() -> sut.threeSum(nums));

        assertContains(
                List.of(
                        List.of(-1, 0, 1),
                        List.of(-1, -1, 2)
                ),
                actual
        );

        var nums2 = generateIntArray(2000);
        record(() -> sut.threeSum(nums2));
    }

    @Test
    public void test_threeSum2() {
        var nums = new int[]{-1, 0, 1, 2, -1, -5};
        var actual = record(() -> sut.threeSum2(nums));

        assertContains(
                List.of(
                        List.of(-1, 0, 1),
                        List.of(-1, -1, 2)
                ),
                actual
        );

        var nums2 = generateIntArray(2000);
        record(() -> sut.threeSum2(nums2));
    }

    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            var result = new LinkedList<List<Integer>>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                    for (int k = j + 1; k < nums.length; k++) {
                        if (k > j + 1 && nums[k] == nums[k - 1]) continue;

                        if (nums[i] + nums[j] + nums[k] == 0) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        }
                    }
                }
            }

            return result;
        }

        public List<List<Integer>> threeSum2(int[] nums) {
            int left, right, sum;
            var result = new LinkedList<List<Integer>>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                left = i + 1;
                right = nums.length - 1;
                while (left < right) {
                    sum = nums[i] + nums[left] + nums[right];

                    if (sum < 0)
                        left++;
                    else if (sum > 0)
                        right--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                }
            }

            return result;
        }
    }
}
