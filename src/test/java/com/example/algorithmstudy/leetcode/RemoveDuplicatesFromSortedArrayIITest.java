package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatesFromSortedArrayIITest {
    private final Solution sut = new Solution();

    /*

    Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

    Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

    Return k after placing the final result in the first k slots of nums.

    Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

    Custom Judge:

    The judge will test your solution with the following code:

    int[] nums = [...]; // Input array
    int[] expectedNums = [...]; // The expected answer with correct length

    int k = removeDuplicates(nums); // Calls your implementation

    assert k == expectedNums.length;
    for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
    }
    If all assertions pass, then your solution will be accepted.

     */

    @Test
    public void test_removeDuplicates() {
        var nums = new int[]{1,1,1,2,2,3};
        var actual = sut.removeDuplicates(nums);
        assertEquals(5, actual);

        nums = new int[]{0,0,1,1,1,1,2,3,3};
        actual = sut.removeDuplicates(nums);
        assertEquals(7, actual);
    }

    @Test
    public void test_removeDuplicates2() {
        var nums = new int[]{1,1,1,2,2,3};
        var actual = sut.removeDuplicates2(nums);
        assertEquals(5, actual);

        nums = new int[]{0,0,1,1,1,1,2,3,3};
        actual = sut.removeDuplicates2(nums);
        assertEquals(7, actual);
    }

    private static class Solution {
        public int removeDuplicates(int[] nums) {
            var map = new LinkedHashMap<Integer, List<Integer>>();
            for (var num : nums) {
                var value = map.getOrDefault(num, new ArrayList<>());
                if (value.size() < 2) {
                    value.add(num);
                    map.put(num, value);
                }
            }

            var values = map.values().stream().flatMap(Collection::stream).collect(Collectors.toList());

            for (int i = 0; i < values.size(); i++) {
                nums[i] = values.get(i);
            }

            return values.size();
        }

        public int removeDuplicates2(int[] nums) {
            int insertIndex = 2;
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] != nums[insertIndex - 2]) {
                    nums[insertIndex++] = nums[i];
                }
            }

            return insertIndex;
        }
    }
}
