package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleNumberTest {
    private final Solution sut = new Solution();

    /*
     * 딱 하나를 제외하고 모든 엘리먼트가 2개씩 있다. 1개인 엘리먼트를 찾아라.
     */

    @Test
    public void test_singleNumber() {
        var nums = new int[]{1, 2, 1};
        var actual = sut.singleNumber(nums);
        assertEquals(2, actual);
    }

    private static class Solution {
        public int singleNumber(int[] nums) {
            var result = 0;
            for (int num : nums) {
                result ^= num;
            }

            return result;
        }
    }
}
