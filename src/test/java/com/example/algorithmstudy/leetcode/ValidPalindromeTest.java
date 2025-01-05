package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidPalindromeTest {
    private final Solution sut = new Solution();

    /*

    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.



    Example 1:

    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.
    Example 2:

    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.
    Example 3:

    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.


    Constraints:

    1 <= s.length <= 2 * 105
    s consists only of printable ASCII characters.

     */

    @Test
    public void test_isPalindrome() {
        var s = "A man, a plan, a canal: Panama";
        var actual = sut.isPalindrome(s);
        assertTrue(actual);

        s = "race a car";
        actual = sut.isPalindrome(s);
        assertFalse(actual);

        s = " ";
        actual = sut.isPalindrome(s);
        assertTrue(actual);
    }

    private static class Solution {
        public boolean isPalindrome(String s) {
            var replaced = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

            var i = 0;
            var j = replaced.length() - 1;
            while (i < j) {
                if (replaced.charAt(i) != replaced.charAt(j)) {
                    return false;
                }

                i++;
                j--;
            }

            return true;
        }
    }
}
