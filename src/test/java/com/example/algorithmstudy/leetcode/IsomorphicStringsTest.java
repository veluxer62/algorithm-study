package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsomorphicStringsTest {
    private final Solution sut = new Solution();

    /*

    Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



    Example 1:

    Input: s = "egg", t = "add"

    Output: true

    Explanation:

    The strings s and t can be made identical by:

    Mapping 'e' to 'a'.
    Mapping 'g' to 'd'.
    Example 2:

    Input: s = "foo", t = "bar"

    Output: false

    Explanation:

    The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

    Example 3:

    Input: s = "paper", t = "title"

    Output: true



    Constraints:

    1 <= s.length <= 5 * 104
    t.length == s.length
    s and t consist of any valid ascii character.

     */

    @Test
    public void test_isIsomorphic() {
        var s = "egg";
        var t = "add";
        var actual = sut.isIsomorphic(s, t);
        assertTrue(actual);

        s = "foo";
        t = "bar";
        actual = sut.isIsomorphic(s, t);
        assertFalse(actual);

        s = "paper";
        t = "title";
        actual = sut.isIsomorphic(s, t);
        assertTrue(actual);

        s = "badc";
        t = "baba";
        actual = sut.isIsomorphic(s, t);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) return false;

            var map = new HashMap<Character, Character>();
            var map2 = new HashMap<Character, Character>();
            var i = 0;

            while (i < s.length()) {
                var char1 = s.charAt(i);
                var char2 = t.charAt(i);

                if (map.containsKey(char1)) {
                    if (!map.get(char1).equals(char2)) {
                        return false;
                    }
                }
                if (map2.containsKey(char2)) {
                    if (!map2.get(char2).equals(char1)) {
                        return false;
                    }

                }


                map.putIfAbsent(char1, char2);
                map2.putIfAbsent(char2, char1);

                i++;
            }

            return true;
        }
    }
}
