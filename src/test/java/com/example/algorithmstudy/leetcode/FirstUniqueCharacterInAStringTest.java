package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstUniqueCharacterInAStringTest {
    private final Solution sut = new Solution();

    /*

    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.



    Example 1:

    Input: s = "leetcode"

    Output: 0

    Explanation:

    The character 'l' at index 0 is the first character that does not occur at any other index.

    Example 2:

    Input: s = "loveleetcode"

    Output: 2

    Example 3:

    Input: s = "aabb"

    Output: -1



    Constraints:

    1 <= s.length <= 105
    s consists of only lowercase English letters.

     */

    @Test
    public void test_firstUniqChar() {
        var s = "leetcode";
        var actual = sut.firstUniqChar(s);
        assertEquals(0, actual);

        s = "loveleetcode";
        actual = sut.firstUniqChar(s);
        assertEquals(2, actual);

        s = "aabb";
        actual = sut.firstUniqChar(s);
        assertEquals(-1, actual);
    }

    private static class Solution {
        public int firstUniqChar(String s) {
            var map = new HashMap<Character, Integer>();

            for (int i = 0; i < s.length(); i++) {
                var c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (int i = 0; i < s.length(); i++) {
                var c = s.charAt(i);
                if (map.containsKey(c) && map.get(c) == 1) {
                    return i;
                }
            }

            return -1;
        }
    }
}
