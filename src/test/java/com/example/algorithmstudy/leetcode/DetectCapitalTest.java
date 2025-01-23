package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DetectCapitalTest {
    private final Solution sut = new Solution();

    /*

    We define the usage of capitals in a word to be right when one of the following cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital, like "Google".
    Given a string word, return true if the usage of capitals in it is right.



    Example 1:

    Input: word = "USA"
    Output: true
    Example 2:

    Input: word = "FlaG"
    Output: false


    Constraints:

    1 <= word.length <= 100
    word consists of lowercase and uppercase English letters.

     */

    @Test
    public void test_detectCapitalUse() {
        var word = "USA";
        var actual = sut.detectCapitalUse(word);
        assertTrue(actual);

        word = "FlaG";
        actual = sut.detectCapitalUse(word);
        assertFalse(actual);

        word = "g";
        actual = sut.detectCapitalUse(word);
        assertTrue(actual);

        word = "ggg";
        actual = sut.detectCapitalUse(word);
        assertTrue(actual);
    }

    @Test
    public void test_detectCapitalUse2() {
        var word = "USA";
        var actual = sut.detectCapitalUse2(word);
        assertTrue(actual);

        word = "FlaG";
        actual = sut.detectCapitalUse2(word);
        assertFalse(actual);

        word = "g";
        actual = sut.detectCapitalUse2(word);
        assertTrue(actual);

        word = "ggg";
        actual = sut.detectCapitalUse2(word);
        assertTrue(actual);
    }

    private static class Solution {
        public boolean detectCapitalUse(String word) {
            var upper = word.toUpperCase();
            var lower = word.toLowerCase();

            if (word.equals(upper) || word.equals(lower)) {
                return true;
            }

            var capital = upper.charAt(0) + lower.substring(1);
            return capital.equals(word);
        }

        public boolean detectCapitalUse2(String word) {
            if (word == null || word.isEmpty()) {
                return false;
            }

            int n = word.length();
            boolean allCaps = true;
            boolean allLower = true;
            boolean firstCapOnly = Character.isUpperCase(word.charAt(0));

            for (int i = 0; i < n; i++) {
                if (Character.isLowerCase(word.charAt(i))) {
                    allCaps = false;
                } else {
                    allLower = false;
                    if (i > 0) {
                        firstCapOnly = false;
                    }
                }
            }

            return allCaps || allLower || firstCapOnly;
        }
    }
}
