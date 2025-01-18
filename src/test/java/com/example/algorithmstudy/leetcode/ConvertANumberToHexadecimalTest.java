package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertANumberToHexadecimalTest {
    private final Solution sut = new Solution();

    @Test
    public void test_toHex() {
        var num = 26;
        var actual = sut.toHex(num);
        assertEquals("1a", actual);

        num = -1;
        actual = sut.toHex(num);
        assertEquals("ffffffff", actual);
    }

    private static class Solution {
        public String toHex(int num) {
            if (num == 0) {
                return "0";
            }

            char[] hexChars = "0123456789abcdef".toCharArray();

            StringBuilder hexString = new StringBuilder();

            while (num != 0) {
                int hexDigit = num & 0xf;
                hexString.append(hexChars[hexDigit]);

                num >>>= 4;
            }

            return hexString.reverse().toString();
        }
    }
}
