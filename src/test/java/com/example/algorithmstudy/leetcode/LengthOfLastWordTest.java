package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthOfLastWordTest {
    private final Solution sut = new Solution();

    /*

    Given a string s consisting of words and spaces, return the length of the last word in the string.

    A word is a maximal
    substring
     consisting of non-space characters only.



    Example 1:

    Input: s = "Hello World"
    Output: 5
    Explanation: The last word is "World" with length 5.
    Example 2:

    Input: s = "   fly me   to   the moon  "
    Output: 4
    Explanation: The last word is "moon" with length 4.
    Example 3:

    Input: s = "luffy is still joyboy"
    Output: 6
    Explanation: The last word is "joyboy" with length 6.


    Constraints:

    1 <= s.length <= 104
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.

     */

    @Test
    public void test_lengthOfLastWord() {
        var s = "Hello World";
        var actual = sut.lengthOfLastWord(s);
        assertEquals(5, actual);

        s = "   fly me   to   the moon  ";
        actual = sut.lengthOfLastWord(s);
        assertEquals(4, actual);

        s = "luffy is still joyboy";
        actual = sut.lengthOfLastWord(s);
        assertEquals(6, actual);
    }

    private static class Solution {
        public int lengthOfLastWord(String s) {
            var trimed = s.trim();
            var result = 0;

            for (int i = trimed.length() - 1; i >= 0; i--) {
                if (trimed.charAt(i) == ' ') break;
                result++;
            }

            return result;
        }
    }
}
