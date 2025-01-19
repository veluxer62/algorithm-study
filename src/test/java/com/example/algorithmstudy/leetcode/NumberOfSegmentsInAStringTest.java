package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfSegmentsInAStringTest {
    private final Solution sut = new Solution();

    /*

    Given a string s, return the number of segments in the string.

    A segment is defined to be a contiguous sequence of non-space characters.



    Example 1:

    Input: s = "Hello, my name is John"
    Output: 5
    Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
    Example 2:

    Input: s = "Hello"
    Output: 1


    Constraints:

    0 <= s.length <= 300
    s consists of lowercase and uppercase English letters, digits, or one of the following characters "!@#$%^&*()_+-=',.:".
    The only space character in s is ' '.

     */

    @Test
    public void test_countSegments() {
        var s = "Hello, my name is John";
        var actual = sut.countSegments(s);
        assertEquals(5, actual);

        s = "Hello";
        actual = sut.countSegments(s);
        assertEquals(1, actual);

        s = ", , , ,        a, eaefa";
        actual = sut.countSegments(s);
        assertEquals(6, actual);

        s = "          ";
        actual = sut.countSegments(s);
        assertEquals(0, actual);

        s = "    foo    bar";
        actual = sut.countSegments(s);
        assertEquals(2, actual);
    }

    private static class Solution {
        public int countSegments(String s) {
            s = s.trim();
            if (s.isEmpty()) return 0;

            return s.split("\\s+").length;
        }
    }
}
