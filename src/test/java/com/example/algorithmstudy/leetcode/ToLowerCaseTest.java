package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToLowerCaseTest {
    private final Solution sut = new Solution();

    /*

    Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.



    Example 1:

    Input: s = "Hello"
    Output: "hello"
    Example 2:

    Input: s = "here"
    Output: "here"
    Example 3:

    Input: s = "LOVELY"
    Output: "lovely"


    Constraints:

    1 <= s.length <= 100
    s consists of printable ASCII characters.

     */

    @Test
    public void test_toLowerCase() {
        var s = "Hello";
        var actual = sut.toLowerCase(s);
        assertEquals("hello", actual);

        s = "here";
        actual = sut.toLowerCase(s);
        assertEquals("here", actual);

        s = "LOVELY";
        actual = sut.toLowerCase(s);
        assertEquals("lovely", actual);
    }

    private static class Solution {
        public String toLowerCase(String s) {
            var sb = new StringBuilder();
           for (int i = 0; i < s.length(); i++) {
               var c = s.charAt(i);

               if(c >= 'A' && c <= 'Z')
                   sb.append((char)(c + 'a' - 'A'));
               else
                   sb.append(c);
           }

            return sb.toString();
        }
    }
}
