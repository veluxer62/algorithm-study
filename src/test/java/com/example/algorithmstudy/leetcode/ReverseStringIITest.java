package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringIITest {
    private final Solution sut = new Solution();

    /*

    Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

    If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.



    Example 1:

    Input: s = "abcdefg", k = 2
    Output: "bacdfeg"
    Example 2:

    Input: s = "abcd", k = 2
    Output: "bacd"


    Constraints:

    1 <= s.length <= 104
    s consists of only lowercase English letters.
    1 <= k <= 104

     */

    @Test
    public void test_reverseStr() {
        var s = "abcdefg";
        var k = 2;
        var actual = sut.reverseStr(s, k);
        assertEquals("bacdfeg", actual);

        s = "abcd";
        k = 2;
        actual = sut.reverseStr(s, k);
        assertEquals("bacd", actual);
    }

    private static class Solution {
        public String reverseStr(String s, int k) {
            char[] arr = s.toCharArray();
            int n = arr.length;

            for (int i = 0; i < n; i += 2 * k) {
                int start = i;
                int end = Math.min(i + k - 1, n - 1);

                while (start < end) {
                    char temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                }
            }

            return new String(arr);
        }
    }
}
