package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedSubstringPatternTest {
    private final Solution sut = new Solution();

    /*

    Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.



    Example 1:

    Input: s = "abab"
    Output: true
    Explanation: It is the substring "ab" twice.
    Example 2:

    Input: s = "aba"
    Output: false
    Example 3:

    Input: s = "abcabcabcabc"
    Output: true
    Explanation: It is the substring "abc" four times or the substring "abcabc" twice.


    Constraints:

    1 <= s.length <= 104
    s consists of lowercase English letters.

     */

    @Test
    public void test_repeatedSubstringPattern() {
        var s = "abab";
        var actual = sut.repeatedSubstringPattern(s);
        assertTrue(actual);

        s = "aba";
        actual = sut.repeatedSubstringPattern(s);
        assertFalse(actual);

        s = "abcabcabcabc";
        actual = sut.repeatedSubstringPattern(s);
        assertTrue(actual);
    }

    @Test
    public void test_repeatedSubstringPattern2() {
        var s = "abab";
        var actual = sut.repeatedSubstringPattern2(s);
        assertTrue(actual);

        s = "aba";
        actual = sut.repeatedSubstringPattern2(s);
        assertFalse(actual);

        s = "abcabcabcabc";
        actual = sut.repeatedSubstringPattern2(s);
        assertTrue(actual);
    }

    private static class Solution {
        public boolean repeatedSubstringPattern(String s) {
            int n = s.length();

            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    String substring = s.substring(0, i);

                    StringBuilder repeated = new StringBuilder();
                    repeated.append(substring.repeat(n / i));

                    if (repeated.toString().equals(s)) return true;
                }
            }

            return false;
        }

        public boolean repeatedSubstringPattern2(String s) {
            var doubledString = s + s;
            var substr = doubledString.substring(1, doubledString.length() - 1);
            return substr.contains(s);
        }
    }
}
