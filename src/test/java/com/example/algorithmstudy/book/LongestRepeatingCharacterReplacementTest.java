package com.example.algorithmstudy.book;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestRepeatingCharacterReplacementTest {
    private final Solution sut = new Solution();

    /*
     * 대문자로 구성된 문자열 s가 주어졌을 때 k번만큼의 변경으로 만들 수 있는 연속으로 반복된 문자열의 가장 긴 길이를 출력하라.
     */

    @Test
    public void test_replace() {
        var s = "AAABBCD";
        var k = 2;
        var actual = sut.replace(s, k);
        assertEquals(5, actual);
    }

    private static class Solution {
        public int replace(String s, int k) {
            var left = 0;
            var counts = new HashMap<Character, Integer>();

            for (var right = 1; right <= s.length(); right++) {
                counts.put(s.charAt(right - 1), counts.getOrDefault(s.charAt(right - 1), 0) + 1);

                var maxCharCount = Collections.max(counts.values());

                if (right - left - maxCharCount > k) {
                    counts.put(s.charAt(left), counts.getOrDefault(s.charAt(left), 0) - 1);
                    left++;
                }
            }

            return s.length() - left;
        }
    }
}
