package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import static com.example.algorithmstudy.FunctionsKt.record;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidPalindromeTest {
    private final Solution sut = new Solution();

    /*
     * 주어진 문자열이 팰린드롬인지 확인하라. 대소문자를 구분하지 않으며, 영숫자(영문자와 숫자)만을 대상으로 한다.
     */

    @Test
    public void test_validPalindrome() {
        var actual = record(() -> sut.isPalindrome("Do geese see God?"));
        assertTrue(actual);

        actual = record(() -> sut.isPalindrome("This is test string."));
        assertFalse(actual);

        actual = record(() -> sut.isPalindrome("a".repeat(999999999)));
        assertTrue(actual);
    }

    @Test
    public void test_validPalindrome2() {
        var actual = record(() -> sut.isPalindrome2("Do geese see God?"));
        assertTrue(actual);

        actual = record(() -> sut.isPalindrome2("This is test string."));
        assertFalse(actual);

        actual = record(() -> sut.isPalindrome2("a".repeat(999999999)));
        assertTrue(actual);
    }

    public static class Solution {
        public boolean isPalindrome(String s) {
            var start = 0;
            var end = s.length() - 1;
            while (start < end) {
                if (!Character.isLetterOrDigit(s.charAt(start))) {
                    start++;
                    continue;
                }
                if (!Character.isLetterOrDigit(s.charAt(end))) {
                    end--;
                    continue;
                }

                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }

                start++;
                end--;
            }

            return true;
        }

        public boolean isPalindrome2(String s) {
            final var filtered = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            final var reversed = new StringBuilder(filtered).reverse().toString();
            return filtered.equals(reversed);
        }
    }
}
