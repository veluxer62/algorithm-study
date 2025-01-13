package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordPatternTest {
    private final Solution sut = new Solution();

    /*

    Given a pattern and a string s, find if s follows the same pattern.

    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

    Each letter in pattern maps to exactly one unique word in s.
    Each unique word in s maps to exactly one letter in pattern.
    No two letters map to the same word, and no two words map to the same letter.


    Example 1:

    Input: pattern = "abba", s = "dog cat cat dog"

    Output: true

    Explanation:

    The bijection can be established as:

    'a' maps to "dog".
    'b' maps to "cat".
    Example 2:

    Input: pattern = "abba", s = "dog cat cat fish"

    Output: false

    Example 3:

    Input: pattern = "aaaa", s = "dog cat cat dog"

    Output: false



    Constraints:

    1 <= pattern.length <= 300
    pattern contains only lower-case English letters.
    1 <= s.length <= 3000
    s contains only lowercase English letters and spaces ' '.
    s does not contain any leading or trailing spaces.
    All the words in s are separated by a single space.

     */

    @Test
    public void test_wordPattern() {
        var pattern = "abba";
        var s = "dog cat cat dog";
        var actual = sut.wordPattern(pattern, s);
        assertTrue(actual);

        pattern = "abba";
        s = "dog cat cat fish";
        actual = sut.wordPattern(pattern, s);
        assertFalse(actual);

        pattern = "aaaa";
        s = "dog cat cat dog";
        actual = sut.wordPattern(pattern, s);
        assertFalse(actual);

        pattern = "abba";
        s = "dog dog dog dog";
        actual = sut.wordPattern(pattern, s);
        assertFalse(actual);

        pattern = "aaa";
        s = "aa aa aa aa";
        actual = sut.wordPattern(pattern, s);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean wordPattern(String pattern, String s) {
            var map1 = new HashMap<Character, String>();
            var map2 = new HashMap<String, Character>();

            var split = s.split(" ");

            if (split.length != pattern.length()) return false;

            for (var i = 0; i < pattern.length(); i++) {
                var c = pattern.charAt(i);
                var w = split[i];

                if (map1.containsKey(c)) {
                    if (!Objects.equals(map1.get(c), w)) {
                        return false;
                    }
                } else {
                    map1.put(c, split[i]);
                }

                if (map2.containsKey(w)) {
                    if (!Objects.equals(map2.get(w), c)) {
                        return false;
                    }
                } else {
                    map2.put(w, c);
                }
            }

            return true;
        }
    }
}
