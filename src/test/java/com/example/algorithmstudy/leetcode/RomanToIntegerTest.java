package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToIntegerTest {
    private final Solution sut = new Solution();

    /*

    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer.



    Example 1:

    Input: s = "III"
    Output: 3
    Explanation: III = 3.
    Example 2:

    Input: s = "LVIII"
    Output: 58
    Explanation: L = 50, V= 5, III = 3.
    Example 3:

    Input: s = "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


    Constraints:

    1 <= s.length <= 15
    s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
    It is guaranteed that s is a valid roman numeral in the range [1, 3999].

     */

    @Test
    public void test_romanToInt() {
        var s = "III";
        var actual = sut.romanToInt(s);
        assertEquals(3, actual);

        s = "LVIII";
        actual = sut.romanToInt(s);
        assertEquals(58, actual);

        s = "MCMXCIV";
        actual = sut.romanToInt(s);
        assertEquals(1994, actual);
    }

    private static class Solution {
        private Map<String, Integer> map = new HashMap<>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }};

        public int romanToInt(String s) {
            var total = 0;
            var i = 0;

            while (i < s.length()) {
                // 현재 값이 다음 값보다 작은 경우 `다음값 - 현재값`으로 계산해야함
                if (i + 1 < s.length() && map.getOrDefault(String.valueOf(s.charAt(i)), 0) < map.getOrDefault(String.valueOf(s.charAt(i + 1)), 0)) {
                    total += map.getOrDefault(String.valueOf(s.charAt(i + 1)), 0) - map.getOrDefault(String.valueOf(s.charAt(i)), 0);
                    i += 2;
                } else {
                    total += map.getOrDefault(String.valueOf(s.charAt(i)), 0);
                    i++;
                }
            }

            return total;
        }
    }
}
