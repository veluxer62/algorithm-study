package com.example.algorithmstudy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidAnagramTest {
    private final Solution sut = new Solution();

    /*
     * t가 s의 애너그램인지 판별하라.
     */

    @Test
    public void test_isAnagram() {
        var s = "anagram";
        var t = "nagrama";
        var actual = sut.isAnagram(s, t);
        assertTrue(actual);
    }

    private static class Solution {
        public boolean isAnagram(String s, String t) {
            return Objects.equals(sort(s), sort(t));
        }

        private String sort(String s) {
            var c = s.toCharArray();
            Arrays.sort(c);
            return String.valueOf(c);
        }
    }
}
