package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummaryRangesTest {
    private final Solution sut = new Solution();

    /*

    You are given a sorted unique integer array nums.

    A range [a,b] is the set of all integers from a to b (inclusive).

    Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

    Each range [a,b] in the list should be output as:

    "a->b" if a != b
    "a" if a == b


    Example 1:

    Input: nums = [0,1,2,4,5,7]
    Output: ["0->2","4->5","7"]
    Explanation: The ranges are:
    [0,2] --> "0->2"
    [4,5] --> "4->5"
    [7,7] --> "7"
    Example 2:

    Input: nums = [0,2,3,4,6,8,9]
    Output: ["0","2->4","6","8->9"]
    Explanation: The ranges are:
    [0,0] --> "0"
    [2,4] --> "2->4"
    [6,6] --> "6"
    [8,9] --> "8->9"


    Constraints:

    0 <= nums.length <= 20
    -231 <= nums[i] <= 231 - 1
    All the values of nums are unique.
    nums is sorted in ascending order.

     */

    @Test
    public void test_summaryRanges() {
        var nums = new int[]{0, 1, 2, 4, 5, 7};
        var actual = sut.summaryRanges(nums);
        assertEquals(
                List.of("0->2", "4->5", "7"),
                actual
        );

        nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        actual = sut.summaryRanges(nums);
        assertEquals(
                List.of("0", "2->4", "6", "8->9"),
                actual
        );
    }

    private static class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> result = new ArrayList<>();

            if (nums == null || nums.length == 0) {
                return result;
            }

            int start = nums[0]; // 시작 값

            for (int i = 1; i < nums.length; i++) {
                // 연속되지 않는 경우
                if (nums[i] != nums[i - 1] + 1) {
                    // 범위를 문자열로 추가
                    if (start == nums[i - 1]) {
                        result.add(String.valueOf(start));
                    } else {
                        result.add(start + "->" + nums[i - 1]);
                    }
                    start = nums[i]; // 새로운 시작 값
                }
            }

            // 마지막 범위 처리
            if (start == nums[nums.length - 1]) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + nums[nums.length - 1]);
            }

            return result;
        }
    }
}
