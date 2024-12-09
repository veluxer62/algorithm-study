package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeNumberTest {
    private final Solution sut = new Solution();

    /*
        Given an integer x, return true if x is a palindrome, and false otherwise.

        Example 1:

        Input: x = 121
        Output: true
        Explanation: 121 reads as 121 from left to right and from right to left.
        Example 2:

        Input: x = -121
        Output: false
        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
        Example 3:

        Input: x = 10
        Output: false
        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


        Constraints:

        -231 <= x <= 231 - 1

     */

    @Test
    public void test_isPalindrome() {
        var x = 121;
        var actual = sut.isPalindrome(x);
        assertTrue(actual);

        x = -121;
        actual = sut.isPalindrome(x);
        assertFalse(actual);

        x = 10;
        actual = sut.isPalindrome(x);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean isPalindrome(int x) {
            var str = String.valueOf(x);

            for (var i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    return false;
                }
            }

            return true;
        }
    }
}
