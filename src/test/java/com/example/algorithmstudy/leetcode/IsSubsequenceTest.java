package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsSubsequenceTest {
    private final Solution sut = new Solution();

    /*

    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



    Example 1:

    Input: s = "abc", t = "ahbgdc"
    Output: true
    Example 2:

    Input: s = "axc", t = "ahbgdc"
    Output: false


    Constraints:

    0 <= s.length <= 100
    0 <= t.length <= 104
    s and t consist only of lowercase English letters.


    Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?

     */

    @Test
    public void test_isSubsequence() {
        var s = "abc";
        var t = "ahbgdc";
        var actual = sut.isSubsequence(s, t);
        assertTrue(actual);

        s = "axc";
        t = "ahbgdc";
        actual = sut.isSubsequence(s, t);
        assertFalse(actual);
    }

    @Test
    public void test_isSubsequence2() {
        var s = "abc";
        var t = "ahbgdc";
        var actual = sut.isSubsequence2(s, t);
        assertTrue(actual);

        s = "axc";
        t = "ahbgdc";
        actual = sut.isSubsequence2(s, t);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.isEmpty()) return true;

            var sIndx = 0;
            var sLen = s.length();

            for (var c : t.toCharArray()) {
                var sc = s.charAt(sIndx);
                if (sc == c) {
                    sIndx++;

                    if (sIndx == sLen) break;
                }
            }

            return sIndx == sLen;
        }

        public boolean isSubsequence2(String s, String t) {
            int sIndex = 0, tIndex = 0;

            while (sIndex < s.length() && tIndex < t.length()) {
                if (s.charAt(sIndex) == t.charAt(tIndex)) {
                    sIndex++;
                }
                tIndex++;
            }

            return sIndex == s.length();
        }
    }
}
