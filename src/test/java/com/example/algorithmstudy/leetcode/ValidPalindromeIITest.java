package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidPalindromeIITest {
    private final Solution sut = new Solution();

    /*

    Given a string s, return true if the s can be palindrome after deleting at most one character from it.



    Example 1:

    Input: s = "aba"
    Output: true
    Example 2:

    Input: s = "abca"
    Output: true
    Explanation: You could delete the character 'c'.
    Example 3:

    Input: s = "abc"
    Output: false


    Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters.

     */

    @Test
    public void test_validPalindrome() {
        var s = "aba";
        var actual = sut.validPalindrome(s);
        assertTrue(actual);

        s = "abca";
        actual = sut.validPalindrome(s);
        assertTrue(actual);

        s = "abc";
        actual = sut.validPalindrome(s);
        assertFalse(actual);

        s = "eceec";
        actual = sut.validPalindrome(s);
        assertTrue(actual);
    }

    @Test
    public void test_validPalindrome2() {
        var s = "aba";
        var actual = sut.validPalindrome2(s);
        assertTrue(actual);

        s = "abca";
        actual = sut.validPalindrome2(s);
        assertTrue(actual);

        s = "abc";
        actual = sut.validPalindrome2(s);
        assertFalse(actual);

        s = "eceec";
        actual = sut.validPalindrome2(s);
        assertTrue(actual);
    }

    private static class Solution {
        public boolean validPalindrome(String s) {
            var left = 0;
            var right = s.length() - 1;

            var deleteCount = 1;

            var result1 = true;
            var result2 = true;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    if (deleteCount > 0) {
                        deleteCount--;
                        left++;
                        if (s.charAt(left) != s.charAt(right)) {
                            result1 = false;
                            break;
                        }
                    } else {
                        result1 = false;
                        break;
                    }
                }

                left++;
                right--;
            }

            left = 0;
            right = s.length() - 1;
            deleteCount = 1;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    if (deleteCount > 0) {
                        deleteCount--;
                        right--;
                        if (s.charAt(left) != s.charAt(right)) {
                            result2 = false;
                            break;
                        }
                    } else {
                        result2 = false;
                        break;
                    }
                }

                left++;
                right--;
            }

            return result1 || result2;
        }

        public boolean validPalindrome2(String s) {
            int i = 0, j = s.length() - 1;

            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
                }
                i++;
                j--;
            }

            return true;
        }

        private boolean isPalindrome(String s, int i, int j) {

            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }

            return true;
        }
    }
}
