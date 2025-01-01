package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddBinaryTest {
    private final Solution sut = new Solution();

    /*

    Given two binary strings a and b, return their sum as a binary string.



    Example 1:

    Input: a = "11", b = "1"
    Output: "100"
    Example 2:

    Input: a = "1010", b = "1011"
    Output: "10101"


    Constraints:

    1 <= a.length, b.length <= 104
    a and b consist only of '0' or '1' characters.
    Each string does not contain leading zeros except for the zero itself.

     */

    @Test
    public void test_addBinary() {
        var a = "11";
        var b = "1";
        var actual = sut.addBinary(a, b);
        assertEquals("100", actual);

        a = "1010";
        b = "1011";
        actual = sut.addBinary(a, b);
        assertEquals("10101", actual);
    }

    private static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder result = new StringBuilder();

            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;

            while (i >= 0 || j >= 0 || carry > 0) {
                int sum = carry;

                if (i >= 0) {
                    sum += a.charAt(i) - '0';
                    i--;
                }

                if (j >= 0) {
                    sum += b.charAt(j) - '0';
                    j--;
                }

                result.append(sum % 2);
                carry = sum / 2;
            }

            return result.reverse().toString();
        }
    }
}
