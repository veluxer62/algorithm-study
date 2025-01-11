package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidAnagramTest {
    private final Solution sut = new Solution();

    /*

    Given two strings s and t, return true if t is an anagram of s, and false otherwise.



    Example 1:

    Input: s = "anagram", t = "nagaram"

    Output: true

    Example 2:

    Input: s = "rat", t = "car"

    Output: false



    Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.


    Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

     */

    @Test
    public void test_isAnagram() {
        var s = "anagram";
        var t = "nagaram";
        var actual = sut.isAnagram(s, t);
        assertTrue(actual);

        s = "rat";
        t = "car";
        actual = sut.isAnagram(s, t);
        assertFalse(actual);
    }

    @Test
    public void test_isAnagram2() {
        var s = "anagram";
        var t = "nagaram";
        var actual = sut.isAnagram2(s, t);
        assertTrue(actual);

        s = "rat";
        t = "car";
        actual = sut.isAnagram2(s, t);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();

            Arrays.sort(sArray);
            Arrays.sort(tArray);

            return Arrays.equals(sArray, tArray);
        }

        public boolean isAnagram2(String s, String t) {
            if (s.length() != t.length()) return false;

            var countMap = new HashMap<Character, Integer>();
            for (char c : s.toCharArray()) {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }

            for (char c : t.toCharArray()) {
                if (!countMap.containsKey(c)) return false;

                countMap.put(c, countMap.get(c) - 1);

                if (countMap.get(c) == 0) {
                    countMap.remove(c);
                }
            }

            return countMap.isEmpty();
        }
    }
}
