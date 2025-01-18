package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindromeTest {
    private final Solution sut = new Solution();

    /*

    Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

    Letters are case sensitive, for example, "Aa" is not considered a palindrome.



    Example 1:

    Input: s = "abccccdd"
    Output: 7
    Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
    Example 2:

    Input: s = "a"
    Output: 1
    Explanation: The longest palindrome that can be built is "a", whose length is 1.


    Constraints:

    1 <= s.length <= 2000
    s consists of lowercase and/or uppercase English letters only.

     */

    @Test
    public void test_longestPalindrome() {
        var s = "abccccdd";
        var actual = sut.longestPalindrome(s);
        assertEquals(7, actual);

        s = "a";
        actual = sut.longestPalindrome(s);
        assertEquals(1, actual);

        s = "ccc";
        actual = sut.longestPalindrome(s);
        assertEquals(3, actual);

        s = "bananas";
        actual = sut.longestPalindrome(s);
        assertEquals(5, actual);
    }

    @Test
    public void test_longestPalindrome2() {
        var s = "abccccdd";
        var actual = sut.longestPalindrome2(s);
        assertEquals(7, actual);

        s = "a";
        actual = sut.longestPalindrome2(s);
        assertEquals(1, actual);

        s = "ccc";
        actual = sut.longestPalindrome2(s);
        assertEquals(3, actual);

        s = "bananas";
        actual = sut.longestPalindrome2(s);
        assertEquals(5, actual);
    }

    @Test
    public void test_longestPalindrome3() {
        var s = "abccccdd";
        var actual = sut.longestPalindrome3(s);
        assertEquals(7, actual);

        s = "a";
        actual = sut.longestPalindrome3(s);
        assertEquals(1, actual);

        s = "ccc";
        actual = sut.longestPalindrome3(s);
        assertEquals(3, actual);

        s = "bananas";
        actual = sut.longestPalindrome3(s);
        assertEquals(5, actual);
    }

    private static class Solution {
        public int longestPalindrome(String s) {
            HashMap<Character, Integer> charCount = new HashMap<>();
            for (char c : s.toCharArray()) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }

            int maxLength = 0;
            boolean hasOdd = false;

            for (int count : charCount.values()) {
                if (count % 2 == 0) {
                    maxLength += count;
                } else {
                    maxLength += count - 1;
                    hasOdd = true;
                }
            }

            if (hasOdd) {
                maxLength++;
            }

            return maxLength;
        }

        public int longestPalindrome2(String s) {
            HashSet<Character> charSet = new HashSet<>();
            int length = 0;

            for (char c : s.toCharArray()) {
                if (charSet.contains(c)) {
                    charSet.remove(c);
                    length += 2;
                } else {
                    charSet.add(c);
                }
            }

            if (!charSet.isEmpty()) {
                length += 1;
            }

            return length;
        }

        public int longestPalindrome3(String s) {
            // length is 71 instead of 52 because ascii 'z' - 'A' = 71
            int[] letters = new int[71];
            int length = 0;

            for (char ch: s.toCharArray()){
                letters[ch-'A']++;
            }

            // 모든 값을 짝수로 변환
            // 3 & ~1 = 2
            for (int i = 0; i < 71; i++) {
                length += letters[i] & ~1;
            }

            return Math.min(s.length(), length+1);
        }
    }
}
