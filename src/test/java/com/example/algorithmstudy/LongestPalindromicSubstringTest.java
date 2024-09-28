package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindromicSubstringTest {
    private final Solution sut = new Solution();

    /*
     * 가장 긴 팰린드롬 부분 문자열을 출력하라.
     */

    @Test
    public void test_longestPalindrome() {
        var str = "dcbabcdd";
        var actual = sut.longestPalindrome(str);
        assertEquals("dcbabcd", actual);
    }

    private static class Solution {
        int left, maxLen;

        public String longestPalindrome(String s) {
            if (s.length() < 2) return s;

            for (int i = 0; i < s.length() - 1; i++) {
                extendPalindrome(s, i, i + 1);
                extendPalindrome(s, i, i + 2);
            }

            return s.substring(left, left + maxLen);
        }

        private void extendPalindrome(String s, int i, int j) {
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }

            if (maxLen < j - i - 1) {
                left = i + 1;
                maxLen = j - i - 1;
            }
        }
    }

    /*
    0
    --
    i = 0 = d
    j = 1 = c
    0 >= 0 && 1 < 8 && d == c
    0 < 1 - 0 - 1
    left = 0
    maxLen = 0

    i = 0 = d
    j = 2 = b
    0 >= 0 && 2 < 8 && d == b
    0 < 2 - 0 - 1
    left = 1
    maxLen = 1


    1
    --
    i = 1 = c
    j = 2 = b
    1 >= 0 && 2 < 8 && c == b
    1 < 2 - 1 - 1
    left = 1
    maxLen = 1

    i = 1 = c
    j = 3 = a
    1 >= 0 && 3 < 8 && c == a
    1 < 3 - 1 - 1
    left = 1
    maxLen = 1


    2
    --
    i = 2 = b
    j = 3 = a
    2 >= 0 && 3 < 8 && b == a
    1 < 3 - 2 - 1
    left = 1
    maxLen = 1

    i = 2 = b
    j = 4 = b
    2 >= 0 && 4 < 8 && b == b
    i = 1 = c
    j = 5 = c
    1 >= 0 && 5 < 8 && c == c
    i = 0 = d
    i = 6 = d
    0 >= 0 && 6 < 8 && d == d
    i = -1
    i = 7 = d
    -1 >= 0 && 7 < 8

    1 = 7 + 1 - 1
    left = 0
    maxLen = 7


    3
    --
    i = 3 = a
    j = 4 = b
    3 >= 0 && 4 < 8 && a == b
    7 < 4 - 3 - 1
    left = 0
    maxLen = 7

    i = 3 = a
    j = 5 = c
    3 >= 0 && 5 < 8 && a == c
    7 < 5 - 3 - 1
    left = 0
    maxLen = 7


    4
    --
    i = 4 = b
    j = 5 = c
    4 >= 0 && 5 < 8 && b == c
    7 < 5 - 4 -1
    left = 0
    maxLen = 7

    i = 4 = b
    j = 6 = d
    4 >= 0 && 6 < 8 && b == d
    7 < 6 - 4 - 1
    left = 0
    maxLen = 7


    5
    --
    i = 5 = c
    j = 6 = d
    5 >= 0 && 6 < 8 && c == d
    7 < 6 - 5 - 1
    left = 0
    maxLen = 7

    i = 5 = c
    j = 7 = d
    5 >= 0 && 7 < 8 && c == d
    7 < 7 - 5 - 1
    left = 0
    maxLen = 7


    6
    --
    i = 6 = d
    j = 7 = d
    6 >= 0 && 7 < 8 && d == d
    i = 5 = c
    j = 8
    5 >= 0 && 8 < 8
    7 < 8 - 5 - 1
    left = 0
    maxLen = 7


    7
    --
    i = 7 = d
    j = 8
    7 >= 0 && 8 < 8
    7 < 8 - 7 - 1
    left = 0
    maxLen = 7

    i = 7 = d
    j = 9
    7 >= 0 && 9 < 8
    7 < 9 - 7 - 1
    left = 0
    maxLen = 7
     */
}
