package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumWindowSubstringTest {
    private final Solution sut = new Solution();

    /*
     * 문자열 s와 t를 입력받아 O(n)에 t의 모든 문자가 포함된 s의 최소 윈도우를 찾아라.
     */

    @Test
    public void test_minWindow() {
        var s = "ABDOBECODEBANC";
        var t = "ABC";
        var acutal = sut.minWindow(s, t);
        assertEquals("BANC", acutal);
    }

    @Test
    public void test_minWindow2() {
        var s = "ABDOBECODEBANC";
        var t = "ABC";
        var acutal = sut.minWindow2(s, t);
        assertEquals("BANC", acutal);
    }

    private static class Solution {
        public String minWindow(String s, String t) {
            for (var windowSize = t.length(); windowSize < s.length() + 1; windowSize++) {
                for (var left = 0; left < s.length() - windowSize + 1; left++) {
                    var sSubStr = s.substring(left, left + windowSize);

                    if (contains(sSubStr, t))
                        return sSubStr;
                }
            }

            return "";
        }

        private boolean contains(String sSubStr, String t) {
            var sb = new StringBuilder(sSubStr);

            for (var elem : t.toCharArray()) {
                if (sb.indexOf(String.valueOf(elem)) != -1) {
                    sb.deleteCharAt(sb.indexOf(String.valueOf(elem)));
                } else {
                    return false;
                }
            }

            return true;
        }

        public String minWindow2(String s, String t) {
            var need = new HashMap<Character, Integer>();

            for (var c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            var missing = t.length();
            int left = 0, right = 0, start = 0, end = 0;
            var minLen = Integer.MAX_VALUE;

            for (var c : s.toCharArray()) {
                right++;

                if (need.containsKey(c) && need.get(c) > 0) {
                    missing--;
                }

                need.put(c, need.getOrDefault(c, 0) - 1);

                if (missing == 0) {
                    while (left < right && need.get(s.charAt(left)) < 0) {
                        need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1);
                        left++;
                    }

                    if (minLen > right - left + 1) {
                        minLen = right - left + 1;
                        start = left;
                        end = right;
                    }

                    need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1);
                    missing++;
                    left++;
                }
            }

            return s.substring(start, end);
        }
    }
}
