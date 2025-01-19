package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddStringsTest {
    private final Solution sut = new Solution();

    /*

    Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

    You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.



    Example 1:

    Input: num1 = "11", num2 = "123"
    Output: "134"
    Example 2:

    Input: num1 = "456", num2 = "77"
    Output: "533"
    Example 3:

    Input: num1 = "0", num2 = "0"
    Output: "0"


    Constraints:

    1 <= num1.length, num2.length <= 104
    num1 and num2 consist of only digits.
    num1 and num2 don't have any leading zeros except for the zero itself.

     */

    @Test
    public void test_addStrings() {
        var num1 = "11";
        var num2 = "123";
        var actual = sut.addStrings(num1, num2);
        assertEquals("134", actual);

        num1 = "456";
        num2 = "77";
        actual = sut.addStrings(num1, num2);
        assertEquals("533", actual);

        num1 = "0";
        num2 = "0";
        actual = sut.addStrings(num1, num2);
        assertEquals("0", actual);

        num1 = "6913259244";
        num2 = "71103343";
        actual = sut.addStrings(num1, num2);
        assertEquals("6984362587", actual);

        num1 = "3876620623801494171";
        num2 = "6529364523802684779";
        actual = sut.addStrings(num1, num2);
        assertEquals("10405985147604178950", actual);
    }

    private static class Solution {
        public String addStrings(String num1, String num2) {
            var sb = new StringBuilder();

            var i = num1.length() - 1;
            var j = num2.length() - 1;
            var carry = 0;

            while (i >= 0 || j >= 0 || carry != 0) {
                var n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                var n2 = j >= 0 ? num2.charAt(j) - '0' : 0;

                var sum = n1 + n2 + carry;
                carry = sum / 10;
                sb.append(sum % 10);

                i--;
                j--;
            }

            return sb.reverse().toString();
        }
    }
}
