package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MinimumIndexSumOfTwoListsTest {
    private final Solution sut = new Solution();

    /*

    Given two arrays of strings list1 and list2, find the common strings with the least index sum.

    A common string is a string that appeared in both list1 and list2.

    A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.

    Return all the common strings with the least index sum. Return the answer in any order.



    Example 1:

    Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
    Output: ["Shogun"]
    Explanation: The only common string is "Shogun".
    Example 2:

    Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
    Output: ["Shogun"]
    Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.
    Example 3:

    Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
    Output: ["sad","happy"]
    Explanation: There are three common strings:
    "happy" with index sum = (0 + 1) = 1.
    "sad" with index sum = (1 + 0) = 1.
    "good" with index sum = (2 + 2) = 4.
    The strings with the least index sum are "sad" and "happy".


    Constraints:

    1 <= list1.length, list2.length <= 1000
    1 <= list1[i].length, list2[i].length <= 30
    list1[i] and list2[i] consist of spaces ' ' and English letters.
    All the strings of list1 are unique.
    All the strings of list2 are unique.
    There is at least a common string between list1 and list2.

     */

    @Test
    public void test_findRestaurant() {
        var list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        var list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        var actual = sut.findRestaurant(list1, list2);
        assertArrayEquals(
                new String[]{"Shogun"},
                actual
        );

        list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        list2 = new String[]{"KFC", "Shogun", "Burger King"};
        actual = sut.findRestaurant(list1, list2);
        assertArrayEquals(
                new String[]{"Shogun"},
                actual
        );

        list1 = new String[]{"happy", "sad", "good"};
        list2 = new String[]{"sad", "happy", "good"};
        actual = sut.findRestaurant(list1, list2);
        assertArrayEquals(
                new String[]{"happy", "sad"},
                actual
        );
    }

    @Test
    public void test_findRestaurant2() {
        var list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        var list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        var actual = sut.findRestaurant2(list1, list2);
        assertArrayEquals(
                new String[]{"Shogun"},
                actual
        );

        list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        list2 = new String[]{"KFC", "Shogun", "Burger King"};
        actual = sut.findRestaurant2(list1, list2);
        assertArrayEquals(
                new String[]{"Shogun"},
                actual
        );

        list1 = new String[]{"happy", "sad", "good"};
        list2 = new String[]{"sad", "happy", "good"};
        actual = sut.findRestaurant2(list1, list2);
        assertArrayEquals(
                new String[]{"sad", "happy"},
                actual
        );
    }

    private static class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            var map = new HashMap<Integer, List<String>>();
            var min = Integer.MAX_VALUE;

            for (int i = 0; i < list1.length; i++) {
                for (int j = 0; j < list2.length; j++) {
                    if (list1[i].equals(list2[j])) {
                        int value = i + j;
                        var s = map.getOrDefault(value, new ArrayList<>());
                        s.add(list1[i]);
                        map.putIfAbsent(value, s);
                        min = Math.min(min, value);
                    }
                }
            }

            return map.get(min).stream().map(String::valueOf).toArray(String[]::new);
        }

        public String[] findRestaurant2(String[] list1, String[] list2) {
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }

            int minSum = Integer.MAX_VALUE;
            List<String> ans = new ArrayList<>();

            for (int i = 0; i < list2.length; i++) {
                if (map.containsKey(list2[i])) {
                    int indexSum = i + map.get(list2[i]);
                    if (indexSum < minSum) {
                        ans.clear();
                        ans.add(list2[i]);
                        minSum = indexSum;
                    } else if (indexSum == minSum) {
                        ans.add(list2[i]);
                    }
                }
            }

            return ans.toArray(new String[0]);
        }
    }
}
