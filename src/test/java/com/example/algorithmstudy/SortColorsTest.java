package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortColorsTest {
    private final Solution sut = new Solution();

    /*
     * 빨간색을 0, 흰색을 1, 파란색을 2라 할 때 순서대로 인접하는 제자리 정렬을 수행하라.
     */

    @Test
    public void test_sortColors() {
        var nums = new int[]{2, 0, 2, 1, 1, 0};
        sut.sortColors(nums);
        assertArrayEquals(
                new int[]{0, 0, 1, 1, 2, 2},
                nums
        );
    }

    private static class Solution {
        public void sortColors(int[] nums) {
            var red = 0;
            var white = 0;
            var blue = nums.length;

            while (white < blue) {
                if (nums[white] < 1) {
                    var temp = nums[red];
                    nums[red] = nums[white];
                    nums[white] = temp;

                    red++;
                    white++;
                } else if (nums[white] > 1) {
                    blue--;
                    var temp = nums[white];
                    nums[white] = nums[blue];
                    nums[blue] = temp;
                } else {
                    white++;
                }
            }
        }
    }
}
