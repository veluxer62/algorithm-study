package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestNumberTest {
    private final Solution sut = new Solution();

    /*
     * 엘리먼트를 조합해 만들 수 있는 가장 큰 수를 출력하라.
     */

    @Test
    public void test_largestNumber() {
        var nums = new int[]{3,30,34,8,9};
        var actual = sut.largestNumber(nums);
        assertEquals(
                "9834330",
                actual
        );
    }

    private static class Solution {
        public String largestNumber(int[] nums) {
            var i = 1;

            while (i < nums.length) {
                var j = i;

                while (j > 0 && toSwap(nums[j - 1], nums[j])) {
                    var temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;

                    j--;
                }

                i++;
            }

            return nums[0] == 0 ? "0" : Arrays.toString(nums).replaceAll("\\[|]|,|\\s", "");
        }

        private boolean toSwap(int n1, int n2) {
            return Long.parseLong(String.valueOf(n1) + n2) < Long.parseLong(String.valueOf(n2) + n1);
        }
    }
}
