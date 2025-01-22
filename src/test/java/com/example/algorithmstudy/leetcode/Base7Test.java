package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Base7Test {
    private final Solution sut = new Solution();

    /*

    Given an integer num, return a string of its base 7 representation.



    Example 1:

    Input: num = 100
    Output: "202"
    Example 2:

    Input: num = -7
    Output: "-10"


    Constraints:

    -107 <= num <= 107

     */

    @Test
    public void test_convertToBase7() {
        var num = 100;
        var actual = sut.convertToBase7(num);
        assertEquals("202", actual);

        num = -7;
        actual = sut.convertToBase7(num);
        assertEquals("-10", actual);

        num = 0;
        actual = sut.convertToBase7(num);
        assertEquals("0", actual);
    }

    private static class Solution {
        public String convertToBase7(int num) {
            if (num == 0) return "0";

            var sb = new StringBuilder();

            boolean isNegative = num < 0;

            num = Math.abs(num);

            while (num > 0) {
                sb.append(num % 7);
                num /= 7;
            }

            if (isNegative) {
                sb.append("-");
            }

            return sb.reverse().toString();
        }
    }
}
