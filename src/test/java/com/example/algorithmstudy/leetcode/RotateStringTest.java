package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RotateStringTest {
    private final Solution sut = new Solution();

    /*

    Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

    A shift on s consists of moving the leftmost character of s to the rightmost position.

    For example, if s = "abcde", then it will be "bcdea" after one shift.


    Example 1:

    Input: s = "abcde", goal = "cdeab"
    Output: true
    Example 2:

    Input: s = "abcde", goal = "abced"
    Output: false


    Constraints:

    1 <= s.length, goal.length <= 100
    s and goal consist of lowercase English letters.

     */

    @Test
    public void test_rotateString() {
        var s = "abcde";
        var goal = "cdeab";
        var actual = sut.rotateString(s, goal);
        assertTrue(actual);

        s = "abcde";
        goal = "abced";
        actual = sut.rotateString(s, goal);
        assertFalse(actual);
    }

    @Test
    public void test_rotateString2() {
        var s = "abcde";
        var goal = "cdeab";
        var actual = sut.rotateString2(s, goal);
        assertTrue(actual);

        s = "abcde";
        goal = "abced";
        actual = sut.rotateString2(s, goal);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.equals(goal)) return true;

            for (int i = 1; i < s.length(); i++) {
                var pre = s.substring(0, i);
                var sur = s.substring(i);

                if ((sur + pre).equals(goal)) {
                    return true;
                }
            }

            return false;
        }

        public boolean rotateString2(String s, String goal) {
            if (s.length() != goal.length()) return false;

            return (s + s).contains(goal);
        }
    }
}
