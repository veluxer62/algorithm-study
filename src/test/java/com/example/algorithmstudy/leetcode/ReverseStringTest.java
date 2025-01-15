package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseStringTest {
    private final Solution sut = new Solution();

    /*

    Write a function that reverses a string. The input string is given as an array of characters s.

    You must do this by modifying the input array in-place with O(1) extra memory.



    Example 1:

    Input: s = ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]
    Example 2:

    Input: s = ["H","a","n","n","a","h"]
    Output: ["h","a","n","n","a","H"]


    Constraints:

    1 <= s.length <= 105
    s[i] is a printable ascii character.

     */

    @Test
    public void test_reverseString() {
        var s = new char[]{'h', 'e', 'l', 'l', 'o'};
        sut.reverseString(s);
        assertArrayEquals(
                new char[]{'o', 'l', 'l', 'e', 'h'},
                s
        );

        s = new char[]{'H','a','n','n','a','h'};
        sut.reverseString(s);
        assertArrayEquals(
                new char[]{'h','a','n','n','a','H'},
                s
        );
    }

    @Test
    public void test_reverseString2() {
        var s = new char[]{'h', 'e', 'l', 'l', 'o'};
        sut.reverseString2(s);
        assertArrayEquals(
                new char[]{'o', 'l', 'l', 'e', 'h'},
                s
        );

        s = new char[]{'H','a','n','n','a','h'};
        sut.reverseString2(s);
        assertArrayEquals(
                new char[]{'h','a','n','n','a','H'},
                s
        );
    }

    private static class Solution {
        public void reverseString(char[] s) {
            for (int i = 0; i < s.length / 2; i++) {
                s[i] += s[s.length - 1 - i];
                s[s.length - 1 - i] = (char) (s[i] - s[s.length - 1 - i]);
                s[i] = (char) (s[i] - s[s.length - 1 - i]);
            }
        }

        public void reverseString2(char[] s) {
            var left = 0;
            var right = s.length - 1;

            while (left < right) {
                var temp = s[left];
                s[left] = s[right];
                s[right] = temp;

                left++;
                right--;
            }
        }
    }
}
