package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordsInAStringIIITest {
    private final Solution sut = new Solution();

    /*

    Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.



    Example 1:

    Input: s = "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"
    Example 2:

    Input: s = "Mr Ding"
    Output: "rM gniD"


    Constraints:

    1 <= s.length <= 5 * 104
    s contains printable ASCII characters.
    s does not contain any leading or trailing spaces.
    There is at least one word in s.
    All the words in s are separated by a single space.

     */

    @Test
    public void test_reverseWords() {
        var s = "Let's take LeetCode contest";
        var actual = sut.reverseWords(s);
        assertEquals("s'teL ekat edoCteeL tsetnoc", actual);

        s = "Mr Ding";
        actual = sut.reverseWords(s);
        assertEquals("rM gniD", actual);
    }

    private static class Solution {
        public String reverseWords(String s) {
            var split = s.split(" ");
            var result = new StringBuilder();
            for (var w : split) {
                var rs = new StringBuilder(w).reverse().toString();
                result.append(rs);
                result.append(" ");
            }

            return result.substring(0, result.length() - 1);
        }
    }
}
